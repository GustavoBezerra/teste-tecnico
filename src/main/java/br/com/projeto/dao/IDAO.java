package br.com.projeto.dao;

import br.com.projeto.modelo.Projeto;
import java.util.List;

/**
 *
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 * Interface responsável por representar os métodos principais de um DAO
 */
public interface IDAO<T> {
    // TODO: arrumar os comentários
    /**
     * Método responsável por salvar um novo projeto
     * @param entity entidade a ser salva
     */
    public void salvar(T entity);
    
    /**
     * Método responsável por persistir a alteração dos dados de um projeto existente
     * @param entity entidade com os novos dados
     */
    public void alterar(T entity);
    
    /**
     * Método responsável por excluir um projeto
     * @param id ID da entidade a ser excluída
     */
    public void deletar(int id);
    
    /**
     * Método responsável por recuperar todos os projetos cadastrados
     * @return Todos as entidades cadastradas
     */
    public List<T> consultar();
    
    /**
     * Método responsável por consultar um projeto específico
     * @param id ID da entidade a ser consultada
     * @return Projeto referente ao ID passado como parâmetro
     */
    public T consultar(int id);

}
