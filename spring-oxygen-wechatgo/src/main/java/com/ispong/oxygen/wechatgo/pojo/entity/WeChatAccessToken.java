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
 *
 */
package com.ispong.oxygen.wechatgo.pojo.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * 微信的token对象
 *
 * @author ispong
 * @since  0.0.1
 */
@Data
public class WeChatAccessToken {

    /**
     * 	获取到的凭证
     */
    @JsonSetter("access_token")
    private String accessToken;

    /**
     * 凭证有效时间，单位：秒
     */
    @JsonSetter("expires_in")
    private Integer expiresIn;

    /**
     * 错误返回码
     */
    @JsonSetter("errcode")
    private Integer errCode = 0;

    /**
     * 错误说明
     */
    @JsonSetter("errmsg")
    private String errMsg;
}
