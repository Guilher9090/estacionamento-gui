package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Patio {
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private Double taxaHora;
	@OneToMany(mappedBy="patio", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	@Fetch(FetchMode.SUBSELECT)
	private List<Vaga> vagas;
	@Transient
	private List<Vaga> vagasTransient;	
	
	public Patio(String descricao) {
		this.descricao = descricao;
	}	
	
}
