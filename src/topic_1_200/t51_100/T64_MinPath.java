package topic_1_200.t51_100;

/**
 * T64_MinPath
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author : wy.
 * @date : Create at 17:57 2019/8/13
 */
public class T64_MinPath {

	//采用动态规划的方式，用PathSum数组记录 经历过的点至终点的最短距离
	//递归方程为 pathSum(i,j) = grid[i][j] + min( walk(grid[i+1][j]),walk(grid[i][j+1]))
	int gridRows;
	int gridVols;
	int[][] pathSum = null;
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length <= 0){
			return 0;
		}
		gridRows = grid.length;
		gridVols = grid[0].length;
		pathSum = new int[gridRows][gridVols];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				pathSum[i][j] = -1;
			}
		}
		return walk(grid, 0, 0, grid[0][0]);
	}

	private int walk(int[][] grid, int currentRow, int currentVol, int sum) {
		sum = +grid[currentRow][currentVol];
		if (currentRow == grid.length - 1 && currentVol == grid[0].length - 1) {
			return sum;
		}
		int downStep = Integer.MAX_VALUE;
		int rightStep = Integer.MAX_VALUE;
		if (currentRow + 1 < gridRows) {
			if (pathSum[currentRow + 1][currentVol] == -1) {
				downStep = walk(grid, currentRow + 1, currentVol, sum);
				pathSum[currentRow + 1][currentVol] = downStep;
			} else downStep = pathSum[currentRow + 1][currentVol];
		}
		if (currentVol + 1 < gridVols) {
			if (pathSum[currentRow][currentVol + 1] == -1) {
				rightStep = walk(grid, currentRow, currentVol + 1, sum);
				pathSum[currentRow][currentVol + 1] = rightStep;
			} else rightStep = pathSum[currentRow][currentVol + 1];
		}
		return sum + (downStep < rightStep ? downStep : rightStep);
	}

	public static void main(String[] args) {
		int[][] grid = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		T64_MinPath minPath = new T64_MinPath();
		System.out.println(minPath.minPathSum(grid));
	}
}
