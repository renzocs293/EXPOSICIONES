package com.breinercorrea.crud.app.security.jwt;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.breinercorrea.crud.app.security.dto.JwtDto;
import com.breinercorrea.crud.app.security.entity.UsuarioPrincipal;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/*Esta clase se va encargar de generar el token , 
 * tambien posee metodos de validacion ,
 * para ver que esta bien formado */
@Component
public class JwtProvider {
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	// Nuestro firma
    @Value("${jwt.secret}")
    private String secret;

    // Nuestro tiempo de expiracion
    @Value("${jwt.expiration}")
    private int expiration;

    // Generamos el token
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        // Pasamos los authorities en el token
        List<String> roles = usuarioPrincipal.getAuthorities()
        		.stream()
        		.map(GrantedAuthority::getAuthority)
        		.collect(Collectors.toList());
        return Jwts.builder()
        		// Pasamos el nombre de usuario (nick)
        		.setSubject(usuarioPrincipal.getUsername())
        		// En el payload del token va estar los roles
        		.claim("roles", roles)
        		// Pasamos la fecha de logueo
                .setIssuedAt(new Date())
                // Pasamos la expiracion
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                // Nuestro firma con su tipo de algoritmo
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    // Del token queremos extraer el usuario
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser()
        		// firmamos
        		.setSigningKey(secret.getBytes())
        		// Nuestras claves de token q queremos
        		.parseClaimsJws(token)
        		// Obtenemos el body de nuestro token
        		.getBody()
        		// De nuestro token su nombre de usuario
        		.getSubject();
    }

    // Validamos el token
    public boolean validateToken(String token){
        try {
            Jwts.parser()
            // firmamos
            .setSigningKey(secret)
            // pasamos nuestro token para que lo valide
            .parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacio");
        }catch (SignatureException e){
            logger.error("fallo en la firma");
        }
        return false;
    }
    
    public String refreshToken(JwtDto jwtDto) throws ParseException, java.text.ParseException {
        JWT jwt = JWTParser.parse(jwtDto.getToken());
        JWTClaimsSet claims = jwt.getJWTClaimsSet();
        String nombreUsuario = claims.getSubject();
        List<String> roles = (List<String>)claims.getClaim("roles");

        return Jwts.builder()
                .setSubject(nombreUsuario)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

}
