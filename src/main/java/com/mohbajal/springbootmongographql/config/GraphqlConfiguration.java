package com.mohbajal.springbootmongographql.config;

import java.util.ArrayList;
import java.util.List;

import com.mohbajal.springbootmongographql.daos.Author;
import com.mohbajal.springbootmongographql.daos.AuthorDao;
import com.mohbajal.springbootmongographql.daos.Post;
import com.mohbajal.springbootmongographql.daos.PostDao;
import com.mohbajal.springbootmongographql.resolvers.AuthorResolver;
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
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setName("Author " + authorId);
            author.setThumbnail("http://example.com/authors/" + authorId);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }

    @Bean
    public PostResolver postResolver() {
        return new PostResolver();
    }

    @Bean
    public AuthorResolver authorResolver(PostDao postDao) {
        return new AuthorResolver(postDao);
    }

    @Bean
    public PostsQuery query(PostDao postDao) {
        return new PostsQuery(postDao);
    }

    @Bean
    public Mutation mutation(PostDao postDao) {
        return new Mutation(postDao);
    }
}
