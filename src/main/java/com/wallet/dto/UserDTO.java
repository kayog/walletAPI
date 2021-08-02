package com.wallet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private Long id;
	@NotEmpty
	@Size(min = 3, max=50, message = "O nome deve conter entre 3 e 50 caracteres")
	private String name;
	@NotEmpty
	@Size(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
	private String password;
	@NotEmpty
	@Email(message = "E-mail inválido")
	private String email;
	@NotNull(message = "Informe uma role de acesso")
	@Pattern(regexp="^(ROLE_ADMIN|ROLE_USER)$", message = "Para a role de acesso somente são aceitos os valores ROLE_ADMIN ou ROLE_USER")
	private String role;
}
