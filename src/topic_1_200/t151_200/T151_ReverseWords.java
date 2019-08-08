package topic_1_200.t151_200;

import java.util.Stack;

/**
 * T151_ReverseWords
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author ：wy.
 * @date ：Created at 下午4:04 19-7-22
 */
public class T151_ReverseWords {

	private String reverseWords(String s) {
		Stack<String> words = new Stack<>();
		StringBuilder wordBuilder = new StringBuilder();
		char[] chars = s.toCharArray();
		for (char ch : chars) {
			if (ch != ' ') {
				wordBuilder.append(ch);
			} else if (wordBuilder.length() > 0) {
				words.add(wordBuilder.toString());
				wordBuilder = new StringBuilder();
			}
		}
		if (wordBuilder.length() != 0) {
			words.add(wordBuilder.toString());
		}
		StringBuilder resultBuilder = new StringBuilder();
		while (!words.isEmpty()) {
			resultBuilder.append(words.pop());
			if (!words.isEmpty()) {
				resultBuilder.append(" ");
			}
		}
		return resultBuilder.toString();
	}

	public static void main(String[] args) {
		String s = "  hello world!  ";
		T151_ReverseWords reverseWords = new T151_ReverseWords();
		System.out.println(reverseWords.reverseWords(s));
	}
}
