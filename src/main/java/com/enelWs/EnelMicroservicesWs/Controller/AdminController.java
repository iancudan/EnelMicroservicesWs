package com.enelWs.EnelMicroservicesWs.Controller;


import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import com.enelWs.EnelMicroservicesWs.Entity.Dictionar;
import com.enelWs.EnelMicroservicesWs.Service.AnreSummaryService;
import com.enelWs.EnelMicroservicesWs.Service.CustomUserDetailsService;
import com.enelWs.EnelMicroservicesWs.Service.DashboardService;
import com.enelWs.EnelMicroservicesWs.Service.DictionarService;
import com.enelWs.EnelMicroservicesWs.UTIL.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    DictionarService dictionarService;
    @Autowired
    DashboardService dashboardService;


    @GetMapping("/home")
    public String homePage(){
        return "This is the HomePage";
    }


    @GetMapping("/admin")
    public String adminPage(){
        if(customUserDetailsService.isAdmin())
            return "This is the AdminPage";
        else
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Page Not Found");
    }


    @GetMapping("/getDashboard")
    public Dashboard getDashboard(){
        return dashboardService.getDashboard();
    }
}
