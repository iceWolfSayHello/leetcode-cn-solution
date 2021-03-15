package topic_1_200.t51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 *
 * 1    ->  2   ->  3
 *                  |
 * 4    ->  5       6
 * ^                |
 * 7    <-  8   <-  9
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 *
 * 1    ->  2   ->  3   ->  4
 *                          |
 * 5    ->  6   ->  7       8
 * ^                        |
 * 9    ->  10  ->  11  ->  12
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class T54_SpiralOrder {

    /**
     * 可将矩阵的螺旋遍历过程共划分为四种子过程
     * 1 正向行级遍历（从左到右） 2 逆向行级遍历（从右到左）
     * 3 正向列级遍历（从上到下） 4 逆向列级遍历（从下到上）
     * 将遍历过程划分为四种后，可利用四个边界的index及两个用于标识 “行列” “正逆向” 的flag，分别采取不同的遍历方式即可
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0 , endRow = matrix.length - 1,
                startColumn = 0, endColumn = matrix[0].length - 1;
        boolean isRow = true, positive = true;
        List<Integer> resultList = new ArrayList<>(matrix.length * matrix[0].length);
        for (;;) {
            if (startRow > endRow || startColumn > endColumn) {break;}
            if (isRow) {
                if (positive) {
                    // 行级正序
                    for (int column = startColumn; column <= endColumn; column++) {
                        resultList.add(matrix[startRow][column]);
                    }
                    startRow += 1;isRow = false;positive=true;
                }else {
                    // 行级逆序
                    for (int column = endColumn; column >= startColumn; column --) {
                        resultList.add(matrix[endRow][column]);
                    }
                    endRow -= 1;isRow = false;positive=false;
                }
            }else {
                if (positive) {
                    // 列级正序
                    for (int row = startRow; row <= endRow; row++) {
                        resultList.add(matrix[row][endColumn]);
                    }
                    endColumn -= 1;isRow = true;positive=false;
                }else {
                    // 列级逆序
                    for (int row = endRow; row >= startRow; row--) {
                        resultList.add(matrix[row][startColumn]);
                    }
                    startColumn += 1;isRow = true;positive=true;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        T54_SpiralOrder spiralOrder = new T54_SpiralOrder();
        spiralOrder.spiralOrder(test).forEach(e -> System.out.print(e + " -> "));
    }
}
