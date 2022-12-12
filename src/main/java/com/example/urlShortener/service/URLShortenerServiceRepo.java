package com.example.urlShortener.service;

import com.example.urlShortener.model.ShortURL;
import com.example.urlShortener.repository.ShortURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class URLShortenerServiceRepo {
    @Autowired
    ShortURLRepository shortURLRepository;

    public ShortURL createShortURL(String longURL) {
        ShortURL shortURL = generateShortURL(longURL);
        return shortURLRepository.save(shortURL);
    }

    public List<ShortURL> getShortURL(String shortURL) {
        return shortURLRepository.findByShortURL(shortURL);
    }

    private ShortURL generateShortURL(String longURL) {
        int hashCode = longURL.hashCode();
        return new ShortURL.ShortURLBuilder(longURL, String.valueOf(hashCode)).build();

    }




}
