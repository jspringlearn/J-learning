package com.stu.software.dao;


import com.stu.software.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * Implemented with Spring-Data-JPA Repository
 * <p>
 * Extend this interface if you want type safe (no casting necessary) DAO's for
 * your domain objects.
 *
 * @param <T>
 *            a type variable, Entity
 * @param <PK>
 *            the primary key for that type，Entity Id
 * @author <a href="mailto:ming616@gmail.com">Liu Xiaoming</a>
 */
@NoRepositoryBean   //注解为 一个公共接口  JpaRepository
public interface GenericDao<T extends BaseEntity, PK extends Serializable>
		extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
}