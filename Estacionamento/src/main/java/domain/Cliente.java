package domain;

import java.util.List;

import javax.persistence.Column;
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
public class Cliente {
	@Id
	@GeneratedValue
	private Long id;	
	private String nome;
	@Column(unique=true)
	private String cpf;
	private String telefone;
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Veiculo> veiculos;
}
