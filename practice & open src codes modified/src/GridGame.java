
public class GridGame {
	public int winningMoves(String[] grid){
		
		char[][] charGrid = new char[grid.length][grid[0].length()];
		
		for(int i = 0; i < grid.length; i++){
			charGrid[i] = grid[i].toCharArray();
		}
		
		return countWins(charGrid);
	}
	
	public int countWins(char[][] grid){
		
		int numWins = 0;
		
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[r].length; c++){
				
				if(canPlace(grid, r, c)){
					grid[r][c] = 'X';
					int oppWin = countWins(grid); // see opponents's win
					if(oppWin == 0) {   // Oppo can't win
						numWins+=1;
					}
					grid[r][c] = '.';	 //  BACKTRACKING, moving on in for loop
				}
			}	
		}
		
		return numWins;
	}
	
	public boolean canPlace(char[][] grid, int r, int c){
		if(grid[r][c] == 'X') return false;
		if( r > 0 && grid[r-1][c] == 'X') return false;
		if( r < 3 && grid[r+1][c] == 'X') return false;
		if( c > 0 && grid[r][c-1] == 'X') return false;
		if( c < 3 && grid[r][c+1] == 'X') return false;
		return true;
		
	}
}