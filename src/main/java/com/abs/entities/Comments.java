package com.abs.entities;

import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Comments")
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "postid", referencedColumnName = "id")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "authid", referencedColumnName = "id")
    private Authors authid;

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

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }

    public Authors getAuthid() {
        return authid;
    }

    public void setAuthid(Authors authid) {
        this.authid = authid;
    }
}