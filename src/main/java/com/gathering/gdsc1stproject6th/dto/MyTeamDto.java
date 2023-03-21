package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.MyTeamStatus;
import com.gathering.gdsc1stproject6th.domain.Post;
import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyTeamDto {

    //내모임 번호
    private Long myTeamId;

    //가입 상태
    private MyTeamStatus status;

    //게시글 번호
    private PostDto postDto;

    //회원번호
    private UserDto userDto;
}
