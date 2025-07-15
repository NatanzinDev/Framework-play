package jobs;

import java.util.Date;

import models.Departamento;
import models.Pessoa;
import play.jobs.Job;

public class Inicializador extends Job{
	
	@Override
	public void doJob() throws Exception {
		if(Departamento.count() == 0) {
			Departamento rh = new Departamento("RH",101);
			Departamento ti = new Departamento("TI",102);
			Departamento seac = new Departamento("seac",103);
			
			Pessoa joao = new Pessoa(null, null, seac, null);
			joao.nome = "João da Silva";
			joao.email = "joaossilva@gmail.com";
			joao.dataNascimento = new Date();
			joao.departamento = ti;
			joao.save();
			
			Pessoa maria = new Pessoa();
			maria.nome = "Teixeirinha";
			maria.email = "teixeirinha@gmail.com";
			maria.dataNascimento = new Date();
			maria.departamento = seac;
			maria.save();
			
			
			
		}
	}
}


