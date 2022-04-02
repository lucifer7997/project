package com.fa.edu.mapper;

import java.util.List;

public interface EntityMapper<D, T> {
	T toEntity(D dto);

	D toDto(T entity);

	List<T> toEntitiesList(List<D> dtos);

	List<D> toDtosList(List<T> entities);
}
