package br.com.igor.generic;

import java.io.Serializable;

import br.com.igor.dao.Persistente;

public class GenericDB1DAO <T extends Persistente, E extends Serializable>
extends GenericDAO<T,E> {

public GenericDB1DAO(Class<T> persistenteClass) {
	super(persistenteClass, "Postgre1");
}

}