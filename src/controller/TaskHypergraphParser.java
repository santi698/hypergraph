package controller;
import java.util.LinkedList;

import model.TaskHypergraph;
public class TaskHypergraphParser {
	/**
	 * Convierte una representacion textual de un hipergrafo en un nuevo hipergrafo.
	 * @param s Una representacion textual del hipergrafo a parsear.
	 * @return El hipergrafo correspondiente al texto ingresado
	 */
	public TaskHypergraph parse (String s) {
		String[] lines = s.split("\n");
		TaskHypergraph graph = new TaskHypergraph(lines[0], lines[1]);
		for (int i = 2; i < lines.length; i++) {
			if (!lines[i].startsWith("#")) {
				String[] words = lines[i].split(" ");
				LinkedList<String> requisites = new LinkedList<String>();
				LinkedList<String> consequences = new LinkedList<String>();
				for (int j = 0; j < Integer.parseInt(words[2]); j++) {
					requisites.add(words[3+j]);
				}
				for (int j = 0; j < Integer.parseInt(words[3+requisites.size()]); j++) {
					consequences.add(words[4+requisites.size()+j]);
				}
				graph.addHyperedge(words[0], Integer.parseInt(words[1]), requisites, consequences);
			}
		}
		return graph;
	}
	public static void main(String[] args) {
		TaskHypergraphParser parser = new TaskHypergraphParser();
		TaskHypergraph graph = parser.parse("A\nB\nX 10 2 A C 1 D\nY 8 3 A C D 1 B");
		System.out.println(graph.getDOTRep());
	}
}
