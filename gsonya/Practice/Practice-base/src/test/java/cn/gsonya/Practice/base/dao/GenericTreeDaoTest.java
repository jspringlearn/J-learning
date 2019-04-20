package cn.gsonya.Practice.base.dao;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.Test;

import cn.gsonya.Practice.base.domain.BaseTreeEntity;

public class GenericTreeDaoTest<PK extends Serializable, T extends BaseTreeEntity<T>, M extends GenericTreeDao<T, PK>>
extends GenericDaoTest<PK, T, M>  {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
