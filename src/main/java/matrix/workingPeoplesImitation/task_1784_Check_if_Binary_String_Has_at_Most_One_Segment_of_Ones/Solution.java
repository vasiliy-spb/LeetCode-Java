package matrix.workingPeoplesImitation.task_1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones;

// my solution
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
