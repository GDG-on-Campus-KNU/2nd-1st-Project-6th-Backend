package com.gathering.gdsc1stproject6th.service;


import com.gathering.gdsc1stproject6th.domain.Hashtag;
import com.gathering.gdsc1stproject6th.domain.Post;
import com.gathering.gdsc1stproject6th.domain.PostHashtag;
import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import com.gathering.gdsc1stproject6th.repository.PostHashtagRepository;
import com.gathering.gdsc1stproject6th.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PostHashtagService {

    private final PostRepository postRepository;
    private final PostHashtagRepository postHashtagRepository;
    private final HashtagRepository hashtagRepository;


    //post hashtag mapping 저장
    public void savePostHashtag(Long postId, Set<HashtagDto> hashtagDtos) {
        for (HashtagDto hashtagDto : hashtagDtos) {
            Optional<Post> post = postRepository.findById(postId);
            Optional<Hashtag> hashtag = hashtagRepository.findById(hashtagDto.getHashtagId());

            if(post.isPresent() && hashtag.isPresent()) {
                Post post1 = post.get();
                Hashtag hashtag1 =hashtag.get();
                PostHashtag postHashtag = PostHashtag.builder()
                        .post(post1)
                        .hashtag(hashtag1)
                        .build();

                postHashtagRepository.save(postHashtag);
            }
        }
    }


    //게시글 상세 조회
    @Transactional
    public List<Long> findByPostId (Long postId) {
        return postHashtagRepository.findAllHashtagId(postId);
    }
}
