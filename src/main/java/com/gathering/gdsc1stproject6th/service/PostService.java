package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.domain.*;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.repository.CategoryRepository;
import com.gathering.gdsc1stproject6th.repository.PostRepository;
import com.gathering.gdsc1stproject6th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    //게시글 저장
    @Transactional
    public Long savePost(PostDto postDto) {
        User user = userRepository.getReferenceById(postDto.getUserDto().getUserId());

        Category category = categoryRepository.getReferenceById((postDto.getCategoryDto().getCategoryId()));

        Post post = postDto.toEntity(user, category);

        return postRepository.save(post).getPostId();
    }

    //게시글 상세 정보 보기
    @Transactional
    public PostDto findByPostId (Long postId) {
        Post postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + postId));

        return PostDto.from(postEntity);
    }

    //post 전체 목록 보기
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }


}
