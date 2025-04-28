package controllers;

import models.Pessoa;
import play.mvc.Controller;

public class Pessoas extends Controller {
	
	public static void detalhar(Pessoa p) {
		 render(p);
	}
	
	public static void salvar(Pessoa p) {
		
		p.nome = p.nome.toUpperCase();
		p.email = p.email.toLowerCase();
		
		
		detalhar(p);
	}
}
