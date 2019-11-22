package com.david.iniciandoSpring.rutas;

import java.util.ArrayList;
import java.util.List;

public class ListaAutores {
	
	private static ArrayList<Autor> lista = new ArrayList<Autor>();
	
	/**
	 * Devuelve un autor en concreto
	 * @param id
	 * @return
	 */
	public static Autor getAutor(int id) {
		
		return lista.get(id);
	}
	

	public static List<Autor> construirLista(){
		
		Autor autor1 = new Autor();
		autor1.setId(0);
		autor1.setNombre("Kubo Tite");
		autor1.setEdad(40);
		autor1.setEmail("kuboTite@gmail.com");
		lista.add(autor1);
		
		Autor autor2 = new Autor();
		autor2.setId(1);
		autor2.setNombre("Mashima Hiro");
		autor2.setEdad(40);
		autor2.setEmail("mashimaHiro@gmail.com");
		lista.add(autor2);
		
		Autor autor3 = new Autor();
		autor3.setId(2);
		autor3.setNombre("Toriyama Akira");
		autor3.setEdad(40);
		autor3.setEmail("toriyamaAkira@gmail.com");
		lista.add(autor3);
		
		Autor autor4 = new Autor();
		autor4.setId(3);
		autor4.setNombre("Oda");
		autor4.setEdad(40);
		autor4.setEmail("oda@gmail.com");
		lista.add(autor4);
		
		
		return lista;
	}
}
