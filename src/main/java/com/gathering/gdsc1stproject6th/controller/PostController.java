package com.gathering.gdsc1stproject6th.controller;


import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.dto.response.PostHashtagResponse;
import com.gathering.gdsc1stproject6th.service.HashtagService;
import com.gathering.gdsc1stproject6th.service.PostHashtagService;
import com.gathering.gdsc1stproject6th.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostController {

    private final PostService postService;
    private final PostHashtagService postHashtagService;
    private final HashtagService hashtagService;

    @PostMapping("/save")
    @ResponseBody
    public Long savePost(@RequestBody PostDto postDto) {

        Long postId = postService.savePost(postDto);


        return postId;
    }

    //post 상세 정보 보기
    @GetMapping("/{id}")
    public PostHashtagResponse findByPostId(@PathVariable Long id) {
        PostDto postDto = postService.findByPostId(id);
        System.out.println("postDto");
        List<HashtagDto> hashtagDtos = postHashtagService.findByPostId(id);
        System.out.println("hashtagDtos");

        return new PostHashtagResponse(postDto, hashtagDtos);
    }

    //post 목록 보기

    //post update

    //post delete
}
