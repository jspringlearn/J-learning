package cn.gsonya.Practice.base.service;

import java.io.Serializable;
import java.util.List;

import cn.gsonya.Practice.base.domain.BaseTreeEntity;

@SuppressWarnings("rawtypes")
public interface GenericTreeManager<T extends BaseTreeEntity,PK extends Serializable>extends GenericManager<T,PK> {
	public List<T>getAncestors(PK id);
	public List<T>getChildren(PK id);
	public List<T>getDescendants(PK id);
	public List<T>getRoot();

}
