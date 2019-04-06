package com.gto.base;

import com.google.gson.Gson;

/**
 * 实现此接口即获得转json的方法
 */

public interface JsonAble {
    Gson gson = new Gson();

    default String toJsonStr() {
        return gson.toJson(this);
    }

}
