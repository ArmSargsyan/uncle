package com.example.emploee.service.impl;

import com.example.emploee.model.Topic;
import com.example.emploee.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public List<Topic> findAllByCompanyId(int id){
        return topicRepository.findAllByModelEmployee_Company_Id(id);
    }
    public Optional<Topic> findTopicById(int id){
        return topicRepository.findById(id);
    }

    public void sveTopic(Topic topic){
        topicRepository.save(topic);
    }

}
