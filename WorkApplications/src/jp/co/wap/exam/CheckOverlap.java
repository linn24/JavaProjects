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
public class CheckOverlap {
    public Interval getOverlapInterval(Interval current, Interval toCompare){
        Interval overlapInterval = null;
        
        // when one of them falls into another
        if((current.getBeginMinuteUnit() < toCompare.getBeginMinuteUnit()) && (current.getEndMinuteUnit() > toCompare.getEndMinuteUnit())){
            overlapInterval = new Interval(toCompare.getBegin(), toCompare.getEnd());
        }else if((current.getBeginMinuteUnit() > toCompare.getBeginMinuteUnit()) && (current.getEndMinuteUnit() < toCompare.getEndMinuteUnit())){
            overlapInterval = new Interval(current.getBegin(), current.getEnd());
        // when current interval starts later
        }else if(current.getBeginMinuteUnit() > toCompare.getBeginMinuteUnit()){
            if (toCompare.getEndMinuteUnit() - current.getBeginMinuteUnit() > 0){
                overlapInterval = new Interval(current.getBegin(), toCompare.getEnd());
            }
        // when current interval starts earlier
        }else if(current.getBeginMinuteUnit() < toCompare.getBeginMinuteUnit()){
            if (current.getEndMinuteUnit() - toCompare.getBeginMinuteUnit() > 0){
                overlapInterval = new Interval(toCompare.getBegin(), current.getEnd());
            }
        }else{
            if(current.getEndMinuteUnit() > toCompare.getEndMinuteUnit()){
                overlapInterval = new Interval(toCompare.getBegin(), toCompare.getEnd());
            }else{
                overlapInterval = new Interval(current.getBegin(), current.getEnd());
            }            
        }
        return overlapInterval;
    }
    
    public boolean isOverlapped(Interval i1, Interval i2){
        if(getOverlapInterval(i1, i2) != null){
            return true;
        }
        return false;
    }
    
    public boolean isOverlapped(Interval curr, List<Interval> intervals){
        Interval fromList;
        for (int k = (intervals.size() - 1); k >= 0; k--){
            fromList = intervals.get(k);
            if (isOverlapped(curr, fromList)){
                return true;
            }
        }
        return false;
    }
    
}
