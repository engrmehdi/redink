/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.entities;

import com.sun.istack.internal.Nullable;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "Posts")
public class Posts{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "content")
    private String content;


    @ManyToOne()
    @JoinColumn(name = "authid", referencedColumnName = "id")
    private Authors auther;

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

    public Authors getAuther() {
        return auther;
    }

    public void setAuther(Authors auther) {
        this.auther = auther;
    }
}
