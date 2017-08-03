package br.com.projeto.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 */
public class JPAUtil {
    
    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("aws-mysql");
    
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
