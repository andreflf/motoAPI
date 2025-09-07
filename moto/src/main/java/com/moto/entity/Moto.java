package com.moto.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Moto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Nome nao pode ser nulo") //retorna erro 400 bad request (conforme controler)
	private String nome;
	@NotNull(message = "Ano nao pode ser nulo") //por ser int nunca fica null e vira zero por default, por isso melhor usar Integger
	private int ano;
	
	//varios carros podem ter uma marca
	@ManyToOne (cascade = CascadeType.ALL) //permite salvar os dados da marca junto da moto na mesma requisiçao JSON
	@JsonIgnoreProperties("moto")
	private Marca marca;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "moto_proprietario") // Se quiser especificar o nome da tabela que será criada, mas o JPA já cria sozinho
	private List<Proprietario> proprietarios;
}
