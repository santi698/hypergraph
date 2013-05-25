package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Hypergraph<V> implements HypergraphIFace<V> {

	private Map<V, Node> nodes;
	private List<Node> nodeList;
	private List<Hyperedge> edgeList;
	
	public Hypergraph() {
		nodes = new HashMap<V, Node>();
		nodeList = new LinkedList<Node>();
		edgeList = new LinkedList<Hyperedge>();
	}

	@Override
	public void addHyperedge(String name, int weight, List<V> requisites, List<V> consequences) {
		Hyperedge edge = new Hyperedge(name, weight);
		edgeList.add(edge);
		
		for(V data : requisites) {
			Node node = addNode(data);
			node.edges.add(edge);
			edge.requisites.add(node);
		}
		
		for(V data : consequences) {
			Node node = addNode(data);
			edge.consequences.add(node);
		}
	}

	protected Node addNode(V data) {
		Node node = nodes.get(data);
		if (node == null) {
			node = new Node(data);
			nodes.put(data, node);
			nodeList.add(node);
		}
		return node;
	}
	
	public void clearMarks() {
		for(Node node : nodeList) {
			node.visited = false;
		}

		for(Hyperedge edge : edgeList) {
			edge.visited = false;
		}
	}

	protected List<Node> getNodes() {
		return nodeList;
	}
	
	protected List<Hyperedge> getEdges() {
		return edgeList;
	}

	protected class Hyperedge {
		public String name;
		public int weight;
		public List<Node> requisites;
		public List<Node> consequences;
		public boolean visited;

		public Hyperedge(String name, int weight) {
			this.name = name;
			this.weight = weight;
			this.requisites = new LinkedList<Node>();
			this.consequences = new LinkedList<Node>();
			this.visited = false;
		}
		
		public boolean isDone() {
				for (Node n : requisites) {
					if (!n.visited)
						return false;
				}
			return true;
		}
	}

	protected class Node {
		public V data;
		public List<Hyperedge> edges;
		public boolean visited;

		public Node(V data) {
			this.data = data;
			this.edges = new LinkedList<Hyperedge>();
			this.visited = false;
		}
	}

}