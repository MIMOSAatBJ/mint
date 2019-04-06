package com.gto.util;


import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

/**
 * 发送http工具类，依赖jodd-http
 *
 * @see {https://jodd.org/http}
 */
public interface HttpUtil {

    /**
     * 发送get请求
     *
     * @param url
     * @return
     */
    static HttpResponse get(String url) {
        return HttpRequest.get(url).send();
    }

}
