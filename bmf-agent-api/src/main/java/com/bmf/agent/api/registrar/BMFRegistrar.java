package com.bmf.agent.api.registrar;

import com.bmf.agent.api.utils.HttpUtil;
import com.bmf.api.application.dto.BusinessApiCmdReqDTO;
import com.bmf.base.annotations.BusinessApi;
import com.bmf.base.annotations.DomainService;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * BMF注册器
 */
@Component
public class BMFRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;
    /**
     * 容器环境
     */
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry, importBeanNameGenerator);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 创建scanner
        ClassPathScanningCandidateComponentProvider scanner = buildScanner();
        scanner.setResourceLoader(resourceLoader);
        // 设置scanner的过滤条件
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(DomainService.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        // 获取指定扫描的包
        Set<String> basePackages = getBasePackages(importingClassMetadata);

        List<com.bmf.base.application.BusinessApi> businessApiList = new ArrayList<>();
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
            for (BeanDefinition candidateComponent : candidateComponents) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                    Set<MethodMetadata> methodMetadataSet = annotationMetadata.getAnnotatedMethods(BusinessApi.class.getCanonicalName());
                    for (MethodMetadata methodMetadata : methodMetadataSet) {
                        com.bmf.base.application.BusinessApi businessApi = buildBusinessApi(methodMetadata);
                        businessApiList.add(businessApi);
                    }
                }
            }
        }

        if (businessApiList.size() > 0) {
            BusinessApiCmdReqDTO businessApiCmdReqDTO = new BusinessApiCmdReqDTO();
            businessApiCmdReqDTO.setBusinessApiList(businessApiList);
            HttpUtil.post(businessApiCmdReqDTO);
        }
    }

    /**
     * 构建类路径扫描器
     * @return
     */
    private ClassPathScanningCandidateComponentProvider buildScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent() &&
                    !beanDefinition.getMetadata().isAnnotation()) {
                    isCandidate = true;
                }
                return isCandidate;
            }
        };
    }

    /**
     * 获取扫描包集合
     * @param importingClassMetadata
     * @return
     */
    private Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableBMFScan.class.getCanonicalName());
        assert attributes != null;
        Set<String> basePackages = new HashSet<>();
        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        if (basePackages.isEmpty()) {
            basePackages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }
        return basePackages;
    }

    /**
     * 构建业务API对象
     * @param methodMetadata
     * @return
     */
    private com.bmf.base.application.BusinessApi buildBusinessApi(MethodMetadata methodMetadata) {
        Map<String, Object> methodAttrMap = methodMetadata.getAnnotationAttributes(BusinessApi.class.getCanonicalName());
        com.bmf.base.application.BusinessApi businessApi = new com.bmf.base.application.BusinessApi();
        businessApi.setApiPath(methodMetadata.getDeclaringClassName());
        businessApi.setApiName(methodMetadata.getMethodName());
        businessApi.setApiDesc("test");
        businessApi.setServiceCode((Integer) methodAttrMap.get("serviceCode"));
        businessApi.setServiceAlias(methodAttrMap.get("serviceAlias").toString());
        return businessApi;
    }
}
