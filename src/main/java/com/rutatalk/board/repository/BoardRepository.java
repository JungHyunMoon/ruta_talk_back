package com.rutatalk.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
}
