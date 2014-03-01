/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.wap.exam;

import java.util.ArrayList;
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
                        
                        // check if currentInterval and secondInterval are overlapped
                        // if not overlapped,
                        if(!check.isOverlapped(currentInterval, secondInterval)){
                            // clear result list
                            result.clear();
                            
                            // add currentInterval and secondInterval to result list
                            result.add(currentInterval);
                            result.add(secondInterval);
                            
                            // update totalTime
                            totalTime = currentInterval.getIntervalMinute() + secondInterval.getIntervalMinute();
                            
                            // get next intervals to add
                            for (int k = (j + 1); k < intervals.size(); k++){
                                nextInterval = intervals.get(k);
                                if (nextInterval == null){
                                    return 0;
                                }

                                // check against intervals from result list if nextInterval is overlapped with any of them
                                // if not overlapped,
                                if(!check.isOverlapped(nextInterval, result)){
                                    // add nextInterval to result list
                                    result.add(nextInterval);
                                    
                                    // update totalTime
                                    totalTime += nextInterval.getIntervalMinute();                    
                                }                        
                            }// end 3rd for
                            
                            // update maxWorkingTime
                            if (totalTime > maxWorkingTime){
                                maxWorkingTime = totalTime;
                            } 
                        }                    
                    }// end 2nd for                            
                }// end 1st for
            }
        }
        return maxWorkingTime;
    }
}
