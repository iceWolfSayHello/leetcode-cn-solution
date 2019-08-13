package topic_1_200.t1_50;

/**
 * T10_RegexMatch
 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * @author : wy.
 * @date : Create at 16:38 2019/8/13
 */
public class T10_RegexMatch {

	/**
	 * 当模式串中不包含 * 时，仅需一个一个字符进行匹配即可
	 * 模式串中包含 * 时，均出现在一个字符之后，因此可利用字符串截取和判断是否包含 * 的方式进行递归判断
	 */
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) return s.isEmpty();
		boolean firstMatch =false;
		if (!s.isEmpty() &&
				(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
			firstMatch = true;
		}
		if (p.length() >= 2 && p.charAt(1) == '*'){
			//在模式串的第二个字符为 * 的时候
			//如果 模式串p从第三个字符开始可以与匹配串s匹配成功
			//或者 第一个字符串匹配成功 并且 匹配串从第二个字符开始可以与模式串匹配成功
			//则说明字符串匹配成功
			if (isMatch(s,p.substring(2)) ||
					(firstMatch && isMatch(s.substring(1),p)) ){
				return true;
			}else return false;
		}else {
			return firstMatch && isMatch(s.substring(1),p.substring(1));
		}
	}

	public static void main(String[] args) {
		T10_RegexMatch regexMatch = new T10_RegexMatch();
		System.out.println(regexMatch.isMatch("mississippi","mis*is*ip*."));
	}
}
