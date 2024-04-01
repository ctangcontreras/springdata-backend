package com.prueba.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.demo.core.entity.Usuario;


 
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

   List<Usuario> findByEmail(String email);
}