package com.prueba.demo.service;
 
import com.prueba.demo.support.dto.Respuesta;
import com.prueba.demo.support.dto.UsuarioDto;
 

public interface DemoService {

	Respuesta<?> getListarUsuario() throws Exception;
}
