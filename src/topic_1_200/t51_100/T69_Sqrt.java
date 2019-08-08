package topic_1_200.t51_100;

/**
 * T69_Sqrt
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @author ：wy.
 * @date ：Created at 下午2:24 19-7-12
 */
public class T69_Sqrt {

	private int mySqrt(int x) {
		int left = 0;
		int right = x > 50000 ? 50000 : x;
		for (; left < right; ) {
			if (right * right == x) {
				return right;
			}
			int mid = (right + left + 1) >> 1;
			int squart = mid * mid;
			if (squart > x) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		T69_Sqrt sqrt = new T69_Sqrt();
		System.out.println(sqrt.mySqrt(100));
	}
}
