package com.abs.dao;

import com.abs.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthersRepository extends JpaRepository<Authors, Long> {
      Authors findById(Long id);
}