package br.com.projeto.service;

import br.com.projeto.modelo.Projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 */
public class ProjetoService {
    
    private static ValidatorFactory factory;
    private static Validator validator;
    
    public ProjetoService(){
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
    }
    
    public List<String> validar(Projeto projeto){
        List<String> mensagens = new ArrayList<>();
        Set<ConstraintViolation<Projeto>> constraintViolations = validator.validate(projeto);
        if(!constraintViolations.isEmpty()){
             for(ConstraintViolation p : constraintViolations){
                 mensagens.add(p.getMessage());
             }
        } 
        return mensagens;
    }

}
