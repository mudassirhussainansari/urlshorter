package com.urlshorter.urlshorterproject.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshorter.urlshorterproject.model.Url;
import com.urlshorter.urlshorterproject.repository.UrlRepository;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    private static final String BASE_URL = "http://localhost:8080/";

    private static final String CHARSET ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int shortUrlLength = 6;

    public String createShortUrl(String orignalString){

        String shortUrl = generateShortUrl();

        Url url = new Url();
        url.setOrignalUrl(orignalString);
        url.setShortUrl(shortUrl);
        urlRepository.save(url);

        return shortUrl;
    }


    private static String generateShortUrl(){

        Random random = new Random();
        StringBuilder shortUrl = new StringBuilder(shortUrlLength);

        for(int i=0; i<shortUrlLength; i++){
            int index = random.nextInt(CHARSET.length());
            shortUrl.append(CHARSET.charAt(index));
        }

        return shortUrl.toString();
    }

    public String getOrignalUrl(String shortUrl){
        Url url  = urlRepository.findByShortUrl(shortUrl);
        return url != null ?  url.getOrignalUrl() :  null;
    }

}
