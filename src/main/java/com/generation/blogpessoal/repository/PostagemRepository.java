// Este trecho de código declara um pacote para a interface PostagemRepository
package com.generation.blogpessoal.repository;

// Importações necessárias para utilizar funcionalidades do Spring Data JPA
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

// Importação da classe Postagem do pacote com.generation.blogpessoal.model
import com.generation.blogpessoal.model.Postagem;

// Declaração da interface PostagemRepository que estende JpaRepository,
// indicando que trabalhará com a entidade Postagem e o tipo de seu ID (Long)
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	// Método de consulta personalizada para buscar postagens pelo título, ignorando
	// maiúsculas e minúsculas
	List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

}
