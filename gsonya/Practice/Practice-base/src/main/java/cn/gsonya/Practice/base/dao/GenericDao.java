package cn.gsonya.Practice.base.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.gsonya.Practice.base.domain.BaseEntity;

public interface GenericDao<T extends BaseEntity,PK extends Serializable>extends JpaRepository<T,PK>,JpaSpecificationExecutor<T> {

}
