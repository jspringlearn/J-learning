package cn.gsonya.Practice.base.service;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;

import cn.gsonya.Practice.base.domain.BaseTreeEntity;

public abstract class GenericTreeManagerTest<PK extends Serializable,T extends BaseTreeEntity<T>,M extends GenericTreeManager<T,PK>> extends GenericManagerTest<PK, T, M> {

	public GenericTreeManagerTest(Class<T>persistentClass) {
		super(persistentClass);
	}
	@Test
	public void testGetRoot() {
		List<T>result=this.manager.getRoot();
		if(logger.isInfoEnabled()) {
			logger.info("testGetRoot()-List<T>result"+result);
		}
	}

}
