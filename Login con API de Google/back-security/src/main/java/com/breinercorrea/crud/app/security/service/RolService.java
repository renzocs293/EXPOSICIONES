package com.breinercorrea.crud.app.security.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breinercorrea.crud.app.security.entity.Rol;
import com.breinercorrea.crud.app.security.enums.RolNombre;
import com.breinercorrea.crud.app.security.repository.RolRepository;

@Service
@Transactional
public class RolService {


    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }

}
