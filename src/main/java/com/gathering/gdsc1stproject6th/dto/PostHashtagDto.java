package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.Hashtag;
import com.gathering.gdsc1stproject6th.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostHashtagDto {

    //게시물 해시태그 번호
    private Long PostHashtagId;

    //게시글 정보(ID)
    private Post post;

    //해시태그 정보(ID)
    private Hashtag hashtag;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;
}
