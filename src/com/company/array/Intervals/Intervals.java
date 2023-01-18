package com.company.array.Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Intervals {

    public static class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    private void printInterval(Interval a){
        System.out.println(a.start+","+a.end);
    }
    private List<Interval> mergeIntervals(List<Interval> intervals){
        if (intervals.size()<2) return intervals;
        List<Interval> temp=new ArrayList<>();
        intervals.sort(Comparator.comparingInt(in->in.start));
        Interval first=intervals.get(0);
        int start=first.start;
        int end=first.end;
        for (int i=1;i<intervals.size();i++){
            Interval current=intervals.get(i);
            if (current.start<=end){
                end=Math.max(current.end,end);
            }else {
                temp.add(new Interval(start,end));
                start=current.start;
                end=current.end;
            }
        }
        temp.add(new Interval(start,end));
        return temp;
    }
    private void printList(List<Interval> list){
        System.out.print("[");
        for (int i=0;i<list.size();i++){
            System.out.print("{"+list.get(i).start+","+list.get(i).end+"},");
        }
        System.out.print("]");
    }

    private List<Interval> insertInterval(List<Interval> list,Interval interval){
        if (list==null || list.isEmpty()){
            return list;
        }
        List<Interval> temp=new ArrayList<>();
        int i=0;
        while (i<list.size() && list.get(i).end<interval.start){
            temp.add(list.get(i));
            i++;
        }
        while (i<list.size() && list.get(i).start<=interval.end){
            Interval current=list.get(i);
            interval.start=Math.min(current.start,interval.start);
            interval.end=Math.max(current.end,interval.end);
            i++;
        }
        temp.add(interval);
        while (i<list.size()){
            temp.add(list.get(i));
            i++;
        }
        return temp;
    }

    public static void main(String[] args){
        Intervals intervals=new Intervals();
        Interval a=new Interval(1,3);
        Interval c=new Interval(2,6);
        Interval b=new Interval(8,10);
        Interval d=new Interval(7,9);
        Interval e=new Interval(4,5);
        List<Interval> list= new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        intervals.printList(list);
        System.out.println();
        intervals.printList(intervals.mergeIntervals(list));
        System.out.println();
        intervals.printList(intervals.insertInterval(list,d));
        System.out.println();
        intervals.printList(intervals.insertInterval(list,e));
    }
}
