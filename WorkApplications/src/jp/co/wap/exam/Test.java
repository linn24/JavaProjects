/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.wap.exam;

import java.util.Arrays;
import java.util.List;
import jp.co.wap.exam.lib.Interval;



/**
 *
 * @author LinnHtet24
 */
public class Test {
    public static void main(String[] args){
        Test test = new Test();
        //test.testProblem1Usage();
        test.testProblem2Usage();
        //test.testQuestion2Usage();
    }
    
    public void testProblem1Usage(){
        Problem1 p = new Problem1();
        
        // example: Figure 1
        Interval interval1 = new Interval("08:00", "12:00");
        Interval interval2 = new Interval("06:00", "09:00");
        Interval interval3 = new Interval("11:00", "13:30");
        List<Interval> figure1 = Arrays.asList(interval1, interval2, interval3);
        System.out.println("maxCount for figure 1: " + p.getMaxIntervalOverlapCount(figure1));
        
        // example: Figure 2
        List<Interval> figure2 = Arrays.asList(new Interval("09:00", "12:30"),
                new Interval("06:00", "09:30"), new Interval("12:00", "14:30"),
                new Interval("10:00", "10:30"), new Interval("11:00", "13:30"));
        System.out.println("maxCount for figure 2: " + p.getMaxIntervalOverlapCount(figure2));    
    }
    
    public void testProblem2Usage(){
        Problem2 p = new Problem2();
        
        List<Interval> intervals = Arrays.asList(
                new Interval("06:00", "08:30"), new Interval("09:00", "11:00"),
                new Interval("12:30", "14:00"), new Interval("08:00", "09:00"),
                new Interval("10:30", "14:00"), new Interval("09:00", "11:30"));
        System.out.println("maxWorkingTime: " + p.getMaxWorkingTime(intervals));
    }
    
    public void testQuestion2Usage(){
        LinkedList<String> strList = new LinkedList<String>();
        strList.add("7");
        strList.add("1");
        strList.add("3");
        strList.add("3");
        strList.add("5");
        strList.add("1");
        
        strList.print();
        
        PersistentQueue pq = new PersistentQueue(strList);
        pq.enqueue("4");
        pq.print();
        System.out.println(pq.peek());
        pq.dequeue();
        pq.print();
    }    
    
}
