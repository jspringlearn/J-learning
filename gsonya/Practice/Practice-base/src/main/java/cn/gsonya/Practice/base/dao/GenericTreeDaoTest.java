package cn.gsonya.Practice.base.dao;


import java.io.Serializable;

import cn.gsonya.Practice.base.domain.BaseTreeEntity;

public class GenericTreeDaoTest<PK extends Serializable, T extends BaseTreeEntity<T>, M extends GenericTreeDao<T, PK>>
extends GenericDaoTest<PK, T, M>  {

}
