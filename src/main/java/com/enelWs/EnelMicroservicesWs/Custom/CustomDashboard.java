package com.enelWs.EnelMicroservicesWs.Custom;

public class CustomDashboard {

    private CustomDashboardToday customDashboardToday;
    private CustomDashboardOld customDashboardOld;


    public CustomDashboardToday getCustomDashboardToday() {
        return customDashboardToday;
    }

    public void setCustomDashboardToday(CustomDashboardToday customDashboardToday) {
        this.customDashboardToday = customDashboardToday;
    }

    public CustomDashboardOld getCustomDashboardOld() {
        return customDashboardOld;
    }

    public void setCustomDashboardOld(CustomDashboardOld customDashboardOld) {
        this.customDashboardOld = customDashboardOld;
    }
}
