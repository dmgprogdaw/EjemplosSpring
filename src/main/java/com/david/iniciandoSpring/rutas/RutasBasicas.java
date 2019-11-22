package com.david.iniciandoSpring.rutas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RutasBasicas {

	@GetMapping("/inicio")
	public String rutaBasicaInicial(Model model) {
		
		List<Autor> listaAutores = ListaAutores.construirLista();
		model.addAttribute("autor", listaAutores);
		
		return "autor";
	}
	
	@GetMapping("/autores/{id}")
	public String verAutor( @PathVariable Integer id, 
							Model model) {
		
		Autor autor = ListaAutores.getAutor(id);
		model.addAttribute("autor", autor);
		
		return "autor";
	}
	
	@GetMapping("/comienzo")
	public String rutaCero(@RequestParam(required=false) Integer id, 
						   @RequestParam(required=false) String nombre) {
		
		System.out.println("El id: " + id);
		System.out.println("El nombre: " + nombre);
		
		return "hola";
	}
	
	@GetMapping("/ichi")
	public String rutaUno() {
		
		System.out.println("Eres un pringado x 1");
		
		return "200";
	}
	
	@GetMapping("/ichi/ni")
	public String rutaDos() {
		
		System.out.println("Eres un pringado x 2");
		
		return "200";
	}
	
	@GetMapping("/ichi/ni/san")
	public String rutaTres() {
		
		System.out.println("Eres un pringado x 3");
		
		return "200";
	}
	
	@GetMapping("/ichi/ni/san/shi")
	public String rutaCuatro() {
		
		System.out.println("Eres un pringado x 4");
		
		return "200";
	}
	
	@GetMapping("/ichi/ni/san/shi/go")
	public String rutaCinco() {
		
		System.out.println("Eres un pringado x 5");
		
		return "200";
	}
}
