package br.com.projeto.testes;

import br.com.projeto.dao.ProjetoDAO;
import br.com.projeto.modelo.Cliente;
import br.com.projeto.modelo.Projeto;
import br.com.projeto.modelo.Status;
import br.com.projeto.validador.ProjetoValidador;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   31/07/2017
 */
public class ProjetoValidadorTest extends MainTestes{
    
    private static ProjetoValidador validadorRegras;
    private static Projeto projeto;
    private static Cliente cliente;
    
    @BeforeClass
    public static void setUp(){
        validadorRegras = new ProjetoValidador();
        assertEquals(10, getStringAleatoria(10).length());
    }
    
    @Before
    public void novoProjeto(){
        projeto = new Projeto();
        cliente = new Cliente();
    }
    
    @Test
    public void testaCamposNulos(){
        List<String> validacoes = validadorRegras.validar(projeto);
        assertEquals(5, validacoes.size());
        assertTrue(validacoes.contains("Nome do projeto não pode ser nulo."));
        assertTrue(validacoes.contains("Status do projeto não pode ser nulo."));
        assertTrue(validacoes.contains("O projeto deve ter um cliente."));
        assertTrue(validacoes.contains("O projeto deve possuir uma descrição."));
        assertTrue(validacoes.contains("Status do projeto não pode ser nulo."));
    }
    
    @Test
    public void testaNomeStatusEClienteNulos(){
        projeto.setDescricao("Desricao");
        projeto.setScreenshot("dasd");
        List<String> validacoes = validadorRegras.validar(projeto);
        assertEquals(3, validacoes.size());
        assertTrue(validacoes.contains("Nome do projeto não pode ser nulo."));
        assertTrue(validacoes.contains("Status do projeto não pode ser nulo."));
        assertTrue(validacoes.contains("O projeto deve ter um cliente."));
    }
    
    @Test
    public void testaDescricaoENomeClienteNulos(){        
        projeto.setNome("Nome");
        projeto.setStatus(Status.EM_DESENVOLVIMENTO);
        projeto.setScreenshot("asd");
        projeto.setCliente(cliente);
        
        List<String> validacoes = validadorRegras.validar(projeto);
        assertEquals(2, validacoes.size());
        assertTrue(validacoes.contains("O projeto deve possuir uma descrição."));
        assertTrue(validacoes.contains("O cliente deve possuir um nome."));
    }
    
    @Test
    public void testaLimitesMaximos(){
        projeto.setScreenshot(getStringAleatoria(50));
        projeto.setStatus(Status.CONCLUIDO);
        
        cliente.setNome(getStringAleatoria(20));
        
        projeto.setNome(getStringAleatoria(20));
        projeto.setDescricao(getStringAleatoria(100));
        projeto.setCliente(cliente);
        
        List<String> validacoes = validadorRegras.validar(projeto);
        assertEquals(0, validacoes.size());
    }
    
    @Test
    public void testaExcederLimitesMaximos(){
        cliente.setNome(getStringAleatoria(25));
        
        projeto.setNome(getStringAleatoria(100));
        projeto.setDescricao(getStringAleatoria(200));
        projeto.setCliente(cliente);
        projeto.setScreenshot(getStringAleatoria(50));
        projeto.setStatus(Status.CONCLUIDO);
        
        List<String> validacoes = validadorRegras.validar(projeto);
        assertEquals(3, validacoes.size());
        assertTrue(validacoes.contains("Nome do projeto deve ter entre 2 e 20 caracteres."));
        assertTrue(validacoes.contains("Descrição do projeto deve ter entre 2 e 100 caracteres."));
        assertTrue(validacoes.contains("Nome do cliente deve ter entre 2 e 20 caracteres."));
    }
    
    @Test
    public void testaLimitesMinimos(){
        projeto.setScreenshot(getStringAleatoria(50));
        projeto.setStatus(Status.CONCLUIDO);
        
        cliente.setNome(getStringAleatoria(2));
        
        projeto.setNome(getStringAleatoria(2));
        projeto.setDescricao(getStringAleatoria(2));
        projeto.setCliente(cliente);
        
        List<String> validacoes = validadorRegras.validar(projeto);
        assertEquals(0, validacoes.size());   
    }
    
    @Test
    public void testaExcederLimitesMinimos(){
        cliente.setNome(getStringAleatoria(1));
        
        projeto.setNome(getStringAleatoria(1));
        projeto.setDescricao(getStringAleatoria(1));
        projeto.setCliente(cliente);
        projeto.setScreenshot(getStringAleatoria(1));
        projeto.setStatus(Status.CONCLUIDO);
        
        List<String> validacoes = validadorRegras.validar(projeto);
        assertEquals(3, validacoes.size());
        assertTrue(validacoes.contains("Nome do projeto deve ter entre 2 e 20 caracteres."));
        assertTrue(validacoes.contains("Descrição do projeto deve ter entre 2 e 100 caracteres."));
        assertTrue(validacoes.contains("Nome do cliente deve ter entre 2 e 20 caracteres."));
    }

}
