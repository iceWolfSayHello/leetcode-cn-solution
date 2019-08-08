package base_algorithm.sort;

import static base_algorithm.sort.SortedUtil.testSorted;

/**
 * InsertionSort 普通插入排序
 * 时间复杂度：         O（N^2）,相比较冒泡排序，赋值操作较少，理论上插入相比冒泡，效率较高
 * 是否为原地排序：     是
 * 是否为稳定排序算法： 是
 *
 * @author ：wy.
 * @date ：Created at 下午3:07 19-7-17
 */
public class InsertionSort {

	/**
	 * 将数组中分为已排序区间和未排序区间,取未排序区间中的元素，
	 * 在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
	 */
	private void sorted(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int value = nums[i];
			for (int j = i; j > 0; j--) {
				if (value < nums[j - 1]) {
					nums[j] = nums[j - 1];
				} else {
					nums[j] = value;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		testSorted(insertionSort::sorted);
	}
}
