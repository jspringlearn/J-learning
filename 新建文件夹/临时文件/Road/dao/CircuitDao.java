package dao.Road.dao;

import base.dao.GenericDao;
import dao.Road.domain.Circuit;

public interface CircuitDao extends GenericDao<Circuit, Long> {

	public void addCircuit();
	public void deleCircuit();
}
