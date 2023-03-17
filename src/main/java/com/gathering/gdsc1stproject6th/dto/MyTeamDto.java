package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.MyTeamStatus;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyTeamDto {

    //내모임 번호
    private Long myTeamId;

    //게시글 번호
    private Long postId;

    //가입 상태
    private MyTeamStatus status;

    //회원번호
    private Long userId;
}
