package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

import jakarta.validation.Valid;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/postagens") // Define o mapeamento de URL para este controlador
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permite solicitações de qualquer origem (CORS)
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository; // Injeta o repositório de postagens

	@GetMapping // Define um método para manipular solicitações GET
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll()); // Retorna todas as postagens existentes
	}

	@GetMapping("/{id}") // Define um método para manipular solicitações GET com um ID específico
	public ResponseEntity<Postagem> getById(@PathVariable Long id) {
		return postagemRepository.findById(id) // Procura a postagem pelo ID fornecido
				.map(resposta -> ResponseEntity.ok(resposta)) // Se encontrada, retorna a postagem
				.orElse(ResponseEntity.notFound().build()); // Se não encontrada, retorna uma resposta 404
	}

	@GetMapping("/titulo/{titulo}") // Define um método para manipular solicitações GET com base no título da postagem
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
	    // Retorna todas as postagens que contenham o título fornecido (ignorando maiúsculas e minúsculas)
	    return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PostMapping // Define um método para manipular solicitações POST
	public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem) {
	    // O parâmetro @Valid é usado para validar a entrada da postagem conforme as anotações de validação definidas na classe Postagem
	    // O parâmetro @RequestBody indica que o corpo da solicitação HTTP será convertido para um objeto Postagem
	    
	    return ResponseEntity.status(HttpStatus.CREATED) // Retorna um código de status HTTP 201 CREATED
	            .body(postagemRepository.save(postagem)); // Salva a postagem no banco de dados e retorna a postagem salva na resposta
	}
	
	@PutMapping // Define um método para manipular solicitações PUT
	public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
	    return postagemRepository.findById(postagem.getId()) // Procura a postagem no banco de dados pelo ID fornecido
	            .map(resposta -> ResponseEntity.status(HttpStatus.OK) // Se encontrada, atualiza a postagem e retorna uma resposta HTTP 200 OK
	                        .body(postagemRepository.save(postagem)))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Se não encontrada, retorna uma resposta HTTP 404 NOT FOUND
	}
	@ResponseStatus(HttpStatus.NO_CONTENT) // Define o código de status HTTP 204 NO_CONTENT para a resposta
	@DeleteMapping("/{id}") // Define um método para manipular solicitações DELETE com um ID específico
	public void delete(@PathVariable Long id) {
	    // Obtém a postagem do banco de dados com o ID fornecido
	    Optional<Postagem> postagem = postagemRepository.findById(id);
	    
	    // Verifica se a postagem existe
	    if (postagem.isEmpty()) // Se a postagem não for encontrada, lança uma exceção com código de status HTTP 404 NOT_FOUND
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	    
	    // Se a postagem existir, exclui-a do banco de dados
	    postagemRepository.deleteById(id);
	}

	

}


