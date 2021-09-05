package com.example.emploee.controller;

import com.example.emploee.model.Comments;
import com.example.emploee.model.Topic;
import com.example.emploee.security.CurrentUser;
import com.example.emploee.service.impl.CommentService;
import com.example.emploee.service.impl.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;
    private final CommentService commentService;

    @GetMapping("/addTopic")
    public String addTopic() {
        return "addTopic";
    }

    @GetMapping("/allTopics")
    public String viewTopics(@AuthenticationPrincipal CurrentUser principal, ModelMap modelMap) {
        List<Topic> allTopics = topicService.findAllByCompanyId(principal.getUser().getCompany().getId());
        modelMap.addAttribute("allTopics", allTopics);
        return "allTopics";
    }

    @PostMapping("/addTopic")
    public String addTopic(@AuthenticationPrincipal CurrentUser principal, @ModelAttribute Topic topic) {
        topic.setCreatedDate(new Date());
        topic.setModelEmployee(principal.getUser());
        topicService.sveTopic(topic);
        return "redirect:/allTopics";
    }

    @GetMapping("/allTopics/{id}")
    public String showAll( @PathVariable("id") int id, ModelMap modelMap) {
        Optional<Topic> topic = topicService.findTopicById(id);
        if (topic.isEmpty()) {
            return "redirect:/allTopics";
        }
        List<Comments> comments = commentService.getAllCommentsByTopicId(id);
        modelMap.addAttribute("comments", comments);
        modelMap.addAttribute("topic", topic.get());
        return "singleTopic";
    }
}
