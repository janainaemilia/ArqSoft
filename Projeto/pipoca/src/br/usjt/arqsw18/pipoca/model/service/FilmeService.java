package br.usjt.arqsw18.pipoca.model.service;

import java.io.IOException;

import br.usjt.arqsw18.pipoca.model.dao.FilmeDAO;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;
import br.usjt.arqsw18.pipoca.model.entity.Filme;

public class FilmeService {
	private FilmeDAO dao;
	
	public FilmeService() {
		dao = new FilmeDAO();
	}
	
	public Filme buscarFilme(int id) throws IOException{
		return dao.buscarFilme(id);
	}
	
	public Filme inserirFilme(Filme filme) throws IOException {
		int id = dao.inserirFilme(filme);
		filme.setId(id);
		GeneroService generoService = new GeneroService();
		filme.setGenero(generoService.buscarGenero(filme.getGenero().getId()));
		return filme;
	}

}
