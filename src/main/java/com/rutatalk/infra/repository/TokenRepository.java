package com.rutatalk.infra.repository;

import com.rutatalk.infra.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    Optional<TokenEntity> findByAccessToken(String accessToken);

}
