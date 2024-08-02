package br.com.cdc.seeddesafiocdc.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Compra;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.CupomDesconto;

@Repository
public interface CupomDescontoRepository extends JpaRepository<CupomDesconto, Long> {

	@Query("""
			select 
				case 
					when count(c) > 0 then 
						true 
					else 
						false 
				end 
			from CupomDesconto c
			where c.codigo = :codigo
			and c.dataValidade >= current_date
		""")
	boolean existsCupomValido(String codigo);

	Optional<CupomDesconto> findByCodigo(String codigoCupom);

}
