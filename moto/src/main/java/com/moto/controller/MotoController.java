package com.moto.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.moto.entity.Moto;
import com.moto.service.MotoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/moto")
public class MotoController {

	@Autowired
	private MotoService motoService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Moto moto) {
		try {
			
			String msg = this.motoService.save(moto);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Moto moto, @PathVariable Long id) { //tem que escrever a mensagem JSON de request
		try {
			String msg = this.motoService.update(moto, id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) { //passar apenas o id/número na url
		try {
			String msg = this.motoService.deleteById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			Optional<Moto> moto = this.motoService.findById(id);
			if(moto.isPresent())
				return new ResponseEntity<>(moto, HttpStatus.OK);
			else
				return new ResponseEntity<>("Id não encontrado", HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Moto>> findAll(){
		try {
			List<Moto> motos  = this.motoService.findAll();
			return new ResponseEntity<List<Moto>>(motos, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Moto>> findByNome(@RequestParam String nome){ //RequestParam tem que passar a variavel (com o mesmo nome que colocar aqui) e o valor no Postman
		try {
			List<Moto> motos  = this.motoService.findByNome(nome);
			return new ResponseEntity<List<Moto>>(motos, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findByMarcaId")
	public ResponseEntity<List<Moto>> findByMarca(@RequestParam long idMarca){ //RequestParam tem que passar a variavel (com o mesmo nome que colocar aqui no caso "idMarca") e o valor no Params do Postman
		try {
			List<Moto> motos  = this.motoService.findByMarca(idMarca);
			return new ResponseEntity<List<Moto>>(motos, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findByMarcaNome")
	public ResponseEntity<List<Moto>> findByMarcaNome(@RequestParam String nome){ //RequestParam tem que passar a variavel e o valor no Postman
		try {
			List<Moto> motos  = this.motoService.findByMarcaNome(nome);
			return new ResponseEntity<List<Moto>>(motos, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Moto>> findAcimaAno(@RequestParam int ano){
		try {
			List<Moto> motos  = this.motoService.findAcimaAno(ano);
			return new ResponseEntity<List<Moto>>(motos, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
}
