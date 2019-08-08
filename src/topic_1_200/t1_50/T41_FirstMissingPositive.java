package topic_1_200.t1_50;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * <p>
 * 下面解法中实际并没有降低时间复杂度为O（N）
 *
 * @author ：wy.
 * @date ：Created at 11:22 2019/6/26
 */
public class T41_FirstMissingPositive {

	private int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		int minValue = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if (minValue == nums[i]) {
				minValue++;
			} else {
				break;
			}
		}
		return minValue;
	}

	public static void main(String[] args) {

		int[] nums = {7, 8, 9, 11, 12};
		T41_FirstMissingPositive firstMissingPositive = new T41_FirstMissingPositive();
		System.out.println(firstMissingPositive.firstMissingPositive(nums));
	}
}
