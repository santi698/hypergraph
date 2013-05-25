package view;

import java.io.IOException;
import java.util.List;

import model.TaskHypergraph;
import model.TaskHypergraph.Approach;

import controller.FileManager;
import controller.TaskHypergraphParser;

public class ShortestPathCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TaskHypergraphParser parser = new TaskHypergraphParser();
		String s, result;
		try {
			s = FileManager.getFileContents(args[0]);
			result = args[0].substring(0, args[0].length() - 3);
			TaskHypergraph graph = parser.parse(s);
			
			//TODO Crear una funcion que parsee la entrada y llame a la funcion con los argumentos correctos.
			List<String> path = graph.getShortestPath(Approach.EXACT);
			
			System.out.println("La longitud del camino más corto es: " + path.size()); //ESTO NO ESTA BIEN, DEBERIA SER EL PESO 
																					   //DE LA SUMA DEL CAMINO, NO LA CANTIDAD DE EJES
			
			TaskHypergraph subgraph = graph.getSubgraph(path);
			FileManager.createFileWithContent(result + ".dot", graph.getDOTRep());
			FileManager.createFileWithContent(result + ".min.hg", subgraph.getHgRep());
			FileManager.createFileWithContent(result + ".min.dot", graph.getDOTRep(path));
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
	}

}
