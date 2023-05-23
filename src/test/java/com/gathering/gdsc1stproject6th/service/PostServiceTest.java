package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.User;
import com.gathering.gdsc1stproject6th.dto.CategoryDto;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.dto.UserDto;
import com.gathering.gdsc1stproject6th.repository.CategoryRepository;
import com.gathering.gdsc1stproject6th.repository.PostRepository;
import com.gathering.gdsc1stproject6th.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    void savePost() {
        //give
        User user = User.builder()
                .userId(3L)
                .userLv(1L)
                .userNm("김대영")
                .userNickname("kdy")
                .userEmail("kdy@knu.ac.kr")
                .userPhoneNumber("01012345678")
                .build();

        userRepository.save(user);

        Category category = Category.builder()
                .categoryId(2L)
                .categoryNm("exercise")
                .build();

        categoryRepository.save(category);


        UserDto userDto = UserDto.from(user);

        CategoryDto categoryDto = CategoryDto.from(category);

        PostDto postDto = PostDto.builder()
                .postId(7L)
                .title("축구원 모집")
                .chatLink("https://www.acmicpc.net/problem/12865")
                .userLen(11)
                .curUserLen(1)
                .meetTime("5시")
                .meetPlace("수성구")
                .content("축구 좋아하시는분 모두 환영")
                .fastYN(true)
                .activeYN(true)
                .userDto(userDto)
                .categoryDto(categoryDto)
                .build();


        //when
        long postId = postService.savePost(postDto);

        //then


    }
}