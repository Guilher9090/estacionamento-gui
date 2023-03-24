package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Estacionamento {
	@Id
	@GeneratedValue
	private Long id;
	private Date entrada;
	private Date saida;
	private Double valorPago;
	@ManyToOne
	@JoinColumn(name="id_veiculo")
	private Veiculo veiculo;
	@ManyToOne
	@JoinColumn(name="id_vaga")
	private Vaga vaga;
}
