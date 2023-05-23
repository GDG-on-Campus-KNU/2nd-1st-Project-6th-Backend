package com.gathering.gdsc1stproject6th.controller;

import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.service.HashtagService;
import com.gathering.gdsc1stproject6th.service.PostHashtagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RequestMapping("/hashtag")
@Controller
public class HashtagController {

    private final HashtagService hashtagService;
    private final PostHashtagService postHashtagService;

    @PostMapping("/save/{postId}")
    @ResponseBody
    public Long saveHashtag(@RequestBody String hashtagString, @PathVariable Long postId) {

        Set<String> hashtags = hashtagService.parseHashtagNames(hashtagString);

        Set<HashtagDto> hashtagDtos = hashtagService.saveHashtag(hashtags);

        postHashtagService.savePostHashtag(postId, hashtagDtos);

        return postId;
    }
}
