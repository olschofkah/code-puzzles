import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class DataStructuresTest {

	@Test
	public void testShit() throws Exception {
		System.out.println(1 << 30);
	}

	@Test
	public void testShit2() throws Exception {
		int[] input = new int[] { 2, 4, 5, 2, 6, 7, 34, 5, 2, 4, 6, 56, 2, 34,1 };
		int target = 6;

		Set<SideAgnosticPair> pairs = new HashSet<>();
		Set<Integer> targets = new HashSet<>();

		for (int i = 0; i < input.length; i++) {
			if (targets.contains(input[i])) {
				pairs.add(new SideAgnosticPair(input[i], target - input[i]));
			} else {
				targets.add(target - input[i]);
			}
		}

		System.out.println(pairs);

	}

	@Test
	public void testNodePrint1() throws Exception {
		// print left to right
		TreeNode<Integer> tree = generateTree();
		// printTreeNormal(tree);
		System.out.println();
		// printTreeHorizontal(tree);
		System.out.println();
		printTreeVertical(tree);
	}

	public void printTreeNormal(TreeNode<?> node) {
		System.out.println(node);
		if (node.getLeft() != null) {
			printTreeNormal(node.getLeft());
		}
		if (node.getRight() != null) {
			printTreeNormal(node.getRight());
		}
	}

	public void printTreeHorizontal(TreeNode<Integer> node) {
		Map<Integer, List<Integer>> depthMap = new HashMap<>();
		printTreeHorizontal(node, depthMap, 0);

		for (List<?> row : depthMap.values()) {
			System.out.println(row);
		}
	}

	public void printTreeHorizontal(TreeNode<Integer> node, Map<Integer, List<Integer>> depthMap, int depth) {

		if (node == null) {
			return;
		}

		List<Integer> row = depthMap.get(depth);
		if (row == null) {
			row = new ArrayList<Integer>();
			depthMap.put(depth, row);
		}
		row.add(node.getValue());
		printTreeHorizontal(node.getLeft(), depthMap, depth + 1);
		printTreeHorizontal(node.getRight(), depthMap, depth + 1);

	}

	public void printTreeVertical(TreeNode<Integer> node) {
		Map<Integer, List<Integer>> offsetMap = new HashMap<>();
		printTreeVertical(node, offsetMap, 0);

		List<Integer> offsetList = new ArrayList<Integer>(offsetMap.keySet());
		//Collections.sort(offsetList);
		SortUtil.bubbleSort(offsetList);
		for (Integer offset : offsetList) {
			System.out.println(offsetMap.get(offset));
		}
	}
	

	public void printTreeVertical(TreeNode<Integer> node, Map<Integer, List<Integer>> offsetMap, int offset) {

		if (node == null) {
			return;
		}

		List<Integer> row = offsetMap.get(offset);
		if (row == null) {
			row = new ArrayList<Integer>();
			offsetMap.put(offset, row);
		}
		row.add(node.getValue());
		printTreeVertical(node.getLeft(), offsetMap, offset - 1);
		printTreeVertical(node.getRight(), offsetMap, offset + 1);

	}

	public TreeNode<Integer> generateTree() {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left(new TreeNode<Integer>(2)).getLeft().right(new TreeNode<Integer>(5)).left(new TreeNode<Integer>(4));
		// root.getLeft()
		// .getLeft()
		// .right(new TreeNode<Integer>(95))
		// .left(new TreeNode<Integer>(96));
		// root.getLeft()
		// .getRight()
		// .right(new TreeNode<Integer>(68))
		// .left(new TreeNode<Integer>(69));
		root.right(new TreeNode<Integer>(3)).getRight().right(new TreeNode<Integer>(7)).left(new TreeNode<Integer>(6));
		root.getRight().getLeft().right(new TreeNode<Integer>(8));
		// .left(new TreeNode<Integer>(42));
		root.getRight().getRight().right(new TreeNode<Integer>(9));
		// .left(new TreeNode<Integer>(51));

		return root;
	}

}