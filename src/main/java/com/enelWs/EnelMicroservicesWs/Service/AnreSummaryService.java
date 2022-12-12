package com.enelWs.EnelMicroservicesWs.Service;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import com.enelWs.EnelMicroservicesWs.Repository.AnreSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnreSummaryService {


    @Autowired
    AnreSummaryRepository anreSummaryRepository;

    public List<AnreSummary> getAll(){
       return anreSummaryRepository.findAll();
    }
}
