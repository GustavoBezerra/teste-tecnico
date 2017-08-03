package br.com.projeto.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   01/08/2017
 */
@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull(message="O cliente deve possuir um nome.")
    @Size(min = 2, max = 20, message = "Nome do cliente deve ter entre 2 e 20 caracteres.")
    private String nome;

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

}
