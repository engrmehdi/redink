package com.abs.vo;

import com.abs.entities.Authors;
import com.abs.entities.Comments;

import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

public class PostsResponse {
    @XmlElement(nillable=false)
    private Long id;

    @XmlElement(nillable=false)
    private String content;

    @XmlElement(nillable=false)
    private Long authid;

    @XmlElement(nillable=false)
    private Authors Authors;

    @XmlElement(nillable=false)
    private List<Comments> comment;

    @XmlElement(nillable=false)
    private Timestamp createdwhen;

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

    public Timestamp getCreatedwhen() {
        return createdwhen;
    }

    public void setCreatedwhen(Timestamp createdwhen) {
        this.createdwhen = createdwhen;
    }

    public List<Comments> getComment() {
        return comment;
    }

    public void setComment(List<Comments> comment) {
        this.comment = comment;
    }
}
