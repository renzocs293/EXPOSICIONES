package com.breinercorrea.crud.app.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.breinercorrea.crud.app.dto.Mensaje;

/*Esta clase va comprobar si hay un token valido , 
 * sino devuelve una respuesta 401 'no autorizado'*/
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {



    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);


	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,AuthenticationException e)
			throws IOException, ServletException {
		logger.error("fallo en el metodo commence");
		// Mensaje de no autorizado
		// Esto rechaza todas  la peticiones que no esten authenticadas
		// y manda la respuesta no autorizado
        // res.sendError(HttpServletResponse.SC_UNAUTHORIZED, new Mensaje("no autorizado"));
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
		
	}



}
