package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostHashtagServiceTest {

    @Autowired
    PostHashtagService postHashtagService;

    @Autowired
    HashtagRepository hashtagRepository;

    @Test
    void savePostHashtag() {
        Long postId = 7L;
        Set<HashtagDto> hashtagDtos = new HashSet<>();

        HashtagDto hashtagDto3 = HashtagDto.from(hashtagRepository.findById(3L).get());
        HashtagDto hashtagDto4 = HashtagDto.from(hashtagRepository.findById(4L).get());

        hashtagDtos.add(hashtagDto3);
        hashtagDtos.add(hashtagDto4);


        postHashtagService.savePostHashtag(postId, hashtagDtos);

    }
}