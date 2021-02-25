package com.breinercorrea.crud.app.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.breinercorrea.crud.app.security.entity.Usuario;
import com.breinercorrea.crud.app.security.entity.UsuarioPrincipal;

/*Implementa la interfaz UserDetailsService*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    // Traemos al usuario de la base de datos (Usuario) y lo convierte en 
    // un usuario para Spring Security (UsuarioPrincipal)
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        // Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        Optional<Usuario> optional = usuarioService.getByNombreUsuario(nombreUsuario);
        Usuario usuario = optional.get();
        return UsuarioPrincipal.build(usuario);
    }

}
