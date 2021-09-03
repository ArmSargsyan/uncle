package com.example.emploee.repository;

import com.example.emploee.model.MassageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MassageRepository extends JpaRepository<MassageModel, Integer> {

    List<MassageModel> findAllByToEmployee_Id(int id);
}
