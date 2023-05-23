package com.gathering.gdsc1stproject6th.controller;


import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.dto.response.PostHashtagResponse;
import com.gathering.gdsc1stproject6th.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostController {

    private final PostService postService;

    @PostMapping("/save")
    @ResponseBody
    public Long savePost(@RequestBody PostDto postDto) {

        Long postId = postService.savePost(postDto);


        return postId;
    }

    //post 상세 정보 보기


    //post 목록 보기

    //post update

    //post delete
}