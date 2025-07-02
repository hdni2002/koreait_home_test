package com.koreait.dbms_study.repository;


import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    @Autowired
    private PostMapper postMapper;

    public int addPost(Post post){
        int result = postMapper.addPost(post);
        return result;

    }

    public Optional<Post> getPostByPostId(Integer postId){
       Optional<Post> optionalPost = postMapper.getPostByPostId(postId);
        return optionalPost;
    }
    public List<Post> getPostList(){
        List<Post> postList = postMapper.getPostList();
        return postList;
    }
    public int editPost(Post post){
        int result = postMapper.editPost(post);
        return result;

    }
    public int removePost(Integer postId){
        int result = postMapper.removePost(postId);
        return result;
    }



}
