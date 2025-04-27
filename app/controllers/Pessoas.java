package controllers;

import models.Pessoa;
import play.mvc.Controller;

public class Pessoas extends Controller {
	
	public static void detalhar(Pessoa p) {
		 render();
	}
	
	public static void salvar(Pessoa p) {
		render(p);
	}
}
