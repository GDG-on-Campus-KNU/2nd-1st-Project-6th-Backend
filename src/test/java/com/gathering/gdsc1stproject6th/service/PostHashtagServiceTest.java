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

import static org.junit.jupiter.api.Assertions.*;

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

        HashtagDto hashtagDto3 = HashtagDto.from(hashtagRepository.findById(3L).get());
        HashtagDto hashtagDto4 = HashtagDto.from(hashtagRepository.findById(4L).get());

        hashtagDtos.add(hashtagDto3);
        hashtagDtos.add(hashtagDto4);


        postHashtagService.savePostHashtag(postId, hashtagDtos);

    }

    //게시글 해시태그 저장 통합 테스트
    @Test
    void makePostData() {

        //post
        User user = User.builder()
                .userId(2L)
                .userLv(2L)
                .userNm("김대영")
                .userNickname("kdozlo")
                .build();

        userRepository.save(user);

        Category category = Category.builder()
                .categoryId(1L)
                .categoryNm("exercise")
                .build();

        categoryRepository.save(category);

        UserDto userDto = UserDto.builder()
                .userId(2L)
                .userLv(2L)
                .userNm("김대영")
                .userNickname("kdozlo")
                .build();

        CategoryDto categoryDto = CategoryDto.builder()
                .categoryId(1L)
                .categoryNm("exercise")
                .build();

        PostDto postDto = PostDto.builder()
                .title("농구원 구함")
                .chatLink("https://www.acmicpc.net")
                .userLen(5)
                .curUserLen(1)
                .meetTime("6시")
                .meetPlace("북구청")
                .content("가자")
                .fastYN(true)
                .activeYN(true)
                .userDto(userDto)
                .categoryDto(categoryDto)
                .build();

        long postId = postService.savePost(postDto);


        //해시태그
        String hashtagString = "#basketball#농구";
        Set<String> hashtags = hashtagService.parseHashtagNames(hashtagString);

        Set<HashtagDto> hashtagDtos = hashtagService.saveHashtag(hashtags);
        
        for(HashtagDto hashtagDto : hashtagDtos) {
            System.out.println("hashtagDto.getHashtagId() = " + hashtagDto.getHashtagId());
        }

        postHashtagService.savePostHashtag(postId, hashtagDtos);
    }
}