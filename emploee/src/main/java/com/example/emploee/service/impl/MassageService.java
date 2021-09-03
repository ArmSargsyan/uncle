package com.example.emploee.service.impl;

import com.example.emploee.model.MassageModel;
import com.example.emploee.repository.MassageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MassageService {

    private final MassageRepository massageRepository;

    public void saveMassage(MassageModel massageModel){
        massageRepository.save(massageModel);
    }

    public List<MassageModel> findAllMassages(){
        return massageRepository.findAll();
    }
    public List<MassageModel> findAllMassagesByToId(int id){
        return massageRepository.findAllByToEmployee_Id(id);
    }

}
