package com.example.urlShortener;

import com.example.urlShortener.model.ShortURL;
import com.example.urlShortener.repository.ShortURLRepository;
import com.example.urlShortener.service.URLShortenerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class URLShortenerServiceTest {

    @Mock
    ShortURLRepository mockRepository;

    @InjectMocks
    URLShortenerService mockService;

    @Test
    public void createShortURLTest() {

        ShortURL shortURL = new ShortURL.ShortURLBuilder("Hello World!", "foofoo").build();

        when(mockRepository.save(any(ShortURL.class))).thenReturn(shortURL);
        var longUrl = "https://anyrandom.longurl";
        assertEquals(shortURL, mockService.createShortURL(longUrl));

    }

    @Test
    void getOriginalURLTest() {

        ShortURL fooAgain = new ShortURL.ShortURLBuilder("Hello World Again!", "fooAgain").build();
        when(mockRepository.findByShortURL(any(String.class)))
         .thenReturn(Collections.singletonList(fooAgain));

        assertEquals(fooAgain, mockService.getOriginalURL("foo"));
    }
}
