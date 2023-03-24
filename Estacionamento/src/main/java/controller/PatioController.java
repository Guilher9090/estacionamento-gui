package controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.BackendFrontend;
import domain.Estacionamento;
import domain.Patio;
import domain.Vaga;
import domain.VagaStatus;
import repository.EntityManagerHelper;

@RestController
@CrossOrigin(origins = "*")
@SuppressWarnings({ "unchecked", "rawtypes" })
class PatioController extends GenericController {
	private static final String URL = "/patio";

	public PatioController() {
		super(Patio.class);
	}

	private VagaStatus getStatusVaga(Vaga vaga)  {
		if(vaga.getStatus() == VagaStatus.INDISPONIVEL) {
			return VagaStatus.INDISPONIVEL;
		}
		if(vaga.getUltimaEstacionada()!=null) {
			if (vaga.getUltimaEstacionada().getEntrada() == null && vaga.getUltimaEstacionada().getSaida() == null) {
				return VagaStatus.DISPONIVEL;
			}
			else if (vaga.getUltimaEstacionada().getEntrada() != null && vaga.getUltimaEstacionada().getSaida() == null) {
				return VagaStatus.OCUPADA;
			}
		}
		return VagaStatus.DISPONIVEL;
	}

	@RequestMapping(URL)	
	BackendFrontend findAll() {
		BackendFrontend bf = super.findAll();
		List<Patio> patios = (List<Patio>)(Object)bf.getList();
		for (Patio patio : patios) {
			for (Vaga vaga : patio.getVagas()) {
				vaga.setPatio(null);
				List<Estacionamento> estacionadas = getEstacionadasByVaga(vaga.getId());
				if(estacionadas!=null && estacionadas.size()>0) {					
					Estacionamento estacionada = estacionadas.get(0);
					estacionada.setVeiculo(estacionada.getVeiculo());					
					vaga.setUltimaEstacionada(estacionada);				
					
				}
				vaga.setStatus(getStatusVaga(vaga));				
			}

			Collections.sort(patio.getVagas(), new Comparator<Vaga>() {
				@Override
				public int compare(Vaga v1, Vaga v2) {
					return  v1.getNumero().compareTo(v2.getNumero());
				}
			});

			patio.setVagasTransient(patio.getVagas());			
		}
		return bf;
	}	

	public static List<Estacionamento> getEstacionadasByVaga(Long idVaga) {	
		EntityManagerHelper.getEntityManager().clear();
		List<Estacionamento> estacionadas = null;		
		String hql = "select distinct e from Estacionamento as e where e.vaga.id = :idVaga order by e.saida desc";		
		Session session = EntityManagerHelper.getEntityManager().unwrap(Session.class);			
		estacionadas = session.createQuery(hql).setParameter("idVaga", idVaga).list();		
		return estacionadas;
	}

	@GetMapping(URL+"/{id}")
	public BackendFrontend findById(@PathVariable Long id) {		
		return super.findById(id);
	}

	@PostMapping(URL)
	public BackendFrontend save(@RequestBody Patio entity) {
		return super.save(entity);		
	}

	@PutMapping(URL)
	public BackendFrontend update(@RequestBody Patio entity) {
		return super.update(entity);		
	}

	@DeleteMapping(URL+"/{id}")
	public BackendFrontend remove(@PathVariable Long id) {
		return super.remove(id);				
	}

}
