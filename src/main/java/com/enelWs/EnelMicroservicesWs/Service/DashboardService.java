package com.enelWs.EnelMicroservicesWs.Service;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import com.enelWs.EnelMicroservicesWs.Entity.AnreSummaryHistory;
import com.enelWs.EnelMicroservicesWs.Repository.AnreSummaryHistoryRepository;
import com.enelWs.EnelMicroservicesWs.Repository.AnreSummaryRepository;
import com.enelWs.EnelMicroservicesWs.UTIL.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DashboardService {

    @Autowired
    AnreSummaryRepository anreSummaryRepository;

    @Autowired
    AnreSummaryHistoryRepository anreSummaryHistoryRepository;


    public Dashboard getDashboard (){
        Dashboard dashboard = new Dashboard();
        List<AnreSummary> anreSummaryList = anreSummaryRepository.findAll();
        List<AnreSummaryHistory> anreSummaryHistoryList = anreSummaryHistoryRepository.findAll();
        /*currentDashboard*/
        dashboard = setCurrentDashboard(dashboard,anreSummaryList);
        /*oldDashboard*/
        dashboard = setOldDashboard(dashboard,anreSummaryHistoryList);
        /*finalDashboard*/
        dashboard = setTotalDashboard(dashboard);
        return dashboard;
    }


    public Dashboard setCurrentDashboard(Dashboard dashboard,List<AnreSummary> anreSummaryList){
        Set<String> uniqueList = new HashSet<String>();
        List<String> totalErori = new ArrayList<>();

        for(AnreSummary anreSummary: anreSummaryList ){
            uniqueList.add(anreSummary.getCorrelationid());
            if(anreSummary.getStatus().equals("KO"))
                totalErori.add(anreSummary.getStatus());
        }

        dashboard.setCurentTotalCereri(String.valueOf(anreSummaryList.size()));
        dashboard.setCurentTotalCereriUnice(String.valueOf(uniqueList.size()));
        dashboard.setCurentTotalErori(String.valueOf(totalErori.size()));

        double procentErori = calculatePercent(Double.valueOf(dashboard.getCurentTotalErori()),Double.valueOf(dashboard.getCurentTotalCereriUnice()));
        double total = 100.00;

        dashboard.setCurentProcentErori(String.valueOf(procentErori));
        dashboard.setCurentProcentOk(String.valueOf(total-procentErori));
        return dashboard;
    }

    public Dashboard setOldDashboard(Dashboard dashboard,List<AnreSummaryHistory> anreSummaryHistoryList){
        Set<String> uniqueList = new HashSet<String>();
        List<String> totalErori = new ArrayList<>();

        for(AnreSummaryHistory anreSummary: anreSummaryHistoryList ){
            uniqueList.add(anreSummary.getCorrelationid());
            if(anreSummary.getStatus().equals("KO"))
                totalErori.add(anreSummary.getStatus());
        }

        dashboard.setOldTotalCereri(String.valueOf(anreSummaryHistoryList.size()));
        dashboard.setOldTotalCereriUnice(String.valueOf(uniqueList.size()));
        dashboard.setOldTotalErori(String.valueOf(totalErori.size()));

        double procentErori = calculatePercent(Double.valueOf(dashboard.getOldTotalErori()),Double.valueOf(dashboard.getOldTotalCereriUnice()));
        double total = 100.00;


        dashboard.setOldProcentErori(String.valueOf(procentErori));
        dashboard.setOldProcentOk(String.valueOf(total-procentErori));
        return dashboard;
    }

    public Dashboard setTotalDashboard(Dashboard dashboard){
        int old = Integer.parseInt(dashboard.getOldTotalCereri());
        int current =Integer.parseInt(dashboard.getCurentTotalCereri());
        dashboard.setTotalCereri(String.valueOf(old+current));

        old = Integer.parseInt(dashboard.getOldTotalCereriUnice());
        current =Integer.parseInt(dashboard.getCurentTotalCereriUnice());
        dashboard.setTotalCereriUnice(String.valueOf(old+current));

        old = Integer.parseInt(dashboard.getOldTotalErori());
        current =Integer.parseInt(dashboard.getCurentTotalErori());
        dashboard.setTotalErori(String.valueOf(old+current));

        double procentErori = calculatePercent(Double.valueOf(dashboard.getTotalErori()),Double.valueOf(dashboard.getTotalCereriUnice()));
        double total = 100.00;

        dashboard.setProcentErori(String.valueOf(procentErori));
        dashboard.setProcentOk(String.valueOf(total-procentErori));

        return dashboard;
    }


    private double calculatePercent(double current,double total){
        double percent = (current * 100.00) / total;
        return percent;
    }
}
