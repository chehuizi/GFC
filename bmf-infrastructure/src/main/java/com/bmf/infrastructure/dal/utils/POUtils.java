package com.bmf.infrastructure.dal.utils;

import com.bmf.base.BaseModel;
import com.bmf.infrastructure.dal.po.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PO工具类
 */
public class POUtils {

    /**
     * 模型对象转持久化对象
     * @param src
     * @param dstClass
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R extends BaseModel, T extends BasePO> T convert(R src, Class<T> dstClass) {
        if (Objects.isNull(src)) {
            return null;
        }
        try {
            T dst = dstClass.newInstance();
            BeanUtils.copyProperties(src, dst);
            return dst;
        } catch (Exception ex) {

        }
        return null;
    }

    /**
     * 持久化对象转模型对象
     * @param src
     * @param dstClass
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R extends BasePO, T extends BaseModel> T convert(R src, Class<T> dstClass) {
        if (Objects.isNull(src)) {
            return null;
        }
        try {
            T dst = dstClass.newInstance();
            BeanUtils.copyProperties(src, dst);
            return dst;
        } catch (Exception ex) {

        }
        return null;
    }

    /**
     * 持久化对象列表转模型对象列表
     * @param srcList
     * @param dstClass
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R extends BasePO, T extends BaseModel> List<T> convert(List<R> srcList, Class<T> dstClass) {
        if (Objects.isNull(srcList) || srcList.size() <= 0) {
            return null;
        }
        try {
            List<T> dstList = new ArrayList<>();
            for (R item : srcList) {
                T dst = dstClass.newInstance();
                BeanUtils.copyProperties(item, dst);
                dstList.add(dst);
            }

            return dstList;
        } catch (Exception ex) {

        }
        return null;
    }

    /**
     * 模型对象列表转持久化对象列表
     * @param srcList
     * @param dstClass
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R extends BaseModel, T extends BasePO> List<T> convertModel2PO(List<R> srcList, Class<T> dstClass) {
        if (Objects.isNull(srcList) || srcList.size() <= 0) {
            return null;
        }
        try {
            List<T> dstList = new ArrayList<>();
            for (R item : srcList) {
                T dst = dstClass.newInstance();
                BeanUtils.copyProperties(item, dst);
                dstList.add(dst);
            }

            return dstList;
        } catch (Exception ex) {

        }
        return null;
    }
}
