package com.gto.util;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * 为java集合框架(List|Set|Map)提供的辅助类
 */
public interface CollectionUtil {

    /**
     * 判断集合为null或者size 为0
     *
     * @param t
     * @param <T>
     * @return
     */
    static <T extends Collection> boolean isNullOrEmpty(T t) {
        return t == null || t.size() == 0;
    }

    /**
     * 判断K-V集合为null或者size 为0
     *
     * @param t
     * @param <T>
     * @return
     */
    static <T extends Map> boolean isNullOrEmpty(T t) {
        return t == null || t.size() == 0;
    }

    /**
     * 增强的foreach lambda表达示，支持下标
     *
     * @param elements
     * @param action
     * @param <E>
     * @eg: forEach(list, ( i, s) -> System.out.println(i + ":" + s));
     */
    static <E> void forEach(Iterable<? extends E> elements, BiConsumer<Integer, ? super E> action) {
        Objects.requireNonNull(elements);
        Objects.requireNonNull(action);
        int index = 0;
        for (E element : elements) {
            action.accept(index++, element);
        }
    }

}
