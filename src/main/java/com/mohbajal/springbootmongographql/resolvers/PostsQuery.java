package com.mohbajal.springbootmongographql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mohbajal.springbootmongographql.daos.Post;
import com.mohbajal.springbootmongographql.daos.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class PostsQuery implements GraphQLQueryResolver {

    private PostDao postDao;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Post> getRecentPosts(int count, int offset) {
        Query query = new Query();
        query.skip(offset);
        query.limit(count);
        List<Post> posts = mongoTemplate.find(query, Post.class);

        return posts;
    }
}
