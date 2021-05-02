import java.util.*;

class Interval{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class InsertInterval{
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.isEmpty()){
            return Arrays.asList(newInterval);
        }

        List<Interval> mergedIntervals = new ArrayList<>();


        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){ //skip case, all items in intervals comes before newInterval
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){//Overlap case, need to find new min and max
            newInterval.start = Math.min(intervals.get(i).start, newInterval.end);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        //insert new interval
        mergedIntervals.add(newInterval);

        //add all the remaining to the output
        while(i < intervals.size()){
            mergedIntervals.add(intervals.get(i));
            i++;
        }
        return mergedIntervals;
    }

    public static void main(String[] args){
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
        System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
