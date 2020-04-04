//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

import java.io.*;
import java.util.*;

public class DFS {
	private int V;
	
	private LinkedList<Integer>[] adj;
	
	private boolean[] visited;
	
	DFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}	
		
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);		
	}
	
	
	void traverse(int s, boolean[] visited) {		
		visited[s] = true;	
		System.out.print((s + " "));
		
		for (Integer i : adj[s]) {
			if (visited[i] == false) {
				visited[i] = true;
				traverse(i, visited);
			}
		}
	}
	
	void start(int s) {
		boolean[] visited = new boolean[V];
		traverse(s, visited);
	}
	
	public static void main(String args[]) {
		
		DFS dfs = new DFS(4);
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 3);
		
		dfs.start(2);
	}
}
