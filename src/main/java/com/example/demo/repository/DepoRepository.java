package com.example.demo.repository;

import com.example.demo.depots.entity.DepoEntity;
import com.example.demo.depots.entity.DepoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepoRepository extends JpaRepository<DepoEntity, Long> {


    Optional<DepoEntity> findByDepoType(DepoType depoType);
}
