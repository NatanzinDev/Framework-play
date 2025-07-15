package controllers;

import java.util.List;

import models.Departamento;
import models.Pessoa;
import models.Status;
import play.db.jpa.JPABase;
import play.mvc.Controller;

public class Pessoas extends Controller {

	public static void detalhar(Pessoa p) {
		render(p);
	}

	public static void lista(String busca) {
		

		List<Pessoa> lista;

		if (busca == null) {
			lista = Pessoa.find("status <> ?1", Status.INATIVO).fetch();
		} else {
			lista =  Pessoa.find("(lower(nome) like ?1 "
					+ "or lower(email) like ?1) and status <> ?2",
					"%" + busca.toLowerCase() + "%",
					Status.INATIVO).fetch();
		}

		render(lista);

	}

	public static void salvar(Pessoa p) {
		if (!p.nome.isEmpty()) {
			p.nome = p.nome.toUpperCase();
		}
		if (!p.email.isEmpty()) {
			p.email = p.email.toLowerCase();
		}

		p.status = Status.ATIVO;

		p.save();

		detalhar(p);

	}

	public static void form() {
		List<Departamento> dps =  Departamento.findAll();
		render(dps);
	}

	public static void excluir(long id) {
		Pessoa pessoa = Pessoa.findById(id);
		pessoa.status = Status.INATIVO;
		pessoa.save();
		lista(null);

	}

	public static void editar(long id) {
		List<Departamento> dps =  Departamento.findAll();
		Pessoa p = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", p, dps);
	}

}
