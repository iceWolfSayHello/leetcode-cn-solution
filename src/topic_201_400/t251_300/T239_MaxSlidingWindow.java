package topic_201_400.t251_300;

import java.util.Arrays;

/**
 * Q239_MaxSlidingWindow
 *给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 *
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * @author ：wy.
 * @date ：Created in 下午1:46 19-7-11
 */
public class T239_MaxSlidingWindow {

    private int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0 || k ==0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        for (int start = 0 , end = k-1; end < nums.length ; start++,end++) {
            int max = nums[start];
            for (int i = start+1; i <= end ; i++) {
                if (nums[i] > max){
                    max = nums[i];
                }
            }
            result[start] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        T239_MaxSlidingWindow maxSlidingWindow = new T239_MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Arrays.asList(maxSlidingWindow.maxSlidingWindow(nums,3)).forEach(System.out::println);
    }
}
