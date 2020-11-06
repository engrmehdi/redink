package com.abs.controller;

import java.security.Principal;
import java.util.List;

import com.abs.vo.CommentsResponse;
import com.abs.vo.PostsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.abs.services.ServicesInterface.GeneralService;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/api")
public class GeneralController {

    public static final Logger logger = LoggerFactory.getLogger(GeneralController.class);

    @Autowired
    private GeneralService generalService;

    @CrossOrigin
    @RequestMapping(value = {"/getAllPosts"},
            method = RequestMethod.GET,
            produces = "application/json",
            consumes = "application/json")
    public List<PostsResponse> getAllPosts(Principal principal) {
        return generalService.getAllPosts(principal);
    }

    @CrossOrigin
    @RequestMapping(value = "/savePost",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Void> savePost(@RequestBody PostsResponse post, Principal principal) {
        return generalService.savePost(post, principal);
    }
    @CrossOrigin
    @RequestMapping(value = "/saveComment",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Void> saveComment(@RequestBody CommentsResponse comment, Principal principal) {
        return generalService.saveComment(comment, principal);
    }
}
