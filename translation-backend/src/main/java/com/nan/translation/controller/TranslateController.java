package com.nan.translation.controller;


import com.nan.translation.model.LanguageResult;
import com.nan.translation.model.TranslationResult;
import com.nan.translation.service.LanguageService;
import com.nan.translation.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path="/")
public class TranslateController {
    private final TranslateService translateService;
    private final LanguageService languageService;

    @Autowired
    public TranslateController(TranslateService translate, LanguageService language) {
        this.translateService = translate;
        this.languageService = language;
    }

    @RequestMapping(path="/translate")
    public  @ResponseBody
    TranslationResult translate(@RequestParam Map<String,Object> params){
        String to = "en";

        if(params.containsKey("to"))
            to = params.get("to").toString();

        return new TranslationResult(translateService.getTransResult(params.get("text").toString(), to));
    }

    @RequestMapping(path="/language")
    public  @ResponseBody
    LanguageResult language(@RequestParam Map<String,Object> params){
        return new LanguageResult(languageService.getLangResult(params.get("text").toString()));
    }


}
