package com.mohbajal.springbootmongographql.resolvers;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mohbajal.springbootmongographql.daos.Author;
import com.mohbajal.springbootmongographql.daos.AuthorDao;
import com.mohbajal.springbootmongographql.daos.Post;

public class PostResolver implements GraphQLResolver<Post> {


    public PostResolver() {

    }

    /*public Optional<Author> getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }*/
}