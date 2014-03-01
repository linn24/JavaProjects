/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.wap.exam.lib.Interval;


/**
 *
 * @author LinnHtet24
 */
public class Problem2 {
    CheckOverlap check = new CheckOverlap();
    
    public int getMaxWorkingTime(List<Interval> intervals){
        // TODO: Implement this method.
        Interval currentInterval, secondInterval, nextInterval;
        List<Interval> result = new ArrayList();
        int maxWorkingTime = 0;
        int totalTime = 0;
        
        
        if (intervals == null || intervals.isEmpty()){
            return 0;
        }else {
            if (intervals.size() <= 10000){
                for (int i = 0; i < intervals.size(); i++){
                    currentInterval = intervals.get(i);
                    if (currentInterval == null){
                        return 0;
                    }
                    for (int j = (i + 1); j < intervals.size(); j++){
                        secondInterval = intervals.get(j);
                        if (secondInterval == null){
                            return 0;
                        }
                        if(!check.isOverlapped(currentInterval, secondInterval)){
                            result.clear();
                            result.add(currentInterval);
                            System.out.println(currentInterval.toString() + " is added");
                            result.add(secondInterval);
                            System.out.println(secondInterval.toString() + " is added");
                            totalTime = currentInterval.getIntervalMinute() + secondInterval.getIntervalMinute();
                            System.out.println("current total: " + totalTime);

                            for (int k = (j + 1); k < intervals.size(); k++){
                                nextInterval = intervals.get(k);
                                if (nextInterval == null){
                                    return 0;
                                }

                                // check against intervals from result list
                                if(!check.isOverlapped(nextInterval, result)){
                                    result.add(nextInterval);
                                    System.out.println(nextInterval.toString() + " is added");

                                    totalTime += nextInterval.getIntervalMinute();
                                    System.out.println("current total: " + totalTime);                    
                                }                        
                            }
                        }               
                        if (totalTime > maxWorkingTime){
                            maxWorkingTime = totalTime;
                            System.out.println("current max: " + maxWorkingTime);
                        }                        
                    }
                                        
                }
            }
        }
        return maxWorkingTime;
    }
}
