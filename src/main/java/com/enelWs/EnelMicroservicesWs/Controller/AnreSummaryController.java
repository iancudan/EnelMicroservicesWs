package com.enelWs.EnelMicroservicesWs.Controller;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import com.enelWs.EnelMicroservicesWs.Entity.AnreSummaryHistory;
import com.enelWs.EnelMicroservicesWs.Service.AnreSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnreSummaryController {

    @Autowired
    AnreSummaryService anreSummaryService;

    @GetMapping("/getCallOut")
    public List<AnreSummary> getCallIn(){
        return anreSummaryService.getAll();
    }

    @GetMapping("/getSummaryById/{id}")
    public AnreSummary getSummaryById(@PathVariable Long id){
        return anreSummaryService.findById(id);
    }

    @GetMapping("/getHint/{id}")
    public String getHint(@PathVariable Long id){
        AnreSummary anreSummary = anreSummaryService.findById(id);
        String hint = anreSummaryService.getHint(anreSummary);
        return hint;
    }
}
