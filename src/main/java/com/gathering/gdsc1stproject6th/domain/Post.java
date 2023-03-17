package com.gathering.gdsc1stproject6th.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
public class Post extends BaseEntity{

    // 게시글번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    //제목
    @Column(nullable = false)
    private String title;

    //채팅링크
    @Column(nullable = false)
    private String chatLink;

    //모집인원
    @Column(nullable = false)
    private Integer userLen;

    //현재모집원
    @Column(nullable = false)
    private List<User> members;

    //모임시간
    @Column(nullable = true)
    private String meetTime;

    //모임장소
    @Column(nullable = true)
    private String meetPlace;

    //기타 내용
    @Column(nullable = true)
    private String content;

    //빨리빨리 유무
    @Column(nullable = false)
    private Boolean fastYN;

    //활성화 유무
    @Column(nullable = true)
    private Boolean activeYN;

    //글쓴이
    @ManyToOne(optional = false) @JoinColumn(name = "userId")
    private User user;

    //카테고리 번호
    @ManyToOne(optional = false) @JoinColumn(name = "categoryId")
    private Category category;
}
