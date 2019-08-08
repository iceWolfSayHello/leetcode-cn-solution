package topic_1_200.t1_50;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 */
public class T20_ValidBrackets {
	private boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] content = s.toCharArray();
		for (int i = 0; i < content.length; i++) {
			char ch = content[i];
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(Character.valueOf(ch));
			} else if (ch == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (top != '(') {
					return false;
				}
			} else if (ch == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (top != '{') {
					return false;
				}
			} else if (ch == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (top != '[') {
					return false;
				}
			}
		}
		if (stack.empty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		T20_ValidBrackets validBrackets = new T20_ValidBrackets();
		System.out.println(validBrackets.isValid("([)]"));
	}
}
