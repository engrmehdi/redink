package com.abs.services.ServicesInterface;

import com.abs.vo.CommentsResponse;
import com.abs.vo.PostsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.ws.Response;
import java.security.Principal;
import java.util.List;

public interface GeneralService {
        List<PostsResponse> getAllPosts(Principal principal);
        ResponseEntity<Void> savePost(@RequestBody PostsResponse post, Principal principal);
        ResponseEntity<Void> saveComment(@RequestBody CommentsResponse comment, Principal principal);
    }
