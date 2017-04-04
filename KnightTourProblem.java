
public class KnightTourProblem {
	private final static int MAX_SIZE = 8;
	public static void main(String args[]){
		solution();
	}
	private static boolean isSafe(int x,int y,int sol[][]){
		return (x >= 0 && x < MAX_SIZE && y>= 0 && y < MAX_SIZE && sol[x][y]==0);
	}
	private static void solution(){
		int sol[][] = new int[MAX_SIZE][MAX_SIZE];
		int xMove[] = new int[]{2,1,-1,-2,-2,-1,1,2};
		int yMove[] = new int[]{1,2,2,1,-1,-2,-2,-1};
		sol[0][0]=1;
		solve(0,0,1,sol,xMove,yMove);
	}
	private static void print(int sol[][]){
		for(int i=0;i<sol.length;i++){
			for(int j=0;j<sol[i].length;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void  solve(int x,int y, int moves, int sol[][],int xMove[],int yMove[]){
		if(moves==MAX_SIZE*MAX_SIZE){
			System.out.println("Solution Found : ");
			print(sol);
			return;
		}
		for(int i=0;i<xMove.length;i++){
			int nextX = x + xMove[i];
			int nextY = y + yMove[i];
			if(isSafe(nextX, nextY, sol)){
				sol[nextX][nextY]  = moves ;
				solve(nextX,nextY,moves+1,sol,xMove,yMove);
				sol[nextX][nextY] =  0;
			}
			
		}
	}
}
