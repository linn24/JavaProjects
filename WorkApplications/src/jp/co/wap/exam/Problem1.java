/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.wap.exam;

import java.util.List;
import jp.co.wap.exam.lib.Interval;

/**
 *
 * @author LinnHtet24
 */
public class Problem1 {
    CheckOverlap check = new CheckOverlap();
    
    public int getMaxIntervalOverlapCount(List<Interval> intervals){
        // TODO: Implement this method
        int exeCount = 0; // to check performance
        int maxCount = 0;
        int curCount = 0;
        Interval currentInterval, intervalToCompare, overlapInterval;
        if (intervals == null || intervals.isEmpty()){
            return 0;
        }else {
            for (int i = 0; i < intervals.size(); i++){
                System.out.println("first for: " + intervals.get(i).toString());
                if(intervals.get(i) == null){
                    return 0;
                }else if((curCount + intervals.size() - i) <= maxCount){
                    System.out.println("exit first for");
                    break;
                }else{
                    currentInterval = intervals.get(i);
                    System.out.print("for " + currentInterval.toString());
                    
                    // get next intervals to compare starting from (i + 1) to (size - 1)
                    for (int j = (i + 1); j < intervals.size(); j++){
                        curCount = 0;
                
                        if(intervals.get(j) == null){
                            return 0;
                        }else if((curCount + intervals.size() - j) <= maxCount){
                            break;
                        }else{
                            intervalToCompare = intervals.get(j);
                            System.out.println(" and " + intervalToCompare.toString());
                            // find overlapInterval between currentInterval and intervalToCompare
                            overlapInterval = check.getOverlapInterval(currentInterval, intervalToCompare);
                            if (overlapInterval != null){
                                // increment maxCount
                                curCount = 2;
                                System.out.println("curCount: " + curCount);
                                
                                // find other intervals overlapping with overlapInterval
                                for (int k = (j + 1); k < intervals.size(); k++){
                                    if(intervals.get(k) == null){
                                        return 0;
                                    }else if((curCount + intervals.size() - k) <= maxCount){
                                        break;
                                    }else{
                                        System.out.println(overlapInterval.toString() + "---" + intervals.get(k).toString());
                                        if(check.isOverlapped(overlapInterval, intervals.get(k))){
                                            curCount++;
                                            System.out.println("curCount (in): " + curCount);                                
                                            exeCount++;
                                        }
                                    }
                                    exeCount++;
                                }// end 3rd for   
                                
                                if (curCount > maxCount){
                                    maxCount = curCount;
                                    exeCount++;
                                }
                                System.out.println("maxCount: " + maxCount);
                                exeCount++;
                            }                             
                        }
                        exeCount++;
                    }// end 2nd for
                }
                exeCount++;
            }// end 1st for         
            System.out.println("after first for");
        }
        exeCount++;
        System.out.println("total instructions executed: " + exeCount);
        return maxCount;
    }
    

}
