package com.nan.translation.service;

import com.nan.translation.utils.HttpGet;
import com.nan.translation.utils.MD5;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LanguageService {
    private static final String TRANS_API_HOST = "https://fanyi-api.baidu.com/api/trans/vip/language";

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20210513000825318";
    private static final String SECURITY_KEY = "yzJRQfRLUZNBZpdCoxMT";


    public String getLangResult(String query) {
        Map<String, String> params = buildParams(query);
        return HttpGet.get(TRANS_API_HOST, params);
    }

    private Map<String, String> buildParams(String query) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("appid", APP_ID);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = APP_ID + query + salt + SECURITY_KEY; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }
}
