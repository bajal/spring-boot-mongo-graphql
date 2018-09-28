package com.mohbajal.springbootmongographql.resolvers;

import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mohbajal.springbootmongographql.daos.Post;
import com.mohbajal.springbootmongographql.daos.PostDao;

public class Mutation implements GraphQLMutationResolver {
    private PostDao postDao;

    public Mutation(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post writePost(String title, String text, String category, String author) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(author);
        postDao.savePost(post);

        return post;
    }
}