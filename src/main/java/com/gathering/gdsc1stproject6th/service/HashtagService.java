package com.gathering.gdsc1stproject6th.service;

import com.gathering.gdsc1stproject6th.domain.Hashtag;
import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;

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
    public Set<HashtagDto> saveHashtag(Set<String> hashtags) {
        Set<HashtagDto> hashtagDtos = new HashSet<>();

        for (String hashtag : hashtags) {
            Optional<Hashtag> hashtag1 = hashtagRepository.findByHashtagNm(hashtag);
            if(hashtag1.isEmpty()) {
                Hashtag newHashtag = Hashtag.builder()
                        .hashtagNm(hashtag)
                        .tagCount(1)
                        .build();

                hashtagRepository.save(newHashtag);

                HashtagDto newHashtagDto = new HashtagDto();
                newHashtagDto.from(newHashtag);

                hashtagDtos.add(newHashtagDto);
            } else {
                //tagCount 1증가 update
            }
        }

        return Set.copyOf(hashtagDtos);
    }


}
