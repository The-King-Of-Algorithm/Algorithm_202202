package edu.ssafy.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	public int data; // data 필드
	public Node link;// link 필드

	public Node(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}

public class Solution_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Node head = null;
			Node tail = null;
			for (int i = 0; i < N; i++) {
				int data = Integer.parseInt(st.nextToken());
				if (head == null) {
					head = new Node(data);
					tail = head;
				} else {
					Node create = new Node(data);
					tail.link = create;
					tail = create;
				}
			}
			int C = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine(), "I ");

			for (int i = 0; i < C; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = 1;
				Node current = null;
				Node next = null;

				if (x == 0) {
					int data = Integer.parseInt(st.nextToken());
					Node create = new Node(data);
					next = head;
					head = create;
					current = create;
					y -= 1;
				} else {
					current = head;
					next = head.link;
					while (cnt < x) {
						current = current.link;
						next = current.link;
						cnt++;
					}
				}

				for (int j = 0; j < y; j++) {
					int data = Integer.parseInt(st.nextToken());
					Node create = new Node(data);
					current.link = create;
					current = create;
				}
				current.link = next;
			}

			System.out.print("#" + test_case + " ");
			int i = 0;
			Node currNode = head;
			while (i < 10) {
				System.out.print(currNode.data + " ");
				currNode = currNode.link;
				i++;
			}
			System.out.println();
		}
	}
}
