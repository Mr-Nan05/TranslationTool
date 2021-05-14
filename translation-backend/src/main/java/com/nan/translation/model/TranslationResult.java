package com.nan.translation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.alibaba.fastjson.JSONObject;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationResult {
    private String from;

    private String to;

    private String src;

    private String dst;

    public TranslationResult(String result){
        JSONObject resultParser = JSONObject.parseObject(result);
        from = resultParser.getString("from");
        to = resultParser.getString("to");

        JSONObject parser = JSONObject.parseObject(resultParser.getJSONArray("trans_result").get(0).toString());
        src = parser.getString("src");
        dst = parser.getString("dst");

    }
}
