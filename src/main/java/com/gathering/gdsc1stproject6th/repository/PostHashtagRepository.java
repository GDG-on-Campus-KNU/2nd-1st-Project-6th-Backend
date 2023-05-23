package com.gathering.gdsc1stproject6th.repository;

import com.gathering.gdsc1stproject6th.domain.PostHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostHashtagRepository extends JpaRepository<PostHashtag, Long> {

    @Query("SELECT p.hashtag_id FROM post_hashtag p WHERE p.post_id = postId")
    List<Long> findAllHashtagId(@Param("postId") Long postId);
}
