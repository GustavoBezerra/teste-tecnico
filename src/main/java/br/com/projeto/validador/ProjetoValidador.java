package br.com.projeto.validador;

import br.com.projeto.dao.ProjetoDAO;
import br.com.projeto.modelo.Cliente;
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
 * @date 31/07/2017
 */
public class ProjetoValidador implements IValidador<Projeto> {

    private static ValidatorFactory factory;
    private static Validator validator;

    public ProjetoValidador() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Override
    public List<String> validar(Projeto entity) {
        List<String> mensagens = new ArrayList<>();
        Set<ConstraintViolation<Projeto>> projetoViolations = validator.validate(entity);

        if (!projetoViolations.isEmpty()) {
            for (ConstraintViolation violacao : projetoViolations) {
                mensagens.add(violacao.getMessage());
            }
        }

        if (entity.getCliente() != null) {
            Set<ConstraintViolation<Cliente>> clienteViolations = validator.validate(entity.getCliente());
            if (!clienteViolations.isEmpty()) {
                for (ConstraintViolation violacao : clienteViolations) {
                    mensagens.add(violacao.getMessage());
                }
            }
        }

        return mensagens;
    }

}
