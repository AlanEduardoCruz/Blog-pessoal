// Este trecho de código declara um pacote para a classe Postagem
package com.generation.blogpessoal.model;

// Importações necessárias para utilizar funcionalidades de persistência com JPA
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Declaração da classe Postagem como uma entidade JPA
@Entity

// Mapeamento da tabela no banco de dados
@Table(name = "tb_postagens")
public class Postagem {

<<<<<<< HEAD
=======
	// Atributo de identificação da postagem
>>>>>>> 7a075180ae27c09170fa3f07e92ca6fbfe70c65b
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

<<<<<<< HEAD
	@NotBlank(message = "O atributo título é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
=======
	// Atributo para o título da postagem, com validações de not null e tamanho
	@NotBlank(message = "O atributo titulo é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo titulo deve conter no mínimo 5 e no máximo 100 caracteres")
>>>>>>> 7a075180ae27c09170fa3f07e92ca6fbfe70c65b
	private String titulo;

	// Atributo para o texto da postagem, com validações de not null e tamanho
	@NotBlank(message = "O atributo texto é Obrigatório!")
<<<<<<< HEAD
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
=======
	@Size(min = 5, max = 1000, message = "O atributo texto deve conter no mínimo 5 e no máximo 1000 caracteres")
>>>>>>> 7a075180ae27c09170fa3f07e92ca6fbfe70c65b
	private String texto;

	// Atributo para armazenar a data de criação ou atualização da postagem
	@UpdateTimestamp
	private LocalDateTime data;
<<<<<<< HEAD

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Long getId() {
		return this.id;
=======
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema  tema;
	
	
	// Métodos getters e setters para acessar e modificar os atributos da postagem
	public long getId() {
		return id;
>>>>>>> 7a075180ae27c09170fa3f07e92ca6fbfe70c65b
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return this.data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

<<<<<<< HEAD
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
=======
	
}
>>>>>>> 7a075180ae27c09170fa3f07e92ca6fbfe70c65b
