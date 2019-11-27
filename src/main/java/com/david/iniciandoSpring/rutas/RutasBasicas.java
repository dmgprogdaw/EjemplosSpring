package com.david.iniciandoSpring.rutas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.david.iniciandoSpring.bean.Autor;
import com.david.iniciandoSpring.bean.ListaAutores;

@Controller
public class RutasBasicas {

	@GetMapping("/")
	public String rutaBasicaInicial(Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		model.addAttribute("autor", lista.getDatos());
		
		return "autor";
	}
	
	@GetMapping("/eliminarAutor/{id}")
	public String eliminarAutor( @PathVariable Integer id, 
								 Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		lista.deleteAutor(id);

		
		return ("redirect:/");
	}
	
	@GetMapping("/nuevoAutor")
	public String nuevoAutor(Model model) {
		
		model.addAttribute("autor", new Autor());
		//model.addAttribute("nombre", new String());
		
		return "nuevoAutor";
	}
	

	@PostMapping("/addAutor")
	public String addAutor(@ModelAttribute Autor autor) {
		
		ListaAutores lista = ListaAutores.getLista();
		lista.addAutor(autor);
		
		return "redirect:/";
	}
	
	@GetMapping("/actualizarAutor/{id}")
	public String actualizarAutor( @PathVariable Integer id,
								   Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		Autor autor = lista.getAutor(id);
		model.addAttribute("autor", autor);
		
		return "actualizarAutor";
	}
	
	@PostMapping("/updateAutor")
	public String updateAutor(@ModelAttribute Autor autor) {
		
		ListaAutores lista = ListaAutores.getLista();
		lista.updateAutor(autor);
		
		return "redirect:/";
	}
	
	@GetMapping("/autores/{id}")
	public String verAutor( @PathVariable Integer id, 
							Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		Autor autor = lista.getAutor(id);
		model.addAttribute("autor", autor);
		
		return "hola";
	}
}
