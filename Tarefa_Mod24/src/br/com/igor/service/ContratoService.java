package br.com.igor.service;

import br.com.igor.dao.IContratoDao;

public class ContratoService implements IContratoService{
    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    public String buscar(){
        contratoDao.buscar();
        return "Cliente Buscado com Sucesso";
    }

    public String excluir(){
        contratoDao.excluir();
        return "Cliente Excluido com Sucesso";
    }

    public String atualizar(){
        contratoDao.atualizar();
        return "Cliente Atualizado com Sucesso";
    }
}
