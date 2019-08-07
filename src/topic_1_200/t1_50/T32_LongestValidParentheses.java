package topic_1_200.t1_50;

import java.util.Stack;

/**
 * T32_LongestValidParentheses
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @author ：wy.
 * @date ：Created at 上午11:36 19-7-8
 */
public class T32_LongestValidParentheses {
    private int longestValidParentheses(String s) {
        Stack<Integer> context = new Stack<>();
        int maxNum = 0;
        context.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                context.push(i);
            }else {
                context.pop();
                if (context.isEmpty()){
                    context.push(i);
                }else {
                    int newValue = i - context.peek();
                    maxNum = newValue> maxNum ? newValue : maxNum;
                }
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        String text = ")()())";
        T32_LongestValidParentheses validParentheses = new T32_LongestValidParentheses();
        System.out.println(validParentheses.longestValidParentheses(text));
    }
}
