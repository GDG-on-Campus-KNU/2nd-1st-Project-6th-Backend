package com.gathering.gdsc1stproject6th.repository;

import com.gathering.gdsc1stproject6th.domain.PostHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostHashtagRepository extends JpaRepository<PostHashtag, Long> {

    @Query("SELECT p FROM PostHashtag p WHERE p.post.postId = :post_id")
    List<PostHashtag> findAllHashtagId(@Param("post_id") Long postId);

    @Query("SELECT p FROM PostHashtag p WHERE p.post.postId = :post_id AND p.hashtag.hashtagId = : hashtag_id")
    Optional<PostHashtag> findByPostIdAndHashtagId(@Param("post_id") Long postId, @Param("hashtag_id") Long hashtag_id);
}
