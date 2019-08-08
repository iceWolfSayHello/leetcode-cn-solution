package base_algorithm.sort;

import java.util.Random;
import java.util.function.Consumer;

import static java.lang.System.currentTimeMillis;

/**
 * SortedUtil
 *
 * @author ：wy.
 * @date ：Created at 下午3:34 19-7-17
 */
class SortedUtil {

	static void testSorted(Consumer<int[]> consumer) {
		//随机生成数字
		Random random = new Random(System.currentTimeMillis());
		int[] nums = new int[1000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(100);
		}
		//排序
		long startTime = currentTimeMillis();
		consumer.accept(nums);
		System.out.println("sorted Time :" + (currentTimeMillis() - startTime));
		//输出排序后的数字
		for (int num : nums) {
			System.out.print(num + ",");
		}
	}

}
