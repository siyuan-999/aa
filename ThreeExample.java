import java.util.Arrays;

public class ThreeExample {
    public static void main(String[] args){
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {3,2,4};
        int[] nums3 = {3,3};
        int target1 = 9;
        int target2 = 7;
        int target3 = 6;
        printOutput(nums1,target1);
        printOutput(nums2,target2);
        printOutput(nums3,target3);
        int[] result1 = printOutput(nums1,target1);
        int[] result2 = printOutput(nums2,target2);
        int[] result3 = printOutput(nums3,target3);


        System.out.println("result1 : " + Arrays.toString(result1) +" result2 : " + Arrays.toString(result2) + " result3 : " + Arrays.toString(result3));
    }
    public static int[] printOutput(int[] nums,int target) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1;j <nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};


                }

            }
        }
        return new int[]{};
    }

}
