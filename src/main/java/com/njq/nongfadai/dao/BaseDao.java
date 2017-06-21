package com.njq.nongfadai.dao;

import java.util.List;

public interface BaseDao<T> {

	public int addEntity(T t);

	public int deleteEntityById(Integer id);

	public int deleteEntity(T t);

	public int updateEntity(T t);

	public T findEntityById(Integer id);

	public List<T> findEntity(T t);
}
