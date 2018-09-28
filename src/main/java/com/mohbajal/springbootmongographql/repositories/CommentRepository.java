package com.mohbajal.springbootmongographql.repositories;

import com.mohbajal.springbootmongographql.daos.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {
}
