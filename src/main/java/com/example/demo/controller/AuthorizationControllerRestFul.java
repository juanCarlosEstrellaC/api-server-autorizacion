package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.segurity.JwtUtils;
import com.example.demo.service.to.UsuarioTo;

@RestController
@RequestMapping("/autorizaciones")
public class AuthorizationControllerRestFul {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwt;
	
	
	// PILAS!, ESTA CAPACIDAD (ObtenerToken) PARA OBTENER UN TOKEN DEBE SER PUBLICA.
	@GetMapping(path = "/jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerToken(@RequestBody UsuarioTo usuario) {
		// Autenticación
		// Validar usuario y contraseña
		// si es correcta retorno el token
		System.out.println(usuario);
		this.autenticacion(usuario.getNombre(), usuario.getPassword());
		return this.jwt.buildTokenJwt(usuario.getNombre());
	}
	
	// automáticamente compara si el usuario y contraseña están bien. 
	private void autenticacion(String usuario, String password) {
		UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario, password);
		Authentication autenticacion =  this.authenticationManager.authenticate(usuarioToken);
		SecurityContextHolder.getContext().setAuthentication(autenticacion);
	}
	
}
