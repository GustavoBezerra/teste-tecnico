package br.com.projeto.dao;

import br.com.projeto.modelo.Projeto;
import br.com.projeto.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 * Interface responsável por representar os métodos principais de um DAO
 */
public interface IDAO {
    
    public void salvar(Projeto projeto);
    public List<Projeto> consultar();

}
