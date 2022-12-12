package com.example.urlShortener.repository;

import com.example.urlShortener.model.ShortURL;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortURLRepository extends ListCrudRepository<ShortURL, Long> {

    List<ShortURL> findByShortURL(String shortURL);
}
