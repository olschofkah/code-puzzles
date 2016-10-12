import java.util.HashMap;
import java.util.Map;

public class LinkedListRandomNode {

	public int data;
	public LinkedListRandomNode next;
	public LinkedListRandomNode random;

	public LinkedListRandomNode(int data) {
		this.data = data;
	}

	public LinkedListRandomNode deepCopy() {

		Map<LinkedListRandomNode, LinkedListRandomNode> nodeMap = new HashMap<>();

		LinkedListRandomNode copyPointer;
		LinkedListRandomNode origPointer = this;
		while(origPointer !=null){
			copyPointer = new LinkedListRandomNode(origPointer.data);
			nodeMap.put(origPointer, copyPointer);
			origPointer = origPointer.next;
		}
		
		origPointer = this;
		while(origPointer !=null){
			copyPointer = nodeMap.get(origPointer);
			copyPointer.next = nodeMap.get(origPointer.next);
			copyPointer.random = nodeMap.get(origPointer.random);
			origPointer = origPointer.next;
		}

		return nodeMap.get(this);
	}

}
