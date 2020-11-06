package com.abs.vo;

import com.abs.entities.Authors;
import com.abs.entities.Comments;

import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.sql.Timestamp;

public class AuthersResponse {
    @XmlElement(nillable=false)
    private Long id;

    @XmlElement(nillable=false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
