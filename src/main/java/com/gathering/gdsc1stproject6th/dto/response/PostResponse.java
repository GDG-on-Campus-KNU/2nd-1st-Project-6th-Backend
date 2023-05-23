package com.gathering.gdsc1stproject6th.dto.response;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.User;
import com.gathering.gdsc1stproject6th.dto.CategoryDto;
import com.gathering.gdsc1stproject6th.dto.HashtagDto;
import com.gathering.gdsc1stproject6th.dto.PostDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    // 게시글 번호
    private Long postId;

    //제목
    private String title;

    //모집인원
    private Integer userLen;

    //현재모집인원
    private Integer curUserLen;

    //빨리빨리 유무
    private Boolean fastYN;

    //활성화 유무
    private Boolean activeYN;

    //카테고리 번호
    private CategoryDto categoryDto;

    public PostResponse (PostDto postDto) {
        this.postId = postDto.getPostId();
        this.title = postDto.getTitle();
        this.userLen = postDto.getUserLen();
        this.curUserLen = postDto.getCurUserLen();
        this.fastYN = postDto.getFastYN();
        this.activeYN = postDto.getActiveYN();
        this.categoryDto = postDto.getCategoryDto();
    }
}
