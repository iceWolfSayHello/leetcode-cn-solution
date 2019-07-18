package base_algorithm.sort;

import static base_algorithm.sort.SortedUtil.testSorted;

/**
 * QuickSort 快速排序
 * 时间复杂度：         O（N*logN）
 * 是否为原地排序：     是
 * 是否为稳定排序算法： 否
 *
 * @author ：wy.
 * @date ：Created in 下午4:48 19-7-17
 */
public class QuickSort {

    /**
     * 排序下标从 start 到 end 之间的一组数据，选择 end 作为 pivot（分区点,也可以选取 start 或 其他）。
     * 遍历 start 到 end 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
     */
    private void sorted(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int start,int end){
        if (start >= end){
            return;
        }
        //按规则分区并获得分割点
        int pivot = pivot(nums,start,end);
        quickSort(nums,start,pivot-1);
        quickSort(nums,pivot+1,end);
    }

    /**
     * 选取数组中最后一个值作为分区值，定义一个“标记点”从0开始
     * 遍历整个数组，若值小于分区值，则将该值与”标记点“对应的值进行交换，否则不变动
     * 遍历数组完成后，将标记点与分区值进行交换，此时“标记点”即为分区点
     */
    private int pivot(int[] nums, int start, int end){
        int pivotValue = nums[end];
        int index = start;
        int temp;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivotValue){
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        //与pivotValue交换当前分区点中的值
        nums[end] = nums[index];
        nums[index] = pivotValue;
        return index;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        testSorted(quickSort::sorted);
    }
}
