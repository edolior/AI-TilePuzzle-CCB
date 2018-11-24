import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	private Queue<ASearchNode> openList;
	private Queue<ASearchNode> closedList;

	
	@Override
	public String getSolverName() 
	{
		return "BFS";
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
		openList = new LinkedList<>();
		closedList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	)
	{
		if (!openList.isEmpty() && node != null) {
			int size = openList.size();
			int iNode = 0;
			boolean found = false;
			ASearchNode currNode = null;
			ASearchNode ansNode = null;
			while (iNode < size && !found) {
				currNode = openList.poll();
				if (node.equals(currNode)) {
					ansNode = currNode;
					found = true;
				}
				openList.add(currNode);
				iNode++;
			}
			while (iNode < size) {
				currNode = openList.poll();
				openList.add(currNode);
				iNode++;
			}
			if (found)
				return ansNode;
			else
				return null;
		}
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	)
	{
	if (!openList.isEmpty() && node != null) {
		int size = openList.size();
		int iNode = 0;
		boolean found = false;
		ASearchNode currNode = null;
		while (iNode < size && !found) {
			currNode = openList.poll();
			if (node.equals(currNode))
				found = true;
			openList.add(currNode);
			iNode++;
		}
		while (iNode < size) {
			currNode = openList.poll();
			openList.add(currNode);
			iNode++;
		}
		return found;
	}
	return false;
	}


	@Override
	public boolean isClosed
	(
		ASearchNode node
	)
	{
	if (!closedList.isEmpty() && node != null) {
		int size = closedList.size();
		int iNode = 0;
		boolean found = false;
		ASearchNode currNode = null;
		while (iNode < size && !found) {
			currNode = closedList.poll();
			if (node.equals(currNode))
				found = true;
			closedList.add(currNode);
			iNode++;
		}
		while (iNode < size) {
			currNode = closedList.poll();
			closedList.add(currNode);
			iNode++;
		}
		return found;
	}
	return false;
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		if (node != null)
			openList.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	)
	{
		if (node != null)
			closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		if (!openList.isEmpty())
			return openList.size();
		else
			return 0;
	}

	@Override
	public ASearchNode getBest() 
	{
		if (!openList.isEmpty())
			return openList.poll();
		else
			return null;
	}

	

}
