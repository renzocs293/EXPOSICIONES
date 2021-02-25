package com.breinercorrea.crud.app.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.breinercorrea.crud.app.security.service.UserDetailsServiceImpl;

/*Esta clase se va ejecutar por cada peticion, 
 * va comprobar que sea valido el token ,
 * atravez de la clase JwtProvider,
 * y en caso que sea valido el token va permitir el acceso al recurso
 * en caso contrario lanzara una excepcion */

/*OncePerRequestFilter le dice: que se va ejecutar una vez por cada peticion*/
public class JwtTokenFilter extends OncePerRequestFilter{
	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
       
        	// Tomamos al token
            String token = getToken(req);
            // Si el token no es nulo y Con el JwtProvider vemos q es Valido 
            if(token != null && jwtProvider.validateToken(token)){
            	// Tomamos al nombre del usuario
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                // Datos del usuario
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);

                // Creamos una nueva authenticacion
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e){
            logger.error("fallo en el metodo doFilter " + e.getMessage());
        }
        // Si todo sale bien se ejecuta
        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request){
     	// en el request en la cabecera vendra como 
    	// Bearer + Token
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
        	// Sacamos al bearer del token
            return header.replace("Bearer ", "");
        return null;
    }

}
