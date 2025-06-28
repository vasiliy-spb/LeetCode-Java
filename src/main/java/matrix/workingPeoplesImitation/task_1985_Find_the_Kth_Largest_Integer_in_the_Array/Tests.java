package matrix.workingPeoplesImitation.task_1985_Find_the_Kth_Largest_Integer_in_the_Array;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String[] nums = {"3", "6", "7", "10"};
        int k = 4;
        String expected = nums[0];
        assertSame(expected, testingClass.kthLargestNumber(nums, k));
    }

    @Test
    public void checkTestcase2() {
        String[] nums = {"2","21","12","1"};
        int k = 3;
        String expected = nums[0];
        assertSame(expected, testingClass.kthLargestNumber(nums, k));
    }

    @Test
    public void checkTestcase3() {
        String[] nums = {"0","0"};
        int k = 2;
        String expected = nums[0];
        assertSame(expected, testingClass.kthLargestNumber(nums, k));
    }

    @Test
    public void checkTestcase4() { // 137 / 219 testcases passed
        String[] nums = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        int k = 11;
        String expected = nums[3];
        assertSame(expected, testingClass.kthLargestNumber(nums, k));
    }

    @Test
    public void checkTestcase5() { // 165 / 219 testcases passed
        String[] nums = {"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"};
        int k = 3;
        String expected = nums[25];
        assertSame(expected, testingClass.kthLargestNumber(nums, k));
    }

}
