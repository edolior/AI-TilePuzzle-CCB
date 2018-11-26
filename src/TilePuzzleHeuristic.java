import java.util.HashMap;


public class TilePuzzleHeuristic implements IHeuristic
{

	private HashMap<Integer, int[]> map;

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		return calcH(problemState);
	}

	private void setHeuristic(int size){
		map = new HashMap<>();
		int count = 1;
		boolean stop = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == size-1 && j == size-1)
					map.put(0, new int[]{i, j});
				else {
					map.put(count, new int[]{i, j});
					count++;
				}
			}
		}
	}

	private int calcH(IProblemState problemState) {
		IProblemState reducedProblem = new TilePuzzleState((TilePuzzleState)problemState);
		int[][] myGridState = (int[][])reducedProblem.getCurrentStateCopy();
		int size = myGridState.length;
		setHeuristic(size);
		int result = 0;
		int destSpot = 0;
		int currSpot = 0;
		for (int row = 0; row < size; row ++)
			for (int col = 0; col < size; col ++) {
				if (row == size-1 && col == size-1)
					destSpot = 0;
				else
					destSpot = row * size + col + 1;
				currSpot = myGridState[row][col];
				if (currSpot != destSpot && currSpot != 0) {
					int[] curr = map.get(currSpot);
					result = result + ((Math.abs(row - curr[0]) + Math.abs(col - curr[1])) * currSpot);
				}
			}
		return result;
	}
}
