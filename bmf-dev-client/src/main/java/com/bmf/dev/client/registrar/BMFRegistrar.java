package com.bmf.dev.client.registrar;

import com.bmf.dev.annotations.DomainService;
import com.bmf.dev.annotations.DomainServiceClass;
import com.bmf.dev.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.dev.client.utils.HttpUtil;
import com.bmf.dev.model.application.DomainApp;
import com.bmf.dev.model.application.DomainAppApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(BMFRegistrar.class);

    private static final String ANNOTATION_NAME_DOMAIN_APP = "com.bmf.dev.annotations.Domain";

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
        try {
            Map<String, Object> attrs = importingClassMetadata.getAnnotationAttributes(ANNOTATION_NAME_DOMAIN_APP);
            DomainApp domainApp = buildDomainApp(attrs);
            // 创建scanner
            ClassPathScanningCandidateComponentProvider scanner = buildScanner();
            // 获取指定扫描的包
            Set<String> basePackages = getBasePackages(importingClassMetadata);
            // 获取领域API
            List<DomainAppApi> domainAppApiList = scanDomainApi(scanner, basePackages, domainApp);
            // 上报领域API
            if (domainAppApiList.size() > 0) {
                report(domainApp, domainAppApiList);
            }
        } catch (Exception ex) {
            logger.error("bmf scan error!", ex);
        }
    }

    /**
     * 构建领域应用
     * @param attrs
     * @return
     */
    private DomainApp buildDomainApp(Map<String, Object> attrs) {
        DomainApp domainApp = new DomainApp();
        domainApp.setAppId((Integer) attrs.get("appId"));
        domainApp.setAppName((String) attrs.get("appName"));
        domainApp.setAppDesc((String) attrs.get("appDesc"));
        domainApp.setDomainCode((Integer) attrs.get("domainCode"));
        domainApp.setDomainAlias((String) attrs.get("domainAlias"));
        return domainApp;
    }

    /**
     * 构建类路径扫描器
     * @return
     */
    private ClassPathScanningCandidateComponentProvider buildScanner() {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false, environment) {
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
        scanner.setResourceLoader(resourceLoader);
        // 设置scanner的过滤条件
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(DomainServiceClass.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        return scanner;
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
     * 扫描领域API
     * @param scanner
     * @param basePackages
     * @param domainApp
     * @return
     */
    private List<DomainAppApi> scanDomainApi(ClassPathScanningCandidateComponentProvider scanner,
                                             Set<String> basePackages,
                                             DomainApp domainApp) {
        List<DomainAppApi> domainAppApiList = new ArrayList<>();
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
            for (BeanDefinition candidateComponent : candidateComponents) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                    Set<MethodMetadata> methodMetadataSet = annotationMetadata.getAnnotatedMethods(DomainService.class.getCanonicalName());
                    for (MethodMetadata methodMetadata : methodMetadataSet) {
                        DomainAppApi domainAppApi = buildBusinessApi(domainApp, methodMetadata);
                        domainAppApiList.add(domainAppApi);
                    }
                }
            }
        }
        return domainAppApiList;
    }

    /**
     * 构建业务API对象
     * @param methodMetadata
     * @return
     */
    private DomainAppApi buildBusinessApi(DomainApp domainApp, MethodMetadata methodMetadata) {
        Map<String, Object> methodAttrMap = methodMetadata.getAnnotationAttributes(DomainService.class.getCanonicalName());
        DomainAppApi domainAppApi = new DomainAppApi();
        domainAppApi.setAppId(domainApp.getAppId());
        domainAppApi.setAppName(domainApp.getAppName());
        domainAppApi.setApiPath(methodMetadata.getDeclaringClassName());
        domainAppApi.setApiName(methodMetadata.getMethodName());
        domainAppApi.setApiDesc("test");
        domainAppApi.setDomainCode(domainApp.getDomainCode());
        domainAppApi.setDomainAlias(domainApp.getDomainAlias());
        domainAppApi.setElementCode((Integer) methodAttrMap.get("serviceCode"));
        domainAppApi.setElementAlias(methodAttrMap.get("serviceAlias").toString());
        return domainAppApi;
    }

    /**
     * 上报
     * @param domainApp
     * @param domainAppApiList
     */
    private void report(DomainApp domainApp, List<DomainAppApi> domainAppApiList) {
        DomainAppCmdReqDTO domainAppCmdReqDTO = new DomainAppCmdReqDTO();
        domainAppCmdReqDTO.setDomainApp(domainApp);
        domainAppCmdReqDTO.setDomainAppApiList(domainAppApiList);
        HttpUtil.post(domainAppCmdReqDTO);
    }
}
