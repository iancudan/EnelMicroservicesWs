package com.enelWs.EnelMicroservicesWs.Controller;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import com.enelWs.EnelMicroservicesWs.Service.AnreSummaryService;
import com.enelWs.EnelMicroservicesWs.Service.DashboardService;
import com.enelWs.EnelMicroservicesWs.UTIL.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class AnreSummaryController {

    @Autowired
    AnreSummaryService anreSummaryService;

    @Autowired
    DashboardService dashboardService;


    @GetMapping("/getCallOut")
    @ResponseBody
    public List<AnreSummary> getCallIn(){
        return anreSummaryService.getAll();
    }

    @GetMapping("/getSummaryById/{id}")
    @ResponseBody
    public AnreSummary getSummaryById(@PathVariable Long id){
        return anreSummaryService.findById(id);
    }

    @GetMapping("/getHint/{id}")
    @ResponseBody
    public String getHint(@PathVariable Long id){
        AnreSummary anreSummary = anreSummaryService.findById(id);
        String hint = anreSummaryService.getHint(anreSummary);
        return hint;
    }

}
