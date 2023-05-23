package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.domain.Hashtag;
import com.gathering.gdsc1stproject6th.domain.PostHashtag;
import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import com.gathering.gdsc1stproject6th.repository.PostHashtagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    private final PostHashtagRepository postHashtagRepository;

    //string으로 들어온 해시태그들 하나씩 나누어서 set으로 반환
    public Set<String> parseHashtagNames(String hashtagString) {
        if (hashtagString == null) return Set.of();

        Pattern pattern = Pattern.compile("#[\\w가-힣]+");
        Matcher matcher = pattern.matcher(hashtagString.strip());
        Set<String> result = new HashSet<>();

        while (matcher.find()) {
            result.add(matcher.group().replace("#", ""));
        }

        return Set.copyOf(result);
    }

    //Set<String> 해시태그들 생성 및 저장 후, Set<HashtagDto>으로 반환
    public Set<HashtagDto> saveHashtag(Set<String> hashtags, Long postId) {
        Set<HashtagDto> hashtagDtos = new HashSet<>();
        HashtagDto newHashtagDto = new HashtagDto();

        for (String hashtag : hashtags) {
            Optional<Hashtag> hashtag1 = hashtagRepository.findByHashtagNm(hashtag);
            if(hashtag1.isEmpty()) {
                Hashtag newHashtag = Hashtag.builder()
                        .hashtagNm(hashtag)
                        .tagCount(1)
                        .build();

                hashtagRepository.save(newHashtag);

                newHashtagDto = HashtagDto.from(newHashtag);
            } else {
                //게시글과 게시글에 해당하는 해시태그가 이미 매핑 되어 있는지 확인하기 위해 체크
                Optional<PostHashtag> curPresent = postHashtagRepository.findByPostIdAndHashtagId(postId, hashtag1.get().getHashtagId());
                if(curPresent.isEmpty()) {
                    //tagCount 1증가 update
                    addHashtagTagCount(hashtag1);
                }
                newHashtagDto = HashtagDto.from(hashtag1.get());
            }
            hashtagDtos.add(newHashtagDto);
        }

        return Set.copyOf(hashtagDtos);
    }

    //해시태그 존재하는 경우, tagCount +1 업데이트
    private void addHashtagTagCount(Optional<Hashtag> hashtag1) {
        hashtag1.get().addTagCount();
        hashtagRepository.save(hashtag1.get());
    }

}
