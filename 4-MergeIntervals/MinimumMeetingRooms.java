import java.util.*;

class Meeting{
    int start;
    int end;

    public Meeting(int start,int end){
        this.start = start;
        this.end = end;
    }
}

class MinimumMeetingRooms{
    public static int findMinimumMeetingRooms(List<Meeting> meetings){
        if(meetings == null || meetings.size() == 0){
            return 0;
        }
        int[] starts = new int[meetings.size()];
        int[] ends = new int[meetings.size()];

        for(int i = 0; i < meetings.size(); i++){
            starts[i] = meetings.get(i).start;
            ends[i] = meetings.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int roomsNeeded = 0;
        int endsItr = 0;

        for(int i = 0; i < starts.length; i++){
            if(starts[i] < ends[endsItr]){
                roomsNeeded++;
            }
            else{
                endsItr++;
            }
        }
        return roomsNeeded;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
          {
            add(new Meeting(4, 5));
            add(new Meeting(2, 3));
            add(new Meeting(2, 4));
            add(new Meeting(3, 5));
          }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    
        input = new ArrayList<Meeting>() {
          {
            add(new Meeting(1, 4));
            add(new Meeting(2, 5));
            add(new Meeting(7, 9));
          }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    
        input = new ArrayList<Meeting>() {
          {
            add(new Meeting(6, 7));
            add(new Meeting(2, 4));
            add(new Meeting(8, 12));
          }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    
        input = new ArrayList<Meeting>() {
          {
            add(new Meeting(1, 4));
            add(new Meeting(2, 3));
            add(new Meeting(3, 6));
          }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    
        input = new ArrayList<Meeting>() {
          {
            add(new Meeting(4, 5));
            add(new Meeting(2, 3));
            add(new Meeting(2, 4));
            add(new Meeting(3, 5));
          }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
      }
}