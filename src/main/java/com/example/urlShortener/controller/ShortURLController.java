package com.example.urlShortener.controller;

import com.example.urlShortener.model.LongURLRequest;
import com.example.urlShortener.model.ShortURL;
import com.example.urlShortener.service.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ShortURLController {

    @Autowired
    URLShortenerService urlShortenerService;

    /**@Autowired
    ShortURLRepository repo;**/

    @RequestMapping(value="/shortURL", method= RequestMethod.POST)
    public ShortURL createShortURL(@RequestBody LongURLRequest longURLRequest) {
        return urlShortenerService.createShortURL(longURLRequest.getLongURL());
    }

    @RequestMapping(value="/shortURL/{shortURL}", method=RequestMethod.GET)
    @ResponseBody
    public ShortURL getURL(@PathVariable(value = "shortURL") String shortURL) {
        return urlShortenerService.getOriginalURL(shortURL);

    }
    
}
