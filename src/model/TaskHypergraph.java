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
		List<Node> nodes = getNodes();

		this.start = new Node(start);
		nodes.add(this.start);

		this.end = new Node(end);
		nodes.add(this.end);
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
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Crea una representacion en formato DOT del grafo actual.
	 * @return un string en formato DOT
	 */
	public String getDOTRep() {
		//TODO
		return null;
	}

	public String getHgRep() {
		// TODO Auto-generated method stub
		return null;
	}

}