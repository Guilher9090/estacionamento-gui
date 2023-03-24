package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vaga {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private Integer numero;	
	@ManyToOne
	@JoinColumn(name="id_patio")
	private Patio patio;
	@Enumerated(EnumType.ORDINAL)
	private VagaStatus status;
	@Transient
	private Estacionamento ultimaEstacionada;
	
	public Vaga(Integer numero, Patio patio) {
		this.numero = numero;
		this.patio = patio;
	}
	
	
}
