/*
 * Copyright [2020] [ispong]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ispong.oxygen.core.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

/**
 * http Marker
 *
 * @author ispong
 * @since 0.0.1
 */
@Slf4j
public class HttpMarker {

    /**
     * 执行get请求
     *
     * @param url           get请求地址
     * @param requestParams 请求参数
     * @param targetClass   目标Class
     * @param <A>           A
     * @return target
     * @throws IOException 访问失败
     * @since 0.0.1
     */
    public static <A> A doGet(String url, Map<String, String> requestParams, Class<A> targetClass) throws IOException {

        // 拼接get接口请求后缀
        StringBuilder requestBody = new StringBuilder("?");
        requestParams.forEach((k, v) -> requestBody.append(k).append("=").append(v).append("&"));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        String result = new RestTemplate().exchange(url + requestBody.toString(), HttpMethod.GET, requestEntity, String.class).getBody();

        return new ObjectMapper().readValue(result, targetClass);
    }

    /**
     * 执行post请求
     *
     * @param url           url
     * @param requestParams requestParams
     * @param headParams    请求头
     * @return post body str
     * @throws IOException 访问失败
     * @since 0.0.1
     */
    public static String doPost(String url, Map<String, String> headParams, Object requestParams) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        if (headParams != null) {
            headParams.forEach(headers::add);
        }

        HttpEntity<String> requestEntity = new HttpEntity<>(new ObjectMapper().writeValueAsString(requestParams), headers);
        return new RestTemplate().exchange(url, HttpMethod.POST, requestEntity, String.class).getBody();
    }
}

