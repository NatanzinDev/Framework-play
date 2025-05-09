package controllers;

import java.util.List;

import models.Pessoa;
import play.db.jpa.JPABase;
import play.mvc.Controller;

public class Pessoas extends Controller {

	public static void detalhar(Pessoa p) {
		render(p);
	}

	public static void lista() {
		List<Pessoa> lista = Pessoa.findAll();
		render(lista);

	}

	public static void salvar(Pessoa p) {
		if(!p.nome.isEmpty() ) {
			p.nome = p.nome.toUpperCase();
		}
		if(!p.email.isEmpty()) {
			p.email = p.email.toLowerCase();
		}
		
	 
		p.save();
		

		lista();
	}

	public static void form() {
		render();
	}

	public static void excluir(long id) {
		Pessoa p = Pessoa.findById(id);
		p.delete();
		lista();
	}

	public static void editar(long id) {
		Pessoa p = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", p);
	}

}
