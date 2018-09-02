package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;

@Controller
public class ManterFilmesController {
	private FilmeService filmeService;
	private GeneroService generoService;
	
	public ManterFilmesController(){
		filmeService = new FilmeService();
		generoService = new GeneroService();
	}
	
	@RequestMapping("/novo")
	public String novoFilme(Model model){		
		try {
			ArrayList<Genero> generos = generoService.listarGeneros();
			model.addAttribute("generos", generos);
			return "NovoFilme";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}			
	}
	
	@RequestMapping("/inserir")
	public String inserirFilme(Filme filme, Model model) {
		try {
			filme = filmeService.inserirFilme(filme);
			model.addAttribute("filme", filme);
			System.out.println(filme.toString());
			return "Resultado";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}		
	}
}
