package com.nan.translation.model;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResult {
    private String error_code;

    private String error_msg;

    private String src;

    public LanguageResult(String result){
        JSONObject resultParser = JSONObject.parseObject(result);
        error_code = resultParser.getString("error_code");
        error_msg = resultParser.getString("error_msg");

        if(error_code.equals("0")){
            JSONObject parser = JSONObject.parseObject(resultParser.getJSONObject("data").toString());
            src = parser.getString("src");
        }else src = "error";

    }
}
