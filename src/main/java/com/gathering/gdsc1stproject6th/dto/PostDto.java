package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.Post;
import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    // 게시글 번호
    private Long postId;

    //제목
    private String title;

    //채팅링크
    private String chatLink;

    //모집인원
    private Integer userLen;

    //현재모집인원
    private Integer curUserLen;

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
    private UserDto userDto;

    //카테고리 번호
    private CategoryDto categoryDto;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    public Post toEntity(User user, Category category) {
        Post post = Post.builder()
                .postId(postId)
                .title(title)
                .chatLink(chatLink)
                .userLen(userLen)
                .curUserLen(curUserLen)
                .meetTime(meetTime)
                .meetPlace(meetPlace)
                .content(content)
                .fastYN(fastYN)
                .activeYN(activeYN)
                .user(user)
                .category(category)
                .build();

        return post;
    }
}
