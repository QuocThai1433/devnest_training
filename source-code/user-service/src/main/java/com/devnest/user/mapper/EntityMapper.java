package com.devnest.user.mapper;

import java.util.List;

public interface EntityMapper<D, E    >{

    D delete( Long id);
    D toEntity( E e);
    E toDTO (D d);
    List<D> toDTO( List<E> e);
    List<E> toEntity (List<D> d);
}
