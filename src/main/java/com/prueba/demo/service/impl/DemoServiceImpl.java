package com.prueba.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.demo.core.entity.Usuario;
import com.prueba.demo.repository.UsuarioRepository;
import com.prueba.demo.service.DemoService;
import com.prueba.demo.support.dto.Respuesta;
import com.prueba.demo.support.dto.UsuarioDto;

@Service
public class DemoServiceImpl implements DemoService {
	private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);


	@Autowired
	UsuarioRepository usuarioRepository;



	@Override
	public Respuesta<?> getListarUsuario() throws Exception {

		
		List<Usuario> listaUsuarios = usuarioRepository.findAll();

		List<UsuarioDto> listaUsuarioDto = new ArrayList<>();
		UsuarioDto usuarioDto = new UsuarioDto();

		for (Usuario usuario : listaUsuarios) {
			usuarioDto = new UsuarioDto();
			
			usuarioDto.setId(usuario.getId());
			usuarioDto.setName(usuario.getName());
			usuarioDto.setEmail(usuario.getEmail());
			usuarioDto.setPassword(usuario.getPassword());
			usuarioDto.setActive(usuario.getActive());
			usuarioDto.setDateCreate(usuario.getDateCreate());
			usuarioDto.setDateModify(usuario.getDateModify());
			usuarioDto.setDateLastLogin(usuario.getDateLastLogin());
			listaUsuarioDto.add(usuarioDto);
		}
		
		return new Respuesta<>(true, listaUsuarioDto);
	}

}