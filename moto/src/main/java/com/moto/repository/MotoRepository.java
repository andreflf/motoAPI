package com.moto.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moto.entity.Marca;
import com.moto.entity.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {
	
	public List<Moto> findByNome (String nome); //findBy é reservado, tem que começar assim + nome da variavel ou obj com 1ªletra maiúscula, depois implementa na service e controller
	
	public List<Moto> findByMarca (Marca marca);
	
	public List<Moto> findByMarcaNome (String nome); //nesse caso está acessando a variavel nome atraves do obj Marca na classe Moto
	
	//@Query("FROM Moto m WHERE m.ano >:ano") também funciona
	@Query("SELECT m FROM Moto m WHERE m.ano >:ano")
	public List<Moto> findAcimaAno(int ano);

}
