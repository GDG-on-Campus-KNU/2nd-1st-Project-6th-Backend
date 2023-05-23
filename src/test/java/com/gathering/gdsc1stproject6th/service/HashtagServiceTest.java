package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;


@SpringBootTest
class HashtagServiceTest {

    @Autowired
    private HashtagService hashtagService;

    public static Set<String> hashtags;


    @Test
    void parseHashtagNames() {
        //given
        String hashtagString = "#soccer#soccers";

        //when
        hashtags = hashtagService.parseHashtagNames(hashtagString);

        //then
    }

    @Test
    void saveHashtag() {
        //given

        //when
        hashtagService.saveHashtag(hashtags);

        //then
    }
}