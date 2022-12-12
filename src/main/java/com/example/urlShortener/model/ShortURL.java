package com.example.urlShortener.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
public class ShortURL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String longURL;
    private  String shortURL;
    private Date creationDate;
    protected ShortURL () {}

    public long getId() {
        return id;
    }

    public String getShortURL() {
        return shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortURL shortURL1 = (ShortURL) o;
        return id.equals(shortURL1.id) && longURL.equals(shortURL1.longURL) && shortURL.equals(shortURL1.shortURL) && creationDate.equals(shortURL1.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longURL, shortURL, creationDate);
    }

    private ShortURL(ShortURLBuilder builder) {
        this.longURL = builder.longURL;
        this.shortURL = builder.shortURL;
        this.creationDate = builder.creationDate;
    }


    public static class ShortURLBuilder {
        private final String longURL;
        private final String shortURL;
        private final Date creationDate;

        public ShortURLBuilder(String longURL, String shortURL) {
            this.longURL = longURL;
            this.shortURL = shortURL;
            this.creationDate = Date.from(Instant.now());
        }

        public ShortURL build() {
            ShortURL shortURL = new ShortURL(this);
            return shortURL;
        }
    }
}
