package base_algorithm.sort;

import static base_algorithm.sort.SortedUtil.testSorted;

/**
 * MergeSort 归并排序
 * 时间复杂度：         O（N*logN），可使用递归树分析法分析
 * 是否为原地排序：     否, merge方法中需要临时数组
 * 是否为稳定排序算法： 是
 *
 * @author ：wy.
 * @date ：Created at 下午4:06 19-7-17
 */
public class MergeSort {

	/**
	 * 归并排序使用的就是分治思想。先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
	 * 思路类似于 Hadoop 的 Mapper—Reduce，Java 的 Fork-Join。
	 */
	private void sorted(int[] nums) {
		partitionSort(nums, 0, nums.length - 1);
	}

	private void partitionSort(int[] nums, int start, int end) {
		//终止条件
		if (start >= end) {
			return;
		}
		int mid = (end + start) >> 1;
		partitionSort(nums, start, mid);
		partitionSort(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}

	private void merge(int[] nums, int start, int mid, int end) {
		int firstIndex = start, secondIndex = mid + 1;
		//临时数组
		int[] tempArray = new int[end - start + 1];
		int tempIndex = 0;
		//从两个区间内取出最小的数放入临时数组内
		for (; firstIndex <= mid && secondIndex <= end; ) {
			if (nums[firstIndex] < nums[secondIndex]) {
				tempArray[tempIndex] = nums[firstIndex];
				firstIndex++;
			} else {
				tempArray[tempIndex] = nums[secondIndex];
				secondIndex++;
			}
			tempIndex++;
		}
		//将剩余数字复制到临时数组中
		while (firstIndex <= mid) {
			tempArray[tempIndex] = nums[firstIndex];
			firstIndex++;
			tempIndex++;
		}
		while (secondIndex <= end) {
			tempArray[tempIndex] = nums[secondIndex];
			secondIndex++;
			tempIndex++;
		}
		//将临时数组中的数字赋值回原数组中
		for (int i = 0; i < tempArray.length; i++) {
			nums[start + i] = tempArray[i];
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		testSorted(mergeSort::sorted);
	}

}
