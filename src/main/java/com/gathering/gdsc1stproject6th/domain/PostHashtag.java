package com.gathering.gdsc1stproject6th.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
public class PostHashtag extends BaseEntity{

    //게시물 해시태그 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostHashtagId;

    //게시글 정보(ID)
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private Post post;

    //해시태그 정보(ID)
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hashtagId")
    private Hashtag hashtag;

}
