package com.abs.vo;

import com.abs.entities.Authors;
import com.abs.entities.Comments;
import com.abs.entities.Posts;

import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.sql.Timestamp;

public class CommentsResponse {
    @XmlElement(nillable=false)
    private Long id;

    @XmlElement(nillable=false)
    private String content;

    @XmlElement(nillable=false)
    private Long postid;

    @XmlElement(nillable=false)
    private Posts post;

    @XmlElement(nillable=false)
    private Long authid;

    @XmlElement(nillable=false)
    private Authors Authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }

    public Long getAuthid() {
        return authid;
    }

    public void setAuthid(Long authid) {
        this.authid = authid;
    }

    public com.abs.entities.Authors getAuthors() {
        return Authors;
    }

    public void setAuthors(com.abs.entities.Authors authors) {
        Authors = authors;
    }
}
