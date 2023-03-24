package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Modelo {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@OneToMany(mappedBy="modelo", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Veiculo> veiculos;
	
	public Modelo(String nome) {
		this.nome = nome;
	}
}
