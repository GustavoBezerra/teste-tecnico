package br.com.projeto.dao;

import br.com.projeto.modelo.Projeto;
import br.com.projeto.util.JPAUtil;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 */
public class GenericDAO implements IDAO{

    private EntityManager entityManager;
    
    private void openConnection(){
        entityManager = new JPAUtil().getEntityManager();
    }
    
    @Override
    public void salvar(Projeto projeto) {
        openConnection();
        entityManager.getTransaction().begin();
        entityManager.persist(projeto);
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
    
    

}
