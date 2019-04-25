package cn.gsonya.Practice.base.dao;

import java.io.Serializable;
import java.util.List;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;

import cn.gsonya.Practice.base.BaseAbstractTestCase;
import cn.gsonya.Practice.base.domain.BaseEntity;

@ContextConfiguration(locations = { "classpath:/applicationContextTest-resources.xml",
"classpath:/applicationContext-dao.xml",})
public class GenericDaoTest<PK extends Serializable, T extends BaseEntity, D extends GenericDao<T, PK>>
extends BaseAbstractTestCase {
	
	protected D dao;

	protected T entity;

	protected PK id;

	protected List<T> list;

	@Before
	public void setUp() throws Exception {
	}

}
