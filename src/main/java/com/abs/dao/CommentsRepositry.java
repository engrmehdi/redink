package com.abs.dao;

import com.abs.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepositry extends JpaRepository<Comments, Long> {
    List<Comments> findAllByPostId(Long id);

}