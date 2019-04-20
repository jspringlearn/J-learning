package cn.gsonya.Practice.base.service.Impl;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import cn.gsonya.Practice.base.dao.GenericDao;
import cn.gsonya.Practice.base.domain.BaseEntity;
import cn.gsonya.Practice.base.service.GenericManager;

@Transactional
public class GenericManagerImpl<T extends BaseEntity,PK extends Serializable>implements GenericManager<T,PK> {
	protected static final Logger logger=LogManager.getLogger(GenericManagerImpl.class.getName());
	protected GenericDao<T,PK>dao;
	public void delete(PK id) {
		this.dao.deleteById(id);
	}
	public List<T>findAll(){
		return this.dao.findAll();
	}
	public Page<T>findAll(Pageable page){
		Page<T>result=this.dao.findAll(page);
		return result;
	}
	public List<T>save(Iterable<T>entities){
		return this.dao.saveAll(entities);
	}
	public T save(T entity) {
		return this.dao.saveAndFlush(entity);
	}
	@Override
	public T findById(PK id) {
		// TODO Auto-generated method stub
		return this.dao.getOne(id);
	}

}
