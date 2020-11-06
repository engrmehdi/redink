package com.abs.services.ServiceImpl;

import com.abs.dao.AuthersRepository;
import com.abs.dao.CommentsRepositry;
import com.abs.dao.PostsRepository;
import com.abs.entities.Authors;
import com.abs.entities.Comments;
import com.abs.entities.Posts;
import com.abs.services.ServicesInterface.GeneralService;
import com.abs.vo.CommentsResponse;
import com.abs.vo.PostsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GeneralServiceImp implements GeneralService {
    private final AuthersRepository authersRepository;
    private final PostsRepository postsRepository;
    private final CommentsRepositry commentsRepositry;

    public GeneralServiceImp(PostsRepository postsRepository,AuthersRepository authersRepository,CommentsRepositry commentsRepositry) {
        this.postsRepository = postsRepository;
        this.authersRepository = authersRepository;
        this.commentsRepositry = commentsRepositry;
    }

    public List<PostsResponse> getAllPosts(Principal principal){
        List<PostsResponse> lst = new ArrayList<>();
        for (Posts Posts : postsRepository.findAll()) {
            lst.add(setPostResponse(Posts));
        }
        return lst;
    }
    public ResponseEntity<Void> savePost(@RequestBody PostsResponse request, Principal principal){
        Posts post = new Posts();
        try {
            post.setContent(request.getContent());
            Authors authors = authersRepository.findById(request.getAuthid());
            post.setAuther(authors);
            postsRepository.saveAndFlush(post);
        } catch (Exception e) {
            throw e;
        }
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<Void> saveComment(@RequestBody CommentsResponse request, Principal principal){

        Comments comment = new Comments();
        try {
            comment.setContent(request.getContent());
            Authors authors = authersRepository.findById(request.getAuthid());
            Posts post = postsRepository.findById(request.getPostid());
            comment.setPost(post);
            comment.setAuthid(authors);
            commentsRepositry.saveAndFlush(comment);
        } catch (Exception e) {
            throw e;
        }
        return ResponseEntity.noContent().build();
    }
        private PostsResponse setPostResponse(Posts post) {
            PostsResponse resp = new PostsResponse();
        if (post != null) {
            resp.setId(post.getId());
            resp.setAuthors(post.getAuther());
            resp.setContent(post.getContent());
            resp.setComment(getAllPosts(post.getId()));
        }
        return resp;
    }
    public List<Comments> getAllPosts(Long postId){
        List<Comments> lst = new ArrayList<>();
        for (Comments comment : commentsRepositry.findAllByPostId(postId)) {
            lst.add(comment);
        }
        return lst;
    }
}
