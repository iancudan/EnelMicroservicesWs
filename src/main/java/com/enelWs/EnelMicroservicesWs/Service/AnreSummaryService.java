package com.enelWs.EnelMicroservicesWs.Service;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import com.enelWs.EnelMicroservicesWs.Entity.AnreSummaryHistory;
import com.enelWs.EnelMicroservicesWs.Entity.Dictionar;
import com.enelWs.EnelMicroservicesWs.Repository.AnreSummaryHistoryRepository;
import com.enelWs.EnelMicroservicesWs.Repository.AnreSummaryRepository;
import com.enelWs.EnelMicroservicesWs.Repository.DictionarRepository;
import com.enelWs.EnelMicroservicesWs.UTIL.DictionarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnreSummaryService {


    @Autowired
    AnreSummaryRepository anreSummaryRepository;

    @Autowired
    AnreSummaryHistoryRepository anreSummaryHistoryRepository;


    @Autowired
    DictionarRepository dictionarRepository;

    public AnreSummary findById(Long id){
        List<AnreSummary> all = anreSummaryRepository.findAll();
        AnreSummary anreSummary = new AnreSummary();

        for (AnreSummary a : all) {
            if (a.getId() == id) {
                anreSummary = a;
            }
        }
        if(anreSummary.getId() == null){
            List<AnreSummaryHistory> allHistory = anreSummaryHistoryRepository.findAll();
            for (AnreSummaryHistory a : allHistory) {
                if (a.getId() == id) {
                    anreSummary = historyToModel(a);
                }
            }
        }

        return anreSummary;
    }
    public List<AnreSummary> getAll(){
        List<AnreSummary> anreSummaryHistoryList = historyListToModelList(anreSummaryHistoryRepository.findAll());
        return concatLists(anreSummaryRepository.findAll(),anreSummaryHistoryList);
    }

    public String getHint(AnreSummary anreSummary){
        String hint = DictionarUtil.HINT_NOT_FOUND.getName();
        List<Dictionar> dictionarList = dictionarRepository.findAll();
        for(Dictionar d : dictionarList){
            if(anreSummary.getStatusMsg().toLowerCase().contains(d.getCuvantCheie().toLowerCase()))
                hint = d.getHint();
        }
        return hint;
    }

    public List<AnreSummary> historyListToModelList(List<AnreSummaryHistory> anreSummaryHistoryList){
        List<AnreSummary> newSummaryList = new ArrayList<>();
        for(AnreSummaryHistory anreSummaryHistory: anreSummaryHistoryList){
            AnreSummary newAnreSummary = new AnreSummary();
            newAnreSummary.setId(anreSummaryHistory.getId());
            newAnreSummary.setAnreXML(anreSummaryHistory.getAnreXML());
            newAnreSummary.setAuthorid(anreSummaryHistory.getAuthorid());
            newAnreSummary.setAuthorname(anreSummaryHistory.getAuthorname());
            newAnreSummary.setCorrelationid(anreSummaryHistory.getCorrelationid());
            newAnreSummary.setRequesttype(anreSummaryHistory.getRequesttype());
            newAnreSummary.setInsertDatetime(anreSummaryHistory.getInsertDatetime());
            newAnreSummary.setStatus(anreSummaryHistory.getStatus());
            newAnreSummary.setStatusCode(anreSummaryHistory.getStatusCode());
            newAnreSummary.setStatusMsg(anreSummaryHistory.getStatusMsg());
            newAnreSummary.setXmlFile(anreSummaryHistory.getXmlFile());
            newSummaryList.add(newAnreSummary);
        }

        return newSummaryList;
    }

    public AnreSummary historyToModel(AnreSummaryHistory anreSummaryHistory){
        AnreSummary newAnreSummary = new AnreSummary();
        newAnreSummary.setId(anreSummaryHistory.getId());
        newAnreSummary.setAnreXML(anreSummaryHistory.getAnreXML());
        newAnreSummary.setAuthorid(anreSummaryHistory.getAuthorid());
        newAnreSummary.setAuthorname(anreSummaryHistory.getAuthorname());
        newAnreSummary.setCorrelationid(anreSummaryHistory.getCorrelationid());
        newAnreSummary.setRequesttype(anreSummaryHistory.getRequesttype());
        newAnreSummary.setInsertDatetime(anreSummaryHistory.getInsertDatetime());
        newAnreSummary.setStatus(anreSummaryHistory.getStatus());
        newAnreSummary.setStatusCode(anreSummaryHistory.getStatusCode());
        newAnreSummary.setStatusMsg(anreSummaryHistory.getStatusMsg());
        newAnreSummary.setXmlFile(anreSummaryHistory.getXmlFile());
        return newAnreSummary;
    }


    public List<AnreSummary> concatLists(List<AnreSummary> anreSummaryList,List<AnreSummary> anreSummaryHistoryList){
        for(AnreSummary anreSummary: anreSummaryHistoryList){
            anreSummaryList.add(anreSummary);
        }

        return anreSummaryList;
    }
}
