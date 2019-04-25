package cn.gsonya.Practice.base.service;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import cn.gsonya.Practice.base.BaseAbstractTestCase;
import cn.gsonya.Practice.base.domain.BaseEntity;

@ContextConfiguration(locations= {"classpath:/applicationContextTest-resources.xml","classpath:/applicationContext-dao,xml","classpath:/applicationContext-service.xml"})
public abstract class GenericManagerTest<PK extends Serializable,T extends BaseEntity,M extends GenericManager<T,PK>>extends BaseAbstractTestCase {
	protected T entity;
	protected List<T>list;
	protected M manager;
	private Class<T>persistentClass;
	
	public GenericManagerTest(final Class<T>persistentClass) {
		this.persistentClass=persistentClass;
	}
	private void assertEntityEquals(T entity,T foundEntity) {
		assertEquals(entity.getId(),foundEntity.getId());
	}

	@Before
	public void setUp() throws Exception {
		this.entity=this.persistentClass.getDeclaredConstructor().newInstance();
	}

	@Test
	public void testCRUD() {
		if(this.entity==null) {
			try {
				this.entity=this.persistentClass.getDeclaredConstructor().newInstance();
				T newEntity=this.manager.save(this.entity);
                @SuppressWarnings("unchecked")
                PK entity_id=(PK)newEntity.getId();
                T foundEntity=this.manager.findById(entity_id);
                assertEntityEquals(newEntity,foundEntity);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
