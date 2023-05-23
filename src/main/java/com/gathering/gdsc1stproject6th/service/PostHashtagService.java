package com.gathering.gdsc1stproject6th.service;


import com.gathering.gdsc1stproject6th.domain.Hashtag;
import com.gathering.gdsc1stproject6th.domain.Post;
import com.gathering.gdsc1stproject6th.domain.PostHashtag;
import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import com.gathering.gdsc1stproject6th.repository.PostHashtagRepository;
import com.gathering.gdsc1stproject6th.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    //조회 게시글에 해당하는 해시태그들 찾기
    @Transactional
    public List<HashtagDto> findByPostId (Long postId) {
        List<HashtagDto> hashtagDtos = new ArrayList<>();

        for(PostHashtag p : postHashtagRepository.findAllHashtagId(postId)) {
            hashtagDtos.add(HashtagDto.from(p.getHashtag()));
        }

        return hashtagDtos;
    }
}
