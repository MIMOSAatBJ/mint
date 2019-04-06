package com.gto.global;

import com.gto.base.JsonAble;

/**
 * 全局异常
 */
public class GlobalException extends RuntimeException implements JsonAble {

//    private static final Integer CARRY = 0X3E8;
//
//    public GlobalException(Dict.Module m, Dict.Factor factor, Throwable e) {
//        this.code = m.getSn() * CARRY + factor.getCode();
//        this.info = factor.getInfo() + e.getMessage();
//    }
//
//    public GlobalException(Dict.Module m, Dict.Factor factor) {
//        this.code = m.getSn() * CARRY + factor.getCode();
//        this.info = factor.getInfo();
//    }

    private Integer code;
    private String info;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return toJsonStr();
    }
}
