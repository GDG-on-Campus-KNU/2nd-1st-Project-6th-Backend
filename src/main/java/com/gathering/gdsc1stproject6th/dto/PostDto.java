package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long postId;

    //제목
    private String title;

    //채팅링크
    private String chatLink;

    //모집인원
    private Integer userLen;

    //현재모집원
    private List<User> members;

    //모임시간
    private String meetTime;

    //모임장소
    private String meetPlace;

    //기타 내용
    private String content;

    //빨리빨리 유무
    private Boolean fastYN;

    //활성화 유무
    private Boolean activeYN;

    //글쓴이
    private User user;

    //카테고리 번호
    private Category category;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;
}
