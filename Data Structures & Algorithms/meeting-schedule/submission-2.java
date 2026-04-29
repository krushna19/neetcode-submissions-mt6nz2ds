/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
          intervals.sort((a, b) -> a.start - b.start);
          int curr = 0;
          for(Interval i : intervals){
             if(i.start < i.end && curr <= i.start){
                 curr = i.end;
             }else{
                return false;
             }
          }
          return true;
    }
}
