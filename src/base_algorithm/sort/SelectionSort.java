package base_algorithm.sort;

import static base_algorithm.sort.SortedUtil.testSorted;

/**
 * SelectionSort 选择排序
 * 时间复杂度：         O（N^2）
 * 是否为原地排序：     是
 * 是否为稳定排序算法： 否
 *
 * @author ：wy.
 * @date ：Created in 下午3:46 19-7-17
 */
public class SelectionSort {

    /**
     * 选择排序算法类似插入排序，分已排序区间和未排序区间。
     * 但是选择排序每次会从未排序区间中找到最大的元素，将其放到已排序区间的末尾。
     */
    private void sorted(int[] nums){
        for (int i = 0; i < nums.length -1; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        testSorted(sort::sorted);
    }
}
