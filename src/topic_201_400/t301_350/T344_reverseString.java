package topic_201_400.t301_350;

/**
 * T344_reverseString
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @author ：wy.
 * @date ：Created at 下午3:16 19-7-19
 */
public class T344_reverseString {

    /**
     * 字符串的反转可以理解为对应字符的交换（例如第一个和最后一个）
     * 解决思路：将两个char的值相加起来并赋给前一个char，后面的char通过第一个char减去当前的值，便得到了需要反转的字符值
     * 最后再将前面的char的值减去后一个char值，则可以获得需要的字符的值
     */
    private void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2 ; i++) {
            int exchangeIndex = s.length -1 - i;
            s[i] += s[exchangeIndex];
            s[exchangeIndex] = (char) (s[i] - s[exchangeIndex]);
            s[i] -= s[exchangeIndex];
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};
        T344_reverseString reverseString = new T344_reverseString();
        reverseString.reverseString(chars);
        System.out.println(chars);
    }
}
