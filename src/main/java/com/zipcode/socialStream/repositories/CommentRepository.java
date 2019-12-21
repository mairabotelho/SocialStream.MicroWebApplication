package com.zipcode.socialStream.repositories;

import com.zipcode.socialStream.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
