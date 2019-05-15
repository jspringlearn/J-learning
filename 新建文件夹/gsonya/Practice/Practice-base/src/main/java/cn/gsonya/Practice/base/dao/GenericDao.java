package cn.gsonya.Practice.base.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import cn.gsonya.Practice.base.domain.BaseEntity;

@NoRepositoryBean
public interface GenericDao<T extends BaseEntity,PK extends Serializable>extends JpaRepository<T,PK>,JpaSpecificationExecutor<T> {

}
