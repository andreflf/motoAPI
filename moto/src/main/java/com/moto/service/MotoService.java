package com.moto.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.entity.Marca;
import com.moto.entity.Moto;
import com.moto.repository.MotoRepository;

@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepository;
	
	public String save(Moto moto) {
		this.motoRepository.save(moto);
		return "Moto salva com sucesso";
	}
	
	public String update(Moto moto, Long id) {
		if(this.motoRepository.existsById(id)) {
		moto.setId(id);
		this.motoRepository.save(moto);
		return "Moto atualizada com sucesso";
		}else
			return "ID não localizado";
	}
	
	public String deleteById(Long id) {
		this.motoRepository.deleteById(id);
		return "Moto deletada com sucesso";
	}
	
	public Optional<Moto> findById(Long id) {
		return this.motoRepository.findById(id);
	}
	
	public List<Moto> findAll(){
		return this.motoRepository.findAll();
	}
	
	public List<Moto> findByNome(String nome){
		return this.motoRepository.findByNome(nome);
	}
	
	public List<Moto> findByMarca(long idMarca){
		Marca marca = new Marca();
		marca.setId(idMarca);
		return this.motoRepository.findByMarca(marca);
	}
	
	public List<Moto> findAcimaAno(int ano){
		return this.motoRepository.findAcimaAno(ano);
	}
	
	public List<Moto> findByMarcaNome(String nome){
		return this.motoRepository.findByMarcaNome(nome);
	}

}
