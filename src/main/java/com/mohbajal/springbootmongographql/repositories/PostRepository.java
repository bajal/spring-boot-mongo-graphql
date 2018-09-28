package com.mohbajal.springbootmongographql.repositories;

import com.mohbajal.springbootmongographql.daos.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, String> {
}
