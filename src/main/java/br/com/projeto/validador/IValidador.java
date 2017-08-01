package br.com.projeto.validador;

import java.util.List;

/**
 *
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   01/08/2017
 */
public interface IValidador<T> {
    
    public List<String> validar(T entity);

}
