package topic_201_400.t301_350;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class T341_NestedIterator implements Iterator<Integer> {

    Integer[] valueArray;

    int size = 0;
    int readIndex = 0;

    public T341_NestedIterator(List<NestedInteger> nestedList) {
        int listSize = nestedList.size();
        if (listSize == 0) {return;}
        valueArray = new Integer[listSize];
        addValueByNestedInteger(nestedList);
    }

    private void addValueByNestedInteger(List<NestedInteger> list) {
        if (list == null || list.isEmpty()) {return;}
        for (NestedInteger nestedInteger : list) {
            if (nestedInteger.isInteger()) {
                add(nestedInteger.getInteger());
            }else {
                addValueByNestedInteger(nestedInteger.getList());
            }
        }
    }

    private void add(Integer value) {
        resize();
        valueArray[size++] = value;
    }

    private void resize() {
        if (size < valueArray.length) {return;}
        int size = this.size <<1;
        valueArray = Arrays.copyOf(valueArray, size);
    }

    @Override
    public boolean hasNext() {
        return readIndex < size;
    }

    @Override
    public Integer next() {
        return valueArray[readIndex++];
    }

    public static void main(String[] args) {
        NestedIntegerImpl one = new NestedIntegerImpl();
        one.value = 1;
        NestedIntegerImpl two = new NestedIntegerImpl();
        two.value = 2;

        NestedIntegerImpl first = new NestedIntegerImpl();
        first.list = Arrays.asList(one,one);
        NestedIntegerImpl second = new NestedIntegerImpl();
        second.list = Arrays.asList(one,one);

        T341_NestedIterator nestedIterator = new T341_NestedIterator(Arrays.asList(first, two, second));
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next() + "\t");
        }
    }

}

interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger{
    Integer value = null;
    List<NestedInteger> list = null;

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
