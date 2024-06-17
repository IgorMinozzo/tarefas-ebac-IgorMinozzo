package br.com.igor.generic;

import java.io.Serializable;

import br.com.igor.dao.Persistente;

public class GenericDB2DAO <T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {


public GenericDB2DAO(Class<T> persistenteClass) {
	super(persistenteClass, "Postgre2");
}

}
