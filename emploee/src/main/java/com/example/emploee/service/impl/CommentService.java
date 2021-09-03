package com.example.emploee.service.impl;

import com.example.emploee.model.Comments;
import com.example.emploee.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comments> getAllCommentsByTopicId(int id){
        return commentRepository.findAllByTopic_id(id);
    }
    public void saveComments(Comments comments){
        commentRepository.save(comments);
    }
}
