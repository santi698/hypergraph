package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Hypergraph<V> implements HypergraphIFace<V> {

	private Map<V, Node> nodes;
	private List<Node> nodeList;

	public Hypergraph() {
		nodes = new HashMap<V, Node>();
		nodeList = new LinkedList<Node>();
	}

	@Override
	public void addHyperedge(int weight, List<V> requisites,
			List<V> consequences) {
		// TODO Auto-generated method stub
	}

	public void addNode(V data) {
		if (!nodes.containsKey(data)) {
			Node node = new Node(data);
			nodes.put(data, node);
			nodeList.add(node);
		}
	}

	protected List<Node> getNodes() {
		return nodeList;
	}

	protected class Hyperedge {
		public List<Node> requisites;
		public List<Node> consequences;
		public int weight;
		public boolean visited;

		public Hyperedge(int weight) {
			this.weight = weight;
			this.requisites = new LinkedList<Node>();
			this.consequences = new LinkedList<Node>();
			this.visited = false;
		}
	}

	protected class Node {
		public List<Hyperedge> edges;
		public V data;

		public Node(V data) {
			this.data = data;
			this.edges = new LinkedList<Hyperedge>();
		}
	}

}