package com.wallet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class WalletDTO {
	
	private Long id;
	@NotEmpty
	@Size(min = 3, max=50, message = "O nome deve conter entre 3 e 50 caracteres")
	private String name;
	@NotNull
	private BigDecimal value;

}
