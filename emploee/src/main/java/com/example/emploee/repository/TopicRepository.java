package com.example.emploee.repository;

import com.example.emploee.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    List<Topic>findAllByModelEmployee_Company_Id(int id);

}
