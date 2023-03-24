package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Veiculo {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String placa;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name="id_modelo")
	private Modelo modelo;
	@ManyToOne
	@JoinColumn(name="id_cor")
	private Cor cor;
	@OneToMany(mappedBy="veiculo", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Estacionamento> estacionadas;
}
