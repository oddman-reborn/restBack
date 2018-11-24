package com.monir.back.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/")
public class BackController {

    RestTemplate template=new RestTemplate();

    @RequestMapping(value = "")
    public String viewIndex()
    {
        System.out.println("Controller got call");
        return "index";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String insertUser(HttpEntity<String> httpEntity)
    {
        System.out.println("Data recv....");

        System.out.println("JSON DATA :"+httpEntity.getHeaders().get("name"));
        System.out.println("JSON DATA :"+httpEntity.getClass());
        System.out.println("JSON DATA :"+httpEntity.getBody().trim());

        return "ok";
    }
    
}
