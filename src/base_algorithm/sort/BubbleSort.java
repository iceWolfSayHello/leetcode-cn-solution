package base_algorithm.sort;

import static base_algorithm.sort.SortedUtil.testSorted;

/**
 * BubbleSort 冒泡排序
 * 时间复杂度：         O（N^2）
 * 是否为原地排序：     是
 * 是否为稳定排序算法： 是
 *
 * @author ：wy.
 * @date ：Created in 下午2:52 19-7-17
 */
public class BubbleSort{

    /**
     * 每次操作对相邻的两个元素进行比较，看是否满足大小关系要求,如果不满足就进行互换。
     */
    private void sorted(int[] nums){
        int temp;
        for (int i = nums.length -1; i >= 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        testSorted(bubbleSort::sorted);
    }
}
