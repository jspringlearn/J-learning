package cn.gsonya.Practice.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import cn.gsonya.Practice.base.domain.BaseTreeEntity;


@NoRepositoryBean
public abstract interface GenericTreeDao<T extends BaseTreeEntity<T>, PK extends Serializable>
extends GenericDao<T, PK> {
	List<T>getRoot();

}
