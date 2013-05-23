package model;

import java.util.List;

public interface HypergraphIFace<V> {
	/**
	 * Agrega una hiperarista. Si algun nodo no existe lo crea, si ya existe usa el existente.
	 * 
	 * @param weight el peso de la nueva hiperarista
	 * @param requisites una lista de los requisitos de la hiperarista.
	 * @param consequences una lista de las consecuencias de la hiperarista.
	 */
	public void addHyperedge (int weight, List<V> requisites, List<V> consequences);
	public void addNode (V data);
}