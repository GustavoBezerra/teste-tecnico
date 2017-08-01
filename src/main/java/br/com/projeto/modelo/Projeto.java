package br.com.projeto.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 * Classe responsável por representar um projeto
 */
@Entity
public class Projeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull(message="Nome do projeto não pode ser nulo.")
    @Size(min = 2, max = 20, message = "Nome do projeto deve ter entre 2 e 20 caracteres.")
    private String nome;
    
    @NotNull(message="O projeto deve ter um cliente.")
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    
    @NotNull
    @Size(min = 2, max = 100, message="Descrição do projeto deve ter entre {min} e {max} caracteres.")
    private String descricao;
    
    @NotNull(message="URL da imagem não pode ser nula.")
    private String screenshot;
    
    @NotNull(message="Status do projeto não pode ser nulo.")
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the screenshot
     */
    public String getScreenshot() {
        return screenshot;
    }

    /**
     * @param screenshot the screenshot to set
     */
    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
