import java.util.*;
import java.util.function.Function;

public class AStarSearch   extends ASearch
{
	private ArrayList<ASearchNode>  pQueue;
	private List<ASearchNode> 		closedList;

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
		this.pQueue     = new ArrayList<>();
		this.closedList =     new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen
			(
					ASearchNode node
			)
	{
		for (int i = 0; i <pQueue.size() ; i++) {
			if(node.equals((ASearchNode)pQueue.get(i))){
				return (ASearchNode)pQueue.get(i);
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
		if(pQueue.isEmpty()){
			pQueue.add(node);
		}else {
			pQueue.add(node);
			pQueue.sort(Comparator.comparing(ASearchNode::getF));
		}
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
		ASearchNode nsd = pQueue.get(0);
		pQueue.remove(0);
		return nsd;
	}
}
