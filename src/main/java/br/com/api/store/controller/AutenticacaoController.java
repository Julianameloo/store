package br.com.api.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.store.config.security.TokenService;
import br.com.api.store.dto.TokenDto;
import br.com.api.store.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping // user vai mandar json com usuario e senha
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();

		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			
			// gerando token
			String token = tokenService.gerarToken(authentication);
			// bearer eh o tipo de autenticacao que cliente devera usar na proxima
			// requisicao
			// do tipo Bearer eh mandando o token junto
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

		} catch (org.springframework.security.core.AuthenticationException e) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

		}

	}
}
