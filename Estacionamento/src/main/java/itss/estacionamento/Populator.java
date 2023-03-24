package itss.estacionamento;

import domain.Cliente;
import domain.Cor;
import domain.Modelo;
import domain.Patio;
import domain.Usuario;
import domain.Vaga;
import domain.Veiculo;
import repository.GenericDAO;

public class Populator {
	public static void main(String[] args) {
		
		Usuario u1 = new Usuario();
		u1.setLogin("teste");
		u1.setNome("Nome de Teste");
		u1.setSenha("teste");
		GenericDAO.save(u1);
		
		Cliente cl1 = new Cliente();
		cl1.setNome("Jair");
		cl1.setTelefone("123123");
		GenericDAO.save(cl1);		
		Cliente cl2 = new Cliente();
		cl2.setNome("Bruna");		
		GenericDAO.save(cl2);		
	
		GenericDAO.save(new Modelo("VW Up"));
		Modelo m1 = new Modelo("VW Gol");
		GenericDAO.save(m1);
		GenericDAO.save(new Modelo("VW Voyage"));
		Modelo m2 = new Modelo("VW Polo");
		GenericDAO.save(m2);
		GenericDAO.save(new Modelo("VW Golf"));
		GenericDAO.save(new Modelo("VW Jetta"));
		GenericDAO.save(new Modelo("Ford Ka"));
		GenericDAO.save(new Modelo("Ford Fiesta"));
		GenericDAO.save(new Modelo("Ford Focus"));
		GenericDAO.save(new Modelo("Ford Fusion"));
		GenericDAO.save(new Modelo("Chevrolet Celta"));
		GenericDAO.save(new Modelo("Chevrolet Onix"));
		GenericDAO.save(new Modelo("Chevrolet Prisma"));
		GenericDAO.save(new Modelo("Chevrolet Cobalt"));
		GenericDAO.save(new Modelo("Fiat Uno"));
		GenericDAO.save(new Modelo("Fiat Pálio"));
		GenericDAO.save(new Modelo("Fiat Siena"));
		GenericDAO.save(new Modelo("Fiat Argo"));
		Modelo m3 = new Modelo("Nissan March");
		GenericDAO.save(m3);
		GenericDAO.save(new Modelo("Nissan Versa"));
		GenericDAO.save(new Modelo("Nissan Sentra"));
		GenericDAO.save(new Modelo("Nissan Kicks"));
		GenericDAO.save(new Modelo("Honda Fit"));
		GenericDAO.save(new Modelo("Honda City"));
		GenericDAO.save(new Modelo("Honda Civic"));
		GenericDAO.save(new Modelo("Toyota Etios"));
		GenericDAO.save(new Modelo("Toyota Corolla"));
		
		Cor c1 = new Cor("Prata");
		GenericDAO.save(c1);		
		Cor c2 = new Cor("Branco");
		GenericDAO.save(c2);
		Cor c3 = new Cor("Cinza");
		GenericDAO.save(c3);
		GenericDAO.save(new Cor("Preto"));
		GenericDAO.save(new Cor("Vermelho"));
		GenericDAO.save(new Cor("Azul"));
		GenericDAO.save(new Cor("Amarelo"));
		GenericDAO.save(new Cor("Verde"));
		GenericDAO.save(new Cor("Laranja"));
		
		Patio p1 = new Patio("Pátio 1");
		p1.setTaxaHora(10d);
		GenericDAO.save(p1);
		Patio p2 = new Patio("Pátio 2");
		p2.setTaxaHora(20d);
		GenericDAO.save(p2);
		Patio p3 = new Patio("Pátio 3");
		p3.setTaxaHora(30d);
		GenericDAO.save(p3);
		
		GenericDAO.save(new Vaga(11, p1));
		GenericDAO.save(new Vaga(12, p1));
		GenericDAO.save(new Vaga(13, p1));		
		GenericDAO.save(new Vaga(14, p1));	
		GenericDAO.save(new Vaga(15, p1));
		GenericDAO.save(new Vaga(16, p1));
		GenericDAO.save(new Vaga(17, p1));		
		GenericDAO.save(new Vaga(18, p1));	
		GenericDAO.save(new Vaga(21, p2));
		GenericDAO.save(new Vaga(22, p2));
		GenericDAO.save(new Vaga(23, p2));		
		GenericDAO.save(new Vaga(24, p2));
		GenericDAO.save(new Vaga(25, p2));
		GenericDAO.save(new Vaga(31, p3));
		GenericDAO.save(new Vaga(32, p3));
		GenericDAO.save(new Vaga(33, p3));
		
		Veiculo v1 = new Veiculo();
		v1.setCliente(cl1);
		v1.setCor(c1);
		v1.setModelo(m1);
		v1.setPlaca("HQC1010");
		GenericDAO.save(v1);
		
		Veiculo v2 = new Veiculo();
		v2.setCliente(cl1);
		v2.setCor(c2);
		v2.setModelo(m2);
		v2.setPlaca("XQS2020");
		GenericDAO.save(v2);
		
		Veiculo v3 = new Veiculo();
		v3.setCliente(cl2);
		v3.setCor(c3);
		v3.setModelo(m3);
		v3.setPlaca("PRY3030");
		GenericDAO.save(v3);
	}
}
