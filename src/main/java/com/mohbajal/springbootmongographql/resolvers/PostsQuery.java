package com.mohbajal.springbootmongographql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mohbajal.springbootmongographql.daos.Post;
import com.mohbajal.springbootmongographql.daos.PostDao;

import java.util.List;

public class PostsQuery implements GraphQLQueryResolver {

    private PostDao postDao;

    public PostsQuery(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}
