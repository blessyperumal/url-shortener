package com.example.urlShortener.service;

import com.example.urlShortener.model.ShortURL;
import com.example.urlShortener.repository.ShortURLRepository;
import com.google.common.hash.Hashing;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class URLShortenerService {
    @Autowired
    ShortURLRepository shortURLRepository;

    public ShortURL createShortURL(String longURL) {
        ShortURL shortURL = generateShortURL(longURL);
        return shortURLRepository.save(shortURL);
    }

    public ShortURL getOriginalURL(String shortURL) {
        List<ShortURL> shortURLList = shortURLRepository.findByShortURL(shortURL);
        return shortURLList.stream().findAny()
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortURL));
    }

    private ShortURL generateShortURL(String longURL) {
        return new ShortURL.ShortURLBuilder(longURL,
                Hashing.sha256()
                .hashString(longURL, StandardCharsets.UTF_8)
                .toString())
                .build();

    }






}
