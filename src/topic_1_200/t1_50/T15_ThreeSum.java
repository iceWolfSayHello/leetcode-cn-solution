package topic_1_200.t1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T15_ThreeSum
 * 题目：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author ：wy.
 * @date ：Created at 10:30 2019/6/25
 */
public class T15_ThreeSum {

	/**
	 * 先进行排序，排序后采用双层循环、对撞指针进行遍历，
	 * 若最大的三个数相加已经小于0则退出循环
	 */
	private List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = nums.length - 1; i > 1; i--) {
			if (nums[i] + nums[i - 1] + nums[i - 2] < 0) {
				break;
			}
			int m = 0 - nums[i];
			for (int j = i - 1, k = 0;
				 j > k; ) {
				int sum = nums[j] + nums[k];
				if (sum == m) {
					result.add(Arrays.asList(nums[i], nums[j--], nums[k++]));
					while (j > k && nums[j] == nums[j + 1]) {
						j--;
					}
					while (j > k && nums[k] == nums[k - 1]) {
						k++;
					}
				} else if (sum > m) {
					j--;
				} else {
					k++;
				}
			}
			while (i > 1 && nums[i] == nums[i - 1]) {
				i--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		T15_ThreeSum t15_threeSum = new T15_ThreeSum();
		int[] data = {-2, 0, 0, 2, 2};
		t15_threeSum.threeSum(data).forEach(list -> list.forEach(System.out::print));
	}
}
