package br.com.cdc.seeddesafiocdc.api.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.cdc.seeddesafiocdc.api.validation.UniqueValue;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.CupomDesconto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 1 Ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class NovoCupomDescontoForm {
	
	@NotBlank
	@UniqueValue(fieldName = "codigo", classReference = CupomDesconto.class)
	private String codigo;
	
	@NotNull
	@Positive
	private BigDecimal percentualDesconto;
	
	@NotNull
	@Future
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataValidade;
	
	public CupomDesconto toEntity() {
		return new CupomDesconto(codigo, percentualDesconto, dataValidade);
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
}
