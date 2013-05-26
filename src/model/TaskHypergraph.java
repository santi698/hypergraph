package model;

import java.util.LinkedList;
import java.util.List;

public class TaskHypergraph extends Hypergraph<String> {

	private Node start;
	private Node end;
	
	/**
	 * Definir ac� todos los posibles m�todos de conseguir el camino mas corto.
	 * El m�todo {@code getShortestPath} recibe un Approach para decidir que
	 * m�todo utilizar.
	 * 
	 * @author santi698
	 * 
	 */
	public static enum Approach {
		EXACT, APPROX_HILLCLIMBING // etc
	}
	
	public TaskHypergraph(String start, String end) {
		this.start = addNode(start);
		this.end = addNode(end);
	}

	/**
	 * 
	 * @return Una lista representando el camino m�s corto entre {@code start} y
	 *         {@code end} en este {@link TaskHypergraph}
	 */
	public List<String> getShortestPath(Approach approach) {
		// TODO
		switch (approach) {
		case EXACT:
			return getShortestPathExact();
			// TODO Agregar al menos un caso APPROX_*
		default:
			return null;
		}
	}

	private List<String> getShortestPathExact() {
		int min = Integer.MAX_VALUE;
		for (Hyperedge e : start.edges) {
			min = Math.min(min, getShortestPathExact(e, end));
		}
		boolean reachedEnd = false;
		List<String> path = new LinkedList<String>();
		//Hyperedge actual;
		while (!reachedEnd) {

		}
		return path;
	}

	private int getShortestPathExact(Hyperedge start, Node end) {
		//TODO
		return 0;
	}
	
	/**
	 * Crea un subgrafo del actual a partir de una lista de {@link Hyperedge}s
	 * @param list la lista de aristas que contiene el subgrafo.
	 * @return un nuevo hipergrafo que es subgrafo de este.
	 */
	public TaskHypergraph getSubgraph(List<String> list) {
		TaskHypergraph subgraph = new TaskHypergraph(start.data, end.data);
		
		return subgraph;
	}
	
	/**
	 * Crea una representacion en formato DOT del grafo actual.
	 * @return un string en formato DOT
	 */
	public String getDOTRep() {
		clearMarks();
		StringBuffer sb = new StringBuffer();
		
		sb.append("digraph HyperGraph {" + '\n');
		
		for(Node node : getNodes())
			getDOTRep(node, sb);

		for(Hyperedge edge : getEdges() )
			for(Node node : edge.consequences)
				sb.append(edge.name + edge.weight + " -> " + node.data + ";");
			
		sb.append("}");
		return sb.toString();
	}
	
	private void getDOTRep(Node node, StringBuffer sb) {
		sb.append(node.data + ";");
		
		for(Hyperedge edge : node.edges) {
			if(!edge.visited) {
				sb.append(edge.name + edge.weight + " [shape=box, label=\"" + edge.name + " (" + edge.weight +")\"];");
				edge.visited = true;
			}
			sb.append(node.data + " -> " + edge.name + edge.weight + ";");
		}
	}
	
	/**
	 * Crea una representacion en formato Hg del grafo actual.
	 * @return un string en formato Hg
	 */

	public String getHgRep() {
		StringBuffer sb = new StringBuffer();
		sb.append(start.data + '\n');
		sb.append(end.data + '\n');

		for(Hyperedge edge : getEdges()) {
			sb.append(edge.name).append(" ").append(edge.weight).append(" ");
			appendListHgRep(edge.requisites, sb);
			appendListHgRep(edge.consequences, sb);
			sb.deleteCharAt(sb.length()-1);
			sb.append('\n');
		}
		
		return sb.toString();
	}
	
	private void appendListHgRep(List<Node> list, StringBuffer sb) {
		sb.append(list.size()).append(" ");
		for(Node node : list)
			sb.append(node.data).append(" ");
	}
	
	public String getDOTRepHighlighted(List<String> path) {
		// TODO Auto-generated method stub
		return null;
	}

}