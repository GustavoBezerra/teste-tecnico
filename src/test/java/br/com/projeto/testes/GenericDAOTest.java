package br.com.projeto.testes;

import br.com.projeto.dao.GenericDAO;
import br.com.projeto.modelo.Projeto;
import br.com.projeto.modelo.Status;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 31/07/2017
 * Classe responsável por testar os métodos da classe GenericDAO
 */
public class GenericDAOTest {

    @Test
    public void testaInsercao() {
        GenericDAO genericDAO = new GenericDAO();
        Projeto projeto = new Projeto();
        projeto.setNome("Projeto teste 2");
        projeto.setDescricao("Descricao do projeto teste 2");
        projeto.setScreenshot("http://daoisjd.caojd.coa");
        projeto.setStatus(Status.CONCLUIDO);
        genericDAO.salvar(projeto);
        
        List<Projeto> registros = genericDAO.consultar();
        Projeto ultimoRegistro = registros.get(registros.size()-1);
        
        assertEquals(ultimoRegistro.getId(), projeto.getId());
        assertEquals(ultimoRegistro.getDescricao(), projeto.getDescricao());
        assertEquals(ultimoRegistro.getNome(), projeto.getNome());
        assertEquals(ultimoRegistro.getScreenshot(), projeto.getScreenshot());
        assertEquals(ultimoRegistro.getStatus(), projeto.getStatus());
    }
}
