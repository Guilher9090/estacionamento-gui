package controller;

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
import domain.Veiculo;

@RestController
@CrossOrigin(origins = "*")
@SuppressWarnings({ "unchecked", "rawtypes" })
class VeiculoController extends GenericController {
	private static final String URL = "/veiculo";
		
	public VeiculoController() {
		super(Veiculo.class);
	}
		
	@RequestMapping(URL)	
	BackendFrontend findAll() {
		return super.findAll();
	}	
			
	@GetMapping(URL+"/{id}")
	public BackendFrontend findById(@PathVariable Long id) {		
		return super.findById(id);
	}
			
	@PostMapping(URL)
	public BackendFrontend save(@RequestBody Veiculo entity) {
		return super.save(entity);		
	}
	
	@PutMapping(URL)
	public BackendFrontend update(@RequestBody Veiculo entity) {
		return super.update(entity);		
	}
	
	@DeleteMapping(URL+"/{id}")
	public BackendFrontend remove(@PathVariable Long id) {
		return super.remove(id);				
	}
	
}
