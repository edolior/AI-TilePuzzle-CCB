import java.util.ArrayList;
import java.util.List;

abstract public class ASearchNode implements  Comparable<ASearchNode>
{
	ASearchNode		_prev;
	IProblemState	_currentProblemState;
	
	public List<ASearchNode> getNeighbors() 
	{
		List<ASearchNode> 	neighbors 		= new ArrayList<ASearchNode>();
		List<IProblemState> neighborStates 	= _currentProblemState.getNeighborStates();
		
		for (IProblemState state : neighborStates)
		{
			ASearchNode newNode = createSearchNode(state);
			neighbors.add(newNode);
		}
		return neighbors;
	}
	
	public boolean isGoal()
	{
		return _currentProblemState.isGoalState();
	}
	
	public IProblemMove getLastMove()
	{
		return _currentProblemState.getStateLastMove();
	}

	abstract public double 		getH();
	
	abstract public double 		getG();
	
	abstract public double 		getF();
	
	abstract public ASearchNode createSearchNode(IProblemState currentProblemState);

	@Override
	public int compareTo(ASearchNode otherState) {
		if(this.getF() > otherState.getF()) {
			return 1;
		} else if (this.getF() < otherState.getF()) {
			return -1;
		} else {
			return 0;
		}
	}

}
