package br.com.projeto.dao;

import br.com.projeto.modelo.Projeto;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 */
public class ProjetoDAO extends AbstractDAO<Projeto>{

    @Override
    public void deletar(int id) {
        openConnection();
        entityManager.getTransaction().begin();
        Projeto projeto = entityManager.find(Projeto.class, id);
        entityManager.remove(projeto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Projeto> consultar() {
        openConnection();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Projeto> query = builder.createQuery(Projeto.class);
        query.from(Projeto.class);
        List<Projeto> resultList = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public Projeto consultar(int id) {
        openConnection();
        entityManager.getTransaction().begin();
        Projeto projeto = entityManager.find(Projeto.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return projeto;
    }

    
}
