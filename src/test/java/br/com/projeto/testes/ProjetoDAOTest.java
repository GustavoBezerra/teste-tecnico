package br.com.projeto.testes;

import br.com.projeto.dao.ProjetoDAO;
import br.com.projeto.modelo.Cliente;
import br.com.projeto.modelo.Projeto;
import br.com.projeto.modelo.Status;
import java.util.UUID;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 31/07/2017
 * Classe responsável por testar os métodos da classe ProjetoDAO
 */
public class ProjetoDAOTest extends MainTestes{
    
    private static Projeto projeto;
    private static ProjetoDAO projetoDAO;
    private static int quantidadeProjetos = 0;

    @BeforeClass
    public static void criaProjeto() {
        projeto = new Projeto();
        Cliente cliente = new Cliente();
        projetoDAO = new ProjetoDAO();
        
        cliente.setNome("Gustavo");
        projeto.setCliente(cliente);
        projeto.setNome(getStringAleatoria(10));
        projeto.setDescricao(getStringAleatoria(30));
        projeto.setScreenshot(getStringAleatoria(25));
        projeto.setStatus(Status.CONCLUIDO);
        
        quantidadeProjetos = projetoDAO.consultar().size();
    }
    
    @Test
    public void testaOperacoes(){        
        testaInsercao();
        testaConsultarTodos();
        testaConsultar();
        testaAlteracao();
    }
    
    private void testaInsercao(){
        projetoDAO.salvar(projeto);
    }
    
    private void testaConsultarTodos(){
        assertEquals(projetoDAO.consultar().size(), quantidadeProjetos+1);
    }
    
   
    public void testaConsultar(){
        Projeto projetoConsultado = projetoDAO.consultar(projeto.getId());

        assertEquals(projeto.getId(), projetoConsultado.getId());
        assertEquals(projeto.getNome(), projetoConsultado.getNome());
        assertEquals(projeto.getDescricao(), projetoConsultado.getDescricao());
        assertEquals(projeto.getScreenshot(), projetoConsultado.getScreenshot());
        assertEquals(projeto.getStatus(), projetoConsultado.getStatus());
        assertEquals(projeto.getCliente().getNome(), projetoConsultado.getCliente().getNome());
        assertEquals(projeto.getCliente().getId(), projetoConsultado.getCliente().getId());
    }
    
   
    public void testaAlteracao(){
        projeto.setNome(getStringAleatoria(10));
        projeto.getCliente().setNome(getStringAleatoria(10));
        projetoDAO.alterar(projeto);

        assertEquals(projetoDAO.consultar(projeto.getId()).getNome(), projeto.getNome());
        assertEquals(projetoDAO.consultar(projeto.getId()).getCliente().getNome(), projeto.getCliente().getNome());
    }
    
    @After
    public void testaRemocao(){
        quantidadeProjetos = projetoDAO.consultar().size();
        projetoDAO.deletar(projeto.getId());
        assertEquals(projetoDAO.consultar().size(), quantidadeProjetos-1);
    }
    
    

}
