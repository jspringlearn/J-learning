package dao.Road.dao;

import base.dao.GenericTreeDao;
import dao.Road.domain.RMap;

public interface RMapDao extends GenericTreeDao<RMap, Long> {

	public void startRMap();
	public void stopRMap();
}
