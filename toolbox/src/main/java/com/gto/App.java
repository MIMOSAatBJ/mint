package com.gto;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

/**
 * 所有工具类都可以在此运行，查看效果
 */
public class App {
    static class Node {
        private String name;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.setName("test");
        node.setCode("code");
        Map<String, String> map = null;
        try {
            map = BeanUtils.describe(node);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(map.size());
        Map<String,String> sortedMap= new TreeMap<>(map);
        sortedMap.forEach((k,v)->
            System.out.println(k+":"+v)
        );
        System.out.println();
    }
}
