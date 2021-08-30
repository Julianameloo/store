package br.com.api.store.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.api.store.model.Cliente;
import br.com.api.store.repository.ClienteRepository;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	private ClienteRepository clienteRepository;
	
	public AutenticacaoTokenFilter(TokenService tokenService, ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
		this.tokenService = tokenService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//pegar token da requisicao
		String token = recuperarToken(request);
		
		boolean valido = tokenService.isTokenValido(token);
		
		if (valido) {
			autenticarCliente(token);
		}

		// terminar o filtro e continuar com a requisicao
		filterChain.doFilter(request, response);

	}
	
	private void autenticarCliente(String token) {
		Integer idCliente = tokenService.getIdCliente(token);
		
		Cliente cliente = clienteRepository.findById(idCliente).get();
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(cliente, null, cliente.getAuthorities());
		
		//forcar a autenticacao
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}
	
	private String recuperarToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
}
