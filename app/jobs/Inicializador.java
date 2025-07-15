package jobs;

import java.util.Date;

import models.Departamento;
import models.Pessoa;
import models.Status;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
	
	@Override
	public void doJob() throws Exception {
		if(Departamento.count() == 0) {
			Departamento rh = new Departamento("RH",101);
			Departamento ti = new Departamento("TI",102);
			Departamento seac = new Departamento("seac",103);
			rh.save();
			ti.save();
			seac.save();
			
			Pessoa joao = new Pessoa();
			joao.nome = "João da Silva";
			joao.email = "joaossilva@gmail.com";
			joao.dataNascimento = new Date();
			joao.departamento = ti;
			joao.status = Status.ATIVO;
			joao.save();
			
			Pessoa maria = new Pessoa();
			maria.nome = "Teixeirinha";
			maria.email = "teixeirinha@gmail.com";
			maria.dataNascimento = new Date();
			maria.departamento = seac;
			maria.status = Status.ATIVO;
			maria.save();
			
			
			
		}
	}
}


