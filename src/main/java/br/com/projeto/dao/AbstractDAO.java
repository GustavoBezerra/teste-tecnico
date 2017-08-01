package br.com.projeto.dao;

import br.com.projeto.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 */
public abstract class AbstractDAO<T> implements IDAO<T>{
    
    protected EntityManager entityManager;
    
    protected void openConnection(){
        entityManager = new JPAUtil().getEntityManager();
    }
    
    @Override
    public void salvar(T entity) {
        openConnection();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    @Override
    public void alterar(T entity) {
        openConnection();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    

}
