# leetcode-cn-solution
[力扣中文版](https://leetcode-cn.com/)题解（Java版），为了方便查找题解，题解的类名与题目编号保持一致。大家如果有自己的思路或见解，都可以进行提交，欢迎所有人来一起完善。
（注：由于作者习惯，项目中有使用Lambda表达式部分，建议Java版本在 Java8 及以上）
### 项目结构说明
包名|内容
:---:|:---:
src.base_algorithm|算法相关内容，包括排序、查找等 
src.base_data_structure|数据结构相关内容，包括链表、图、跳表等的实现
src.topic_x_x|x对应力扣（中文版）的题目序号，包内皆为题解

### topic_x_x 包中类的说明
每个题目均对应一个Java类，类名的命名规则为&#8195;*Txx_TopicName*&#8195;。类说明中可以加入适量的题目说明，如下：

```
/**
 * T15_ThreeSum
 * 题目：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
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
 * @date ：Created in 10:30 2019/6/25
 */ 
 ```
解题方法名与题目中保持一致。
```
private List<List<Integer>> threeSum(int[] nums) {
    //do something
}
```
每个类中均包含一个 main 方法，其中包含简单的测试内容。
```
public static void main(String[] args) {
    T15_ThreeSum t15_threeSum = new T15_ThreeSum();
    int[] data = {-2, 0, 0, 2, 2};
    t15_threeSum.threeSum(data).forEach(list -> {
        list.forEach(System.out::print);
    });
}
```
---
>有任何问题请联系作者 136153463@qq.com