package com.mohbajal.springbootmongographql.resolvers;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mohbajal.springbootmongographql.daos.Author;
import com.mohbajal.springbootmongographql.daos.AuthorDao;
import com.mohbajal.springbootmongographql.daos.Post;

public class PostResolver implements GraphQLResolver<Post> {
    private AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Optional<Author> getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }
}