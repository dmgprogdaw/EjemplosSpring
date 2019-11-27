package com.david.iniciandoSpring.bean;

import java.util.ArrayList;
import java.util.List;

public class ListaAutores {
	
	private ArrayList<Autor> lista = null;
	private static ListaAutores listaAutores = null;
	

	private ListaAutores(){
		
		lista = new ArrayList<Autor>();
		

	}
	
	public List<Autor> getDatos(){
		
		return lista;
	}
	
	/**
	 * 
	 * @param idBuscado
	 * @return
	 */
	public Autor getAutor(int idBuscado) {
		
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
	public void deleteAutor(int idBuscado) {
		
		int dondeEsta = buscarDondeEsta(idBuscado);
		if(dondeEsta>=0) {
			
			lista.remove(dondeEsta);
		}
	}
	
	/**
	 * Añade un autor a la lista
	 * @param autor
	 */
	public void addAutor(Autor autor) {
		
		autor.setId(getIdNoRepetido());
		lista.add(autor);
	}
	
	/**
	 * Actualiza un autor buscando primero su posicion en la lista
	 * @param autor
	 */
	public void updateAutor (Autor autor) {
		
		int posicion = buscarDondeEsta(autor.getId());
		lista.set(posicion, autor);
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

	private int getIdNoRepetido() {
		
		int numeroAleatorio = (int)(Math.random()*100)+1;
		
		// le paso un ID y si me devuelve -1 es que ese ID no esta en la lista
		while(buscarDondeEsta(numeroAleatorio) != -1) {
			
			numeroAleatorio = (int)(Math.random()*100)+1;
		}

		return numeroAleatorio;
	}
	
	public static ListaAutores getLista(){
		
		if(listaAutores == null) {
			
			listaAutores = new ListaAutores();
		}
		return listaAutores;
	}
}
