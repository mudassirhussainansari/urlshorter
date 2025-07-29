package com.urlshorter.urlshorterproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urlshorter.urlshorterproject.service.UrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/url")
public class UrlController {
    
    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String createShortUrl(@RequestParam String orignalUrl){
        return urlService.createShortUrl(orignalUrl);
    }

    @GetMapping("{shortUrl}")
    public String getOrignalUrl(@PathVariable String shortUrl) {
        String orignalUrl = urlService.getOrignalUrl(shortUrl);
        if (orignalUrl == null) {
            return "Url not found";
        } 
        return "Here is the : "+orignalUrl;
    }
    



}
