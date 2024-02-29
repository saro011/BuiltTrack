package com.buildtrack.utilities;

import java.util.HashMap;
import java.util.Map;

public class EachPageTimeTaken {



    public String loadTimeInSec(long loadTime ){
        if(loadTime>=1000){
            return String.valueOf (loadTime / 1000)+" sec";}
        else{
            return String.valueOf(loadTime)+" ms";
        }

    }







    private Map<String, Long> pageStartTimes;

    private Map<String, Long> pageEndTimes;

    public EachPageTimeTaken() {
        this.pageStartTimes = new HashMap<>();
        this.pageEndTimes = new HashMap<>();
    }

    public void startTimer(String pageName) {
        long startTime = System.currentTimeMillis();
        pageStartTimes.put(pageName, startTime);
    }

    public void stopTimer(String pageName) {
        if (pageStartTimes.containsKey(pageName)) {
            long endTime = System.currentTimeMillis();
            pageEndTimes.put(pageName, endTime);
        } else {
            System.out.println("Timer not started for page: " + pageName);
        }
    }


}
