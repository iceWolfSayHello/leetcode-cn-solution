package topic_1_200.t151_200;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author ：wy.
 * @date ：Created in 10:53 2019/6/26
 */
public class T169_MajorityElement {
    public int majorityElementWithHash(int[] nums) {
        HashMap<Integer, Integer> content = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (content.containsKey(nums[i])) {
                content.put(nums[i], content.get(nums[i]) + 1);
            } else {
                content.put(nums[i], 1);
            }
        }
        return content.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    private int majorityElementWithVote(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 1, 3};
        T169_MajorityElement majorityElement = new T169_MajorityElement();
        System.out.println(majorityElement.majorityElementWithVote(nums));
    }
}
