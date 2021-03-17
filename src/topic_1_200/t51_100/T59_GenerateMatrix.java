package topic_1_200.t51_100;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 1    ->  2   ->  3
 *                  |
 * 8    ->  9       4
 * ^                |
 * 7    <-  6   <-  5
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
public class T59_GenerateMatrix {

    /**
     * 思路同T54_SpiralOrder,不同的地方是T54遍历取数据，该题遍历存数据
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startRow=0,endRow=n-1,startColumn=0,endColumn=n-1;
        boolean isRow = true,positive=true;
        for (int i = 1; i <= n * n;) {
            if (isRow) {
                if (positive) {
                    for (int column = startColumn; column <= endColumn; column++) {
                        matrix[startRow][column] = i++;
                    }
                    positive = true;startRow+=1;
                }else {
                    for (int column = endColumn; column >= startColumn; column--) {
                        matrix[endRow][column] = i++;
                    }
                    positive=false;endRow-=1;
                }
                isRow = false;
            }else {
                if (positive) {
                    for (int row = startRow; row <= endRow; row++) {
                        matrix[row][endColumn] = i++;
                    }
                    positive=false;endColumn-=1;
                }else {
                    for (int row = endRow ; row >= startRow; row--) {
                        matrix[row][startColumn] = i++;
                    }
                    positive=true;startColumn+=1;
                }
                isRow = true;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        T59_GenerateMatrix generateMatrix = new T59_GenerateMatrix();
        int n = 3;
        int[][] matrix = generateMatrix.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
