package controllers;

import java.util.List;

import models.Pessoa;
import play.db.jpa.JPABase;
import play.mvc.Controller;

public class Pessoas extends Controller {

	public static void detalhar(Pessoa p) {
		render(p);
	}

	public static void lista(Boolean a) {
		String busca = params.get("busca");
	
		List<Pessoa> lista;
		
		if(busca == null) {
			lista = Pessoa.findAll();
		}else {
			lista = Pessoa.find("select p from Pessoa p where p.nome like ?1 or p.email like ?1", "%"+busca+"%").fetch();
		}
		
		render(lista);

	}

	public static void salvar(Pessoa p) {
		if(!p.nome.isEmpty() ) {
			p.nome = p.nome.toUpperCase();
		}
		if(!p.email.isEmpty()) {
			p.email = p.email.toLowerCase();
		}
		
		String msg = "";
		boolean confirma = false;
		try {
			p.save();
			 confirma = true;
			 
		}catch(Exception e ) {
			confirma = false;
		}finally {
			lista(confirma);
		}
		
		

		
	}

	public static void form() {
		render();
	}

	public static void excluir(long id) {
		Pessoa p = Pessoa.findById(id);
		
		Boolean a = true;
		
		try {
			p.delete();
			a = true;
		}catch(Exception e ) {
			a = false;
		}finally {
			lista(a);
		}
	
	}

	public static void editar(long id) {
		Pessoa p = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", p);
	}

}
