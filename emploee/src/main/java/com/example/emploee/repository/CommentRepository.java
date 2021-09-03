package com.example.emploee.repository;

import com.example.emploee.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comments, Integer>{


    List<Comments> findAllByTopic_id(int id);
}
