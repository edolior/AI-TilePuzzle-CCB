import java.util.*;
import java.util.List;

public class UniformCostSearch   extends ASearch
{
	private PriorityQueue<ASearchNode>  pQueue;
	private List<ASearchNode> 		closedList;


	@Override
	public String getSolverName() 
	{
		return "UCS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		    this.pQueue      = new PriorityQueue<>();
			this.closedList  =     new ArrayList<>();
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
		return this.pQueue.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return this.closedList.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		this.pQueue.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		this.closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		return this.pQueue.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return this.pQueue.poll();
	}

}
