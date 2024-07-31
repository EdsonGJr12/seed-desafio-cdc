package br.com.cdc.seeddesafiocdc.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
