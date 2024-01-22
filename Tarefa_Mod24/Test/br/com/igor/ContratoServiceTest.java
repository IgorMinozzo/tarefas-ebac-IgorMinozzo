package br.com.igor;

import br.com.igor.dao.ContratoDao;
import br.com.igor.dao.IContratoDao;
import br.com.igor.dao.mocks.ContratoDaoMock;
import br.com.igor.service.ContratoService;
import br.com.igor.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {
    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Cliente Buscado com Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoBuscarComBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Cliente Buscado com Sucesso", retorno);
    }

    @Test
    public void excluirTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Cliente Excluido com Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoExcluirComBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Cliente Excluido com Sucesso", retorno);
    }

    @Test
    public void atualizarTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Cliente Atualizado com Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoAtualizarComBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Cliente Atualizado com Sucesso", retorno);
    }
}
