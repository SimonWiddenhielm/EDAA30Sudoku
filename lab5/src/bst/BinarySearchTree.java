package bst;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	private int size;
	private int counter;
	private int mDepth;
	private boolean trueCaller;
	private int index;



	
	 
	public BinarySearchTree() {

		root = null;
		size = 0;
		counter = 0;
		mDepth=0;


	}
	

	
	
	private void add(E x,BinaryNode<E> node) {

		if ( node == root && root == null) { // case 1: height =0 Plantera rooten
			root = new BinaryNode<E>(x);
			trueCaller = true;
			size++;
			return;
		}
	

		else if (node.element.compareTo(x) > 0) { // Avgrenar åt vänster
			if (node.left == null) {
				node.left = new BinaryNode<E>(x);
				trueCaller = true;
				size++;
				return;
			}
			add(x,node.left);



		}
		else if ( node.element.compareTo(x) == 0) {

			trueCaller = false;
			return;
		}
		else if (node.element.compareTo(x) < 0) { // Avgrenar åt  högre höger :)
			if (node.right==null) {
				node.right = new BinaryNode<E>(x);
				trueCaller = true;
				size++;
				return;

			}
			add(x,node.right);
		}




	}
	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted	
	 * @return true if the the element was inserted
	 * Metoden ska lägga in elementet x i trädet om det inte redan finns. Metoden ska returnera
		true om insättningen kunde utföras, annars false. Implementeringen ska vara rekursiv.
	 */
	public boolean add(E x) {
		add(x,root);
		return trueCaller;
	}

	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		mDepth=0;
		maxDepth(root);
		return mDepth;
	}
	private void maxDepth (BinaryNode<E> rot) {
		if (root == null ) {
			mDepth=0;
			return;
		}
		counter++;
		if (rot.left==null&&rot.right ==null) {
			if (counter > mDepth) {
				mDepth = counter;
			}	
			counter--;
		}
		if(rot.left != null ) maxDepth(rot.left);
		if(rot==root) counter =1;
		if(rot.right != null )maxDepth(rot.right);

	}


	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {

		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);




	}
	private void printTree(BinaryNode<E> node) {
		if (node != null) {
			printTree(node.left);
			System.out.print(node.element + " ");
			printTree(node.right);

		}

	}


	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		index =0;
		toArray(root,a);
		root = buildTree(a,0,a.length-1);

	}


	/** 
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a,int index) {

		if (n!= null) {
			index= toArray(n.left,a,index);
			a[index]=n.element;
			index++;
			index = toArray(n.right,a,index);

		}
		return index;
		
	}

	/**
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		
		if ( first >last) {
			return null;
		}
		int mid = (last+first)/2;
		
		BinaryNode<E> mitt = new BinaryNode<E>(a[mid]);
		mitt.left = buildTree(a,first,mid-1);
		mitt.right = buildTree(a,mid+1,last);
		return mitt;
		
		
		
		
	}


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}

}
