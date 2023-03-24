package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, unique=true)	
	private String login;
	@Column(nullable=false)
	private String senha;
	private String nome;
	private String telefone;
}
