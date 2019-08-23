package topic_1_200.t101_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T120_MinimumTotal
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * @author : wy.
 * @date : Create at 10:52 2019/8/23
 */
public class T120_MinimumTotal {

	//采用自底而上的方式进行计算
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		int[] total = new int[size];
		for (int i = 0; i < triangle.size(); i++) {
			total[i] = triangle.get(size - 1).get(i);
		}
		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				total[j] = Math.min(total[j],total[j+1])+triangle.get(i).get(j);
			}
		}
		return total[0];
	}


	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>(4);
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		T120_MinimumTotal minimumTotal = new T120_MinimumTotal();
		System.out.println(minimumTotal.minimumTotal(triangle));
	}
}
