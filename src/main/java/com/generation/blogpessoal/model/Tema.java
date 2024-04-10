package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "tb_temas") // Especifica o nome da tabela no banco de dados
public class Tema {

    @Id // Define a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de chaves primárias
    private Long id;

    @NotNull(message = "O atributo Descrição é obrigatório") // Validação de atributo para garantir que não seja nulo
    private String descricao;

    // Relacionamento OneToMany com a entidade Postagem
    // Um Tema pode ter várias Postagens
    @OneToMany(
    	    fetch = FetchType.LAZY, // Define a estratégia de carregamento como Lazy, ou seja, os dados relacionados serão carregados apenas quando necessários
    	    mappedBy = "tema", // Especifica o nome do atributo na classe Postagem que faz o mapeamento inverso deste relacionamento
    	    cascade = CascadeType.REMOVE // Define o comportamento de cascata para operações de remoção, onde a remoção de um Tema também resulta na remoção de todas as Postagens associadas a ele
    	)
    @JsonIgnoreProperties("tema") // Evita recursividade infinita ao serializar para JSON
    private List<Postagem> postagem;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
}
