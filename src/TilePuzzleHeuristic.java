import java.util.ArrayList;
import java.util.List;

public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		return initState(problemState);
	}

	private int initState(IProblemState problemState) {
		IProblemState reducedProblem = new TilePuzzleState((TilePuzzleState)problemState);
		int[][] myGridState = (int[][])reducedProblem.getCurrentStateCopy();
		int size = myGridState.length;
		for (int row = 0; row < size; row ++)
			for (int col = 0; col < size; col ++)
				if (myGridState[row][col] == 5 ||
						myGridState[row][col] == 6 ||
							myGridState[row][col] == 7 ||
								myGridState[row][col] == 8)
					myGridState[row][col] = 1;
		((TilePuzzle)reducedProblem.getProblem()).setTilePuzzle(myGridState,(TilePuzzle)problemState.getProblem());
		return solveState(reducedProblem);
	}

	private int solveState(IProblemState problemState) {
		UniformCostSearch 	ucs = new UniformCostSearch();
		IProblem myProblem = problemState.getProblem();
		List<IProblemMove> mySol = ucs.solve(myProblem);
		if(mySol != null) {
			return mySol.size();
		}
		else{
			return 0;
		}
	}
	
}
