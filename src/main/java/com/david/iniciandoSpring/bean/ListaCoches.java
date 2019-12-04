package com.david.iniciandoSpring.bean;

import java.util.ArrayList;
import java.util.List;

public class ListaCoches {

	private ArrayList<Coche> lista = null;
	private static ListaCoches listaCoches = null;
	

	private ListaCoches(){
		
		lista = new ArrayList<Coche>();
		

	}
	
	public List<Coche> getDatos(){
		
		return lista;
	}
	
	/**
	 * 
	 * @param idBuscado
	 * @return
	 */
	public Coche getAutor(int idBuscado) {
		
		int dondeEsta = buscarDondeEsta(idBuscado);
		if(dondeEsta >= 0) {
			
			return lista.get(dondeEsta);
		}
		else return null;
	}
	
	/**
	 * Borrar objeto
	 * @param idBuscado
	 */
	public void deleteCoche(int idBuscado) {
		
		int dondeEsta = buscarDondeEsta(idBuscado);
		if(dondeEsta>=0) {
			
			lista.remove(dondeEsta);
		}
	}
	
	/**
	 * Añade un autor a la lista
	 * @param autor
	 */
	public void addCoche(Coche coche) {
		
		lista.add(coche);
	}
	
	/**
	 * Actualiza un autor buscando primero su posicion en la lista
	 * @param autor
	 */
	public void updateCoche (Coche coche) {
		
		int posicion = buscarDondeEsta(coche.getId());
		lista.set(posicion, coche);
	}
	
	
	/**
	 * 
	 * @param idBuscado
	 * @return
	 */
	private int buscarDondeEsta(int idBuscado) {
		
		// iniciamos con una bandera indicando que no esta encontrado
		boolean encontrado = false;
		int indice = 0;
		
		// mientras que no se encuentra y no llego al final
		while((!encontrado)&&(indice < lista.size())) {
			
			// lo voy buscando
			if(lista.get(indice).getId()==idBuscado) {
				
				encontrado = true;
			}
			
			// y si no aparece avanzo
			else indice ++;
		}
		if(encontrado) return indice; else return -1;
	}
	
	public static ListaCoches getLista(){
		
		if(listaCoches == null) {
			
			listaCoches = new ListaCoches();
		}
		return listaCoches;
	}

}
