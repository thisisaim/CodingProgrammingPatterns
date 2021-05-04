import java.util.*;

class Job{
    int start; 
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad){
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}
class MaximumCPULoad{
    public static int findMaxCPULoad(List<Job> jobs) {
        Collections.sort(jobs, (x, y) -> Integer.compare(x.start, y.start));

        int maxLoadCPU = 0;
        int currentLoadCPU = 0;

        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

        for(Job job : jobs){
            while( !minHeap.isEmpty() && job.start >= minHeap.peek().end){
                currentLoadCPU = currentLoadCPU - minHeap.poll().cpuLoad;
            }
        minHeap.offer(job);
        currentLoadCPU = currentLoadCPU + job.cpuLoad;
        maxLoadCPU = Math.max(currentLoadCPU, maxLoadCPU);
        }
        return maxLoadCPU;
    }

    public static void main(String[] args){
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}