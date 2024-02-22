package com.example.demo.repository;

import com.example.demo.repository.modelo.Usuario;

public interface IUsuarioRepository {

	public Usuario consultarPorNombre(String nombre);
}
