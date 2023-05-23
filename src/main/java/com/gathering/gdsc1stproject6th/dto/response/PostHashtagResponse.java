package com.gathering.gdsc1stproject6th.dto.response;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.Hashtag;
import com.gathering.gdsc1stproject6th.domain.Post;
import com.gathering.gdsc1stproject6th.domain.User;
import com.gathering.gdsc1stproject6th.dto.CategoryDto;
import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import com.gathering.gdsc1stproject6th.dto.UserDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostHashtagResponse {

    private Long postId;

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
    private UserDto user;

    //카테고리 번호
    private CategoryDto category;

    //해시태그들
    private List<HashtagDto> hashtagDtos;


    public PostHashtagResponse (PostDto postEntity, List<Hashtag> hashtags) {
        this.postId = postEntity.getPostId();
        this.title = postEntity.getTitle();
        this.chatLink = postEntity.getChatLink();
        this.userLen = postEntity.getUserLen();
        this.curUserLen = postEntity.getCurUserLen();
        this.meetTime = postEntity.getMeetTime();
        this.meetPlace = postEntity.getMeetPlace();
        this.content = postEntity.getContent();
        this.fastYN = postEntity.getFastYN();
        this.activeYN = postEntity.getActiveYN();
        this.user = postEntity.getUserDto();
        this.category = postEntity.getCategoryDto();

        this.hashtagDtos = new ArrayList<>();
        for(Hashtag h : hashtags) {
            this.hashtagDtos.add(new HashtagDto().from(h));
        }
    }

}
