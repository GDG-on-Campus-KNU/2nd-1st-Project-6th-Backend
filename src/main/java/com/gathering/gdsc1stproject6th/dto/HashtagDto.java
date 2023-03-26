package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.Hashtag;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HashtagDto {

    //해시태그 번호
    private Long hashtagId;

    //해시태그 이름
    private String hashtagNm;

    //언급수
    private Integer tagCount;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    public static HashtagDto from(Hashtag entity) {
        return new HashtagDto(
                entity.getHashtagId(),
                entity.getHashtagNm(),
                entity.getTagCount(),
                entity.getCreatedAt(),
                entity.getDeleteAt(),
                entity.getUpdateAt()
        );
    }

}
