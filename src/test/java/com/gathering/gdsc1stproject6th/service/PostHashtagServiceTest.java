package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.User;
import com.gathering.gdsc1stproject6th.dto.CategoryDto;
import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.dto.UserDto;
import com.gathering.gdsc1stproject6th.repository.CategoryRepository;
import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import com.gathering.gdsc1stproject6th.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class PostHashtagServiceTest {

    @Autowired
    PostHashtagService postHashtagService;

    @Autowired
    HashtagRepository hashtagRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private HashtagService hashtagService;

    @Autowired
    private PostService postService;

    @Test
    void savePostHashtag() {
        Long postId = 7L;
        Set<HashtagDto> hashtagDtos = new HashSet<>();

        HashtagDto hashtagDto3 = HashtagDto.from(hashtagRepository.findById(6L).get());
        HashtagDto hashtagDto4 = HashtagDto.from(hashtagRepository.findById(7L).get());

        hashtagDtos.add(hashtagDto3);
        hashtagDtos.add(hashtagDto4);


        postHashtagService.savePostHashtag(postId, hashtagDtos);

    }

    //게시글 해시태그 저장 통합 테스트
    @Test
    void makePostData() {

        //post
        User user = User.builder()
                .userId(4L)
                .userLv(1L)
                .userNm("아무개")
                .userNickname("amogae")
                .userEmail("amogae@knu.ac.kr")
                .userPhoneNumber("01098765432")
                .build();

        userRepository.save(user);

        Category category = Category.builder()
                .categoryId(3L)
                .categoryNm("study")
                .build();

        categoryRepository.save(category);

        UserDto userDto = UserDto.from(user);

        CategoryDto categoryDto = CategoryDto.from(category);

        PostDto postDto = PostDto.builder()
                .postId(9L)
                .title("스프링 스터디원 모집")
                .chatLink("https://www.acmicpc.net/11")
                .userLen(3)
                .curUserLen(1)
                .meetTime("8시")
                .meetPlace("남구")
                .content("자세한건 인원 모이면 정할게요")
                .fastYN(true)
                .activeYN(true)
                .userDto(userDto)
                .categoryDto(categoryDto)
                .build();

        long postId = postService.savePost(postDto);


        //해시태그
        String hashtagString = "#공부#sutdy#spring";
        Set<String> hashtags = hashtagService.parseHashtagNames(hashtagString);
        Set<HashtagDto> hashtagDtos = hashtagService.saveHashtag(hashtags, postId);


        postHashtagService.savePostHashtag(postId, hashtagDtos);
    }
}
