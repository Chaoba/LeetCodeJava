package com.mushuichuan;

import java.util.HashMap;

public class Algorithm146 {
	int currentSize = 0;
	int max = 0;
	Node head;
	HashMap<Integer,Node> map=new HashMap<Integer, Node>();

	public Algorithm146(int capacity) {
		max = capacity;
	}



	public int get(int key) {
		if (head == null) {
			return -1;
		} else {
			Node temp = map.get(key);
			if (temp != null) {
				// find the node, move it to head
				if (temp != head) {
					// remove from current position
					temp.left.right = temp.right;
					temp.right.left = temp.left;
					// add to the head
					head.left.right = temp;
					temp.left = head.left;
					head.left = temp;
					temp.right = head;
					head = temp;
				}
				return temp.value;
			} else {
				return -1;
			}
		}
	}

	public void set(int key, int value) {
		if (head == null) {
			// the first one
			head = new Node(key, value);
			head.left = head;
			head.right = head;
			currentSize++;

		} else if (get(key) == -1) {
			// excess the capability
			if (max == currentSize) {
				map.remove(head.left.key);
				head.left.key = key;
				head.left.value = value;
				head = head.left;
			} else {
				// add a new node to the list
				currentSize++;
				Node node = new Node(key, value);
				node.left = head.left;
				node.right = head;
				head.left.right = node;
				head.left = node;
				head = node;
			}
		} else {
			// replace current value
			map.remove(head.key);
			head.value = value;
		}

		map.put(key, head);
	}

	public void test() {
		System.out.println("");
		Node temp = head;
		do {
			System.out.println(temp.key + ":" + temp.value);
			temp = temp.right;

		} while (temp != head);
		System.out.println("");
	}

	class Node {
		Node left;
		Node right;
		Node next;
		int key;
		int value;

		public Node(int k, int v) {
			key = k;
			value = v;
		}

	}
}
