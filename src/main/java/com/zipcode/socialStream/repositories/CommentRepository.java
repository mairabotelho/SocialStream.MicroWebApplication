package com.zipcode.socialStream.repositories;

import com.zipcode.socialStream.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> getAllByVideoId(Long videoId);
    List<Comment> getAllByCommentId(Long commentId);
}
