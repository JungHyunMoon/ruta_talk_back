package com.rutatalk.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.infra.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	
}
