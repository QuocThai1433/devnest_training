package com.devnest.course.mapper;

import java.util.List;

public interface EntityMapper<D, E> {
	
	D toDTO(E e);
	
	E toEntity(D d);
	
	List<D> toDTO(List<E> e);
	
	List<E> toEntity(List<D> d);
}
