package com.wallet.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.wallet.entity.Wallet;

import lombok.Data;

@Data
public class WalletItemDTO {
	
	private Long id;
	@NotNull(message = "Insira o id da carteira.")
	private Wallet wallet;
	@NotNull(message = "Imforme uma data.")
	private Date date;
	@NotNull(message = "Imforme um tipo")
	private String type;
	@NotNull(message = "Imforme uma descrição.")
	@Size(min = 5,message = "A descrição deve conter no minimo 5 caracteres")
	private String description;
	@NotNull(message = "Informe um valor.")
	private BigDecimal value;

}
