package com.mohbajal.springbootmongographql.config;

import java.util.ArrayList;
import java.util.List;

import com.mohbajal.springbootmongographql.daos.Post;
import com.mohbajal.springbootmongographql.daos.PostDao;
import com.mohbajal.springbootmongographql.resolvers.Mutation;
import com.mohbajal.springbootmongographql.resolvers.PostResolver;

import com.mohbajal.springbootmongographql.resolvers.PostsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;


@Configuration
public class GraphqlConfiguration {

    @Autowired
    MongoTemplate mongoTemplate;


    @Bean
    public PostDao postDao() {
        Query query = new Query();
        query.limit(10);
        List<Post> posts = mongoTemplate.find(query, Post.class);

        return new PostDao(posts);
    }


    @Bean
    public PostResolver postResolver() {
        return new PostResolver();
    }

    @Bean
    public PostsQuery query() {
        return new PostsQuery();
    }

    @Bean
    public Mutation mutation(PostDao postDao) {
        return new Mutation(postDao);
    }
}
