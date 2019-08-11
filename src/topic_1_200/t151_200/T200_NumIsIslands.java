package topic_1_200.t151_200;

/**
 * T200_NumIsIslands
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 *
 * @author : wy.
 * @date : Create at 14:09 2019/8/11
 */
public class T200_NumIsIslands {

	//采用深度优先遍历
	int num = 0;
	int rows = 0;
	int vols = 0;
	public int numIslands(char[][] grid) {
		if (grid==null || grid.length==0){
			return 0;
		}
		rows = grid.length;
		vols = grid[0].length;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < vols; x++) {
				if (grid[y][x]=='1'){
					scanAroundIslands(grid,x,y);
					num++;
				}
			}
		}
		return num;
	}

	//将该节点标记为2（已扫描），并递归深度扫描所有邻接节点
	private void scanAroundIslands(char[][] grid, int x, int y){
		grid[y][x] = '2';
		//上方连接
		if (y-1>=0 && grid[y-1][x] =='1') {
			scanAroundIslands(grid,x,y-1);
		}
		//下方连接
		if (y+1 < rows && grid[y+1][x] =='1'){
			scanAroundIslands(grid,x,y+1);
		}
		//左边连接
		if (x -1 >= 0 && grid[y][x-1] =='1'){
			scanAroundIslands(grid,x-1,y);
		}
		//右边连接
		if (x +1 < vols && grid[y][x+1] =='1'){
			scanAroundIslands(grid,x+1,y);
		}
	}

	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},};
		T200_NumIsIslands isIslands = new T200_NumIsIslands();
		System.out.println(isIslands.numIslands(grid));
	}
}
