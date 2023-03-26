package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.Post;
import com.gathering.gdsc1stproject6th.domain.User;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.repository.CategoryRepository;
import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import com.gathering.gdsc1stproject6th.repository.PostRepository;
import com.gathering.gdsc1stproject6th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PostService {
    private final HashtagService hashtagService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final HashtagRepository hashtagRepository;

    private final CategoryRepository categoryRepository;

    public Long savePost(PostDto postDto) {
        User user = userRepository.getReferenceById(postDto.getUserDto().getUserId());

        Category category = categoryRepository.getReferenceById((postDto.getCategoryDto().getCategoryId()));

        postDto.setActiveYN(true);

        Post post = postDto.toEntity(user, category);

        postRepository.save(post);

        return post.getPostId();
    }



}
