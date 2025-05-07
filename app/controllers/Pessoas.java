package controllers;

import models.Pessoa;
import play.mvc.Controller;

public class Pessoas extends Controller {
	
	public static void detalhar(Pessoa p) {
		 render(p);
	}
	
	public static void salvar(Pessoa p) {
		
		
		if(p.nome != null) {
			p.nome = p.nome.toUpperCase();
		}
		if(p.email != null) {
			p.email = p.email.toLowerCase();
		}
		
		p.save();
		
		detalhar(p);
	}
	
	public static void form() {
		 render();
	}
}
