package topic_1_200.t151_200;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * @author ：wy.
 * @date ：Created in 10:53 2020/12/4
 */
public class T187_DuplicateDNA {

    /**
     * 两个指针获取当前字符串，并用一个Map存放已经遍历过的字符串及出现的次数，最终将次数大于2的字符串返回
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {return Collections.emptyList();}
        int startIndex = 0, endIndex = 10;
        HashMap<String, Integer> strMapCount = new HashMap<>();
        while (endIndex <= s.length()) {
            String content = s.substring(startIndex,endIndex);
            if (strMapCount.containsKey(content)) {
                Integer count = strMapCount.get(content);
                if (count == 1){
                    strMapCount.put(content, count + 1);
                }
            }else {
                strMapCount.put(content, 1);
            }
            startIndex ++ ; endIndex ++;
        }
        return strMapCount.entrySet().stream()
                .filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String testStr = "AAAAAAAAAAAAA";
        T187_DuplicateDNA duplicateDNA = new T187_DuplicateDNA();
        List<String> repeatedDnaSequences = duplicateDNA.findRepeatedDnaSequences(testStr);
        System.out.println(Arrays.toString(repeatedDnaSequences.toArray()));
    }
}
