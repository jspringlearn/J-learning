package cn.gsonya.Practice.base.service;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;

import cn.gsonya.Practice.base.domain.BaseTreeEntity;

public abstract class GenericTreeManagerTest<PK extends Serializable,T extends BaseTreeEntity<T>,M extends GenericTreeManager<T,PK>> extends GenericManagerTest<PK, T, M> {
	
	public GenericTreeManagerTest(Class<T>persistentClass) {
		super(persistentClass);
	}
	@Test
	public void testRoot() {
		List<T>result=this.manager.getRoot();

		if (logger.isInfoEnabled()) {
			logger.info("testRoot() - List<T> result={}", result); //$NON-NLS-1$
		}
	}

}
