package com.david.iniciandoSpring.rutas;

import java.util.ArrayList;
import java.util.List;

public class ListaAutores {
	
	private static ArrayList<Autor> lista = null;
	

	public ListaAutores(){
		
		lista = new ArrayList<Autor>();
		
		Autor autor1 = new Autor();
		autor1.setId(getIdNoRepetido());
		autor1.setNombre("Kubo Tite");
		autor1.setEdad(40);
		autor1.setEmail("kuboTite@gmail.com");
		lista.add(autor1);
		
		Autor autor2 = new Autor();
		autor2.setId(getIdNoRepetido());
		autor2.setNombre("Mashima Hiro");
		autor2.setEdad(40);
		autor2.setEmail("mashimaHiro@gmail.com");
		lista.add(autor2);
		
		Autor autor3 = new Autor();
		autor3.setId(getIdNoRepetido());
		autor3.setNombre("Toriyama Akira");
		autor3.setEdad(40);
		autor3.setEmail("toriyamaAkira@gmail.com");
		lista.add(autor3);
		
		Autor autor4 = new Autor();
		autor4.setId(getIdNoRepetido());
		autor4.setNombre("Oda Eiichirou");
		autor4.setEdad(40);
		autor4.setEmail("odaEiichirou@gmail.com");
		lista.add(autor4);
	}
	
	public static List<Autor> getLista(){
		
		if(lista == null) {
			
			new ListaAutores();
		}
		return lista;
	}
	
	/**
	 * 
	 * @param idBuscado
	 * @return
	 */
	public static Autor getAutor(int idBuscado) {
		
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
	public static void del(int idBuscado) {
		
		int dondeEsta = buscarDondeEsta(idBuscado);
		if(dondeEsta>=0) {
			
			lista.remove(dondeEsta);
		}
	}
	
	/**
	 * 
	 * @param idBuscado
	 * @return
	 */
	private static int buscarDondeEsta(int idBuscado) {
		
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
}
