package topic_401_600.t551_600;

import java.util.Stack;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 */
public class T456_Find132Pattern {

    /**
     * 由题意可知，需要从数组中找到一个数 nums[a] ，
     * 存在 a < b < c && nums[a] < nums[b] > nums[c] && nums[a] < nums[c]
     * 也就是需要找到 a 的后方存在两个数字均大于 a ，且下标为b的数字大于下标为c的数字
     * 使用一个变量thirdNum存放 c 的数字，用 stack 存放下标为 b 的数字，从后往前进行遍历，
     * 前数字大于stack中的顶部元素时，则不断将顶部元素弹出并赋给 thirdNum, 最终将当前元素进stack，来保证stack中顶部元素 > thirdNum
     * 当发现当前元素小于 thirdNum时，则认为当前数组中存在132模式
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {return false;}
        int thirdNum = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1 ; i >= 0; i--) {
            if (nums[i] < thirdNum) {return true;}
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                thirdNum = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        T456_Find132Pattern find132Pattern = new T456_Find132Pattern();
        System.out.println(find132Pattern.find132pattern(new int[]{1,3,2,4,5,6,7,8,9,10}));
    }
}
