package br.com.projeto.testes;

import br.com.projeto.modelo.Projeto;
import br.com.projeto.service.ProjetoService;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 */
public class ProjetoServiceTest {
    
    @Test
    public void testa(){
        ProjetoService projetoService = new ProjetoService();
        Projeto projeto = new Projeto();
        projeto.setDescricao("Desricao");
        projeto.setScreenshot("dasd");
        List<String> validacoes = projetoService.validar(projeto);
        assertEquals(2, validacoes.size());
        assertTrue(validacoes.contains("Nome do projeto não pode ser nulo."));
        assertTrue(validacoes.contains("Status do projeto não pode ser nulo."));
    }

}
