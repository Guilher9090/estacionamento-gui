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
import domain.Usuario;
import repository.GenericDAO;

@RestController
@CrossOrigin(origins = "*")
@SuppressWarnings({ "unchecked", "rawtypes" })
class UsuarioController extends GenericController {
	private static final String URL = "/usuario";
		
	public UsuarioController() {
		super(Usuario.class);
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
	public BackendFrontend save(@RequestBody Usuario entity) {
		return super.save(entity);		
	}
	
	@PutMapping(URL)
	public BackendFrontend update(@RequestBody Usuario entity) {
		return super.update(entity);		
	}
	
	@DeleteMapping(URL+"/{id}")
	public BackendFrontend remove(@PathVariable Long id) {
		return super.remove(id);				
	}
	
	@GetMapping(URL+"/login/{login}/{senha}")
	public BackendFrontend login(@PathVariable String login, @PathVariable String senha) {
		BackendFrontend bf = new BackendFrontend();
		Usuario usuarioBD = null;
		try {
			usuarioBD = GenericDAO.findByField(Usuario.class, "login", login);
			if(usuarioBD!=null && usuarioBD.getSenha().equals(senha)) {
				bf.setSuccess(true);
				bf.setMessage("Seja bem vindo!");
				bf.setObject(usuarioBD);
				bf.setList(null);
				return bf;			
			}
			else {
				bf.setSuccess(false);
				bf.setMessage("Login ou senha incorretos!");
				bf.setObject(null);
				bf.setList(null);
				return bf;
			}
		}		
		catch (Exception e) {
			return super.sendErrorMessage("Login ou senha incorretos!");	
		}		
	}
	
	@GetMapping(URL+"/logout/{login}") 
	public BackendFrontend logout(@PathVariable String login) {
		// Se necessário pode-se salvar a data de logout por exemplo
		BackendFrontend bf = new BackendFrontend();
		bf.setSuccess(true);
		bf.setMessage("Até logo!");
		bf.setObject(null);
		bf.setList(null);
		return bf;
	}
	
}
