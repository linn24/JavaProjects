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
        int maxCount = 0;
        int curCount = 0;
        Interval currentInterval, intervalToCompare, overlapInterval;
        if (intervals == null || intervals.isEmpty()){
            return 0;
        }else {
            for (int i = 0; i < intervals.size(); i++){
                // reset curCount
                curCount = 0;
                
                // when impossible to have higher count than current maxCount
                if((curCount + intervals.size() - i) <= maxCount){                    
                    break;
                }else{
                    if(intervals.get(i) == null){
                        return 0;
                    }else{
                        currentInterval = intervals.get(i);

                        // get next intervals to compare starting from (i + 1) to (size - 1)
                        for (int j = (i + 1); j < intervals.size(); j++){
                            // reset curCount
                            curCount = 0;
                            
                            // when impossible to have higher count than current maxCount
                            if((curCount + intervals.size() - j) <= maxCount){
                                break;
                            }else{
                                if(intervals.get(j) == null){
                                    return 0;
                                }else{
                                    intervalToCompare = intervals.get(j);
                                    
                                    // find overlapInterval between currentInterval and intervalToCompare
                                    overlapInterval = check.getOverlapInterval(currentInterval, intervalToCompare);
                                    
                                    if (overlapInterval != null){
                                        // increment curCount
                                        curCount = 2;
                                        
                                        // find other intervals overlapping with overlapInterval starting from (j + 1) to (size - 1)
                                        for (int k = (j + 1); k < intervals.size(); k++){
                                            // when impossible to have higher count than current maxCount
                                            if((curCount + intervals.size() - k) <= maxCount){
                                                break;
                                            }else{
                                                if(intervals.get(k) == null){
                                                    return 0;
                                                }else{
                                                    // if another interval overlapping with overlapInterval is found
                                                    if(check.isOverlapped(overlapInterval, intervals.get(k))){
                                                        // increment curCount
                                                        curCount++;
                                                    }
                                                }
                                            }
                                        }// end 3rd for   
                                        
                                        // update maxCount
                                        if (curCount > maxCount){
                                            maxCount = curCount;
                                        }
                                    }                             
                                }
                            }
                        }// end 2nd for
                    }
                }
            }// end 1st for
        }
        return maxCount;
    }
    

}
