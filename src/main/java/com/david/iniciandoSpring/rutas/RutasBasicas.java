package com.david.iniciandoSpring.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.david.iniciandoSpring.bean.Autor;
import com.david.iniciandoSpring.bean.Coche;
import com.david.iniciandoSpring.bean.ListaAutores;
import com.david.iniciandoSpring.bean.ListaCoches;

@Controller
public class RutasBasicas {

	@GetMapping("/")
	public ModelAndView rutaBasicaInicial() {
		
		//ArrayList<Coche> listaCoches = listaCoches();
		
		ModelAndView model = new ModelAndView("raiz");
		/*ListaAutores lista = ListaAutores.getLista();
		model.addObject("coches", listaCoches);
		model.addObject("autor", lista.getDatos());*/
		
		return model;
	}
	
	@GetMapping("/autores")
	public ModelAndView irAutor() {
		
		ListaCoches listaCoches = ListaCoches.getLista();
		
		ModelAndView model = new ModelAndView("autor");
		ListaAutores lista = ListaAutores.getLista();
		model.addObject("coches", listaCoches.getDatos());
		model.addObject("autor", lista.getDatos());
		
		return model;
	}
	
	@GetMapping("/coches")
	public ModelAndView irCoche() {
		
		ListaCoches listaCoches = ListaCoches.getLista();
		
		ModelAndView model = new ModelAndView("coche");
		model.addObject("coches", listaCoches.getDatos());
		model.addObject("coches", new Coche());
		
		return model;
	}
	
	@DeleteMapping("/eliminarAutor/{id}")
	public String eliminar( @PathVariable Integer id,
						    Model model) {
		
		ListaAutores lista = ListaAutores.getLista();
		lista.deleteAutor(id);
		
		return "200";
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
		
		ListaCoches listaCoches = ListaCoches.getLista();
		
		model.addAttribute("coches", listaCoches.getDatos());
		model.addAttribute("autor", new Autor());
		
		return "nuevoAutor";
	}

	
	@PostMapping("/addCoche")
	public String addCoche(@ModelAttribute Coche coche) {
		
		ListaCoches listaCoches = ListaCoches.getLista();
		listaCoches.addCoche(coche);
		
		return "redirect:/coches";
	}
	

	@PostMapping("/addAutor")
	public String addAutor(@ModelAttribute Autor autor) {
		
		ListaAutores lista = ListaAutores.getLista();
		lista.addAutor(autor);
		
		return "redirect:/autores";
	}
	
	@GetMapping("/actualizarAutor/{id}")
	public String actualizarAutor( @PathVariable Integer id,
								   Model model) {
		
		ListaCoches listaCoches = ListaCoches.getLista();
		model.addAttribute("coches", listaCoches);
		
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
		
		return "detalleAutor";
	}
}
