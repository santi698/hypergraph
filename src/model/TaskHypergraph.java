package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TaskHypergraph extends Hypergraph<String> {
	private Hypernode start;
	private Hypernode end;
	public TaskHypergraph (String start, String end) {
		List<Hypernode> nodes = getNodes();
		
		this.start = new Hypernode(start);
		nodes.add(this.start);
		
		this.end = new Hypernode(end);
		nodes.add(this.end);
	}
	/**
	 * 
	 * @return Una lista representando el camino más corto entre {@code start} y {@code end} en este {@link TaskHypergraph}
	 */
	public List<String> getShortestPath (Approach approach) {
		//TODO
		switch (approach) {
			case EXACT:
				return getShortestPathExact();
			//TODO Agregar al menos un caso APPROX_*
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
		Hyperedge actual;
		while (!reachedEnd) {
			
		}
		return path;
	}
	
	private int getShortestPathExact(Hyperedge e, Hypernode end) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Definir acá todos los posibles métodos de conseguir el camino mas corto. El método {@code getShortestPath}
	 * recibe un Approach para decidir que método utilizar. 
	 * @author santi698
	 *
	 */
	public static enum Approach {
		EXACT, APPROX_HILLCLIMBING //etc
	}

}