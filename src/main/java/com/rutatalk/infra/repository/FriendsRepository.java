package com.rutatalk.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.infra.entity.FriendsEntity;

public interface FriendsRepository extends JpaRepository<FriendsEntity, Long>{

}
