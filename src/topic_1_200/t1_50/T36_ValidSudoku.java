package topic_1_200.t1_50;

/**
 * T36_ValidSudoku
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 * @author : wy.
 * @date : Create at 15:04 2019/8/11
 */
public class T36_ValidSudoku {
	//本题解题思路主要是判断 行/列/子宫格 中是否已经存在相应字符，本次采用暴力方法，遍历 行/列/子宫格 来验证其的正确性
	//TODO 还可用HashMap的数组来存储数字出现的次数，来判断是否正确，利用Hash的特性降低时间复杂度

	//行数
	int rows = 9;
	//列数
	int vols = 9;
	//子九宫格的行数
	int subGridRows = 3;
	//子九宫格的列数
	int subGridVols = 3;
	public boolean isValidSudoku(char[][] board) {
		for (int row = 0; row < rows; row++) {
			for (int vol = 0; vol < vols; vol++) {
				if (board[row][vol] == '.') {
					continue;
				}
				if (!(validRows(board, row, vol) && validVols(board, row, vol) && validSubGrid(board, row, vol))) {
					return false;
				}
			}
		}
		return true;
	}

	//验证一行中是否存在相同字符
	private boolean validRows(char[][] board, int row, int vol) {
		for (int i = 0; i < vols; i++) {
			if (i != vol && board[row][i] == board[row][vol]) {
				return false;
			}
		}
		return true;
	}

	//验证列中是否存在相同空格
	private boolean validVols(char[][] board, int row, int vol) {
		for (int i = 0; i < rows; i++) {
			if (i != row && board[i][vol] == board[row][vol]) {
				return false;
			}
		}
		return true;
	}

	//验证子宫格中是否存在当前字符
	private boolean validSubGrid(char[][] board, int row, int vol) {
		int startRow = row / subGridRows * subGridRows;
		int startVol = vol / subGridVols * subGridVols;
		//循环遍历子宫格中是否存在相同字符
		for (int x = 0; x < subGridRows; x++) {
			for (int y = 0; y < subGridVols; y++) {
				int currentRow = startRow + x;
				int currentVol = startVol + y;
				if (currentRow == row && currentVol == vol) {
					continue;
				}
				if (board[currentRow][currentVol] == board[row][vol]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		T36_ValidSudoku validSudoku = new T36_ValidSudoku();
		System.out.println(validSudoku.isValidSudoku(board));
	}
}
