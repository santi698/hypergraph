package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Hypergraph<V> implements HypergraphIFace<V>{

	private Map<V,Hypernode> nodes;
	private List<Hypernode> nodeList;
	
	public Hypergraph() {
		nodes = new HashMap<V, Hypernode>();
		nodeList = new LinkedList<Hypernode>();
	}
	@Override
	public void addHyperedge(int weight, List<V> prerequisites,
			List<V> consequences) {
		// TODO Auto-generated method stub
	}
	public void addNode (V data) {
		if (!nodes.containsKey(data)) {
			Hypernode node = new Hypernode(data);
			nodes.put(data, node);
			nodeList.add(node);
		}
	}
	
	protected List<Hypernode> getNodes() {
		return nodeList;
	}
	
	protected class Hyperedge {
		public List<Hypernode> prerequisites;
		public List<Hypernode> consequences;
		public int weight;
		public boolean visited;
		public Hyperedge (int weight) {
			this.weight = weight;
			this.prerequisites = new LinkedList<Hypernode>();
			this.consequences = new LinkedList<Hypernode>();
			this.visited = false;
		}
	}
	
	protected class Hypernode {
		public List<Hyperedge> edges;
		public V data;
		public Hypernode (V data) {
			this.data = data;
			this.edges = new LinkedList<Hyperedge>();
		}
	}

}