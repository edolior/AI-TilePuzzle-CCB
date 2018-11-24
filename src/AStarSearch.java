import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch   extends ASearch
{
	private PriorityQueue<ASearchNode> pQueue;
	private List<ASearchNode> closedList;
	
	@Override
	public String getSolverName() 
	{
		return "AStar";
	}
	
	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists() 
	{
		this.pQueue     = new PriorityQueue<>();
		this.closedList =     new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		Object[] pQArray = pQueue.toArray();
		for (int i = 0; i <pQueue.size() ; i++) {
			if(node.equals((ASearchNode)pQArray[i])){
				return (ASearchNode)pQArray[i];
			}
		}
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return pQueue.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return closedList.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		pQueue.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		return pQueue.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return pQueue.poll();
	}

}
