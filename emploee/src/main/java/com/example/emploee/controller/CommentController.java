package com.example.emploee.controller;

import com.example.emploee.model.Comments;
import com.example.emploee.security.CurrentUser;
import com.example.emploee.service.impl.CommentService;
import com.example.emploee.service.impl.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final TopicService topicService;

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute Comments comment, @AuthenticationPrincipal CurrentUser principal){
        comment.setModelEmployee(principal.getUser());
        comment.setCreatedDate(new Date());
        commentService.saveComments(comment);
        return "redirect:/allTopics/"+comment.getTopic().getId();

    }
}
