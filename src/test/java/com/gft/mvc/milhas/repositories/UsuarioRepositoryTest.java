package com.gft.mvc.milhas.repositories;

import com.gft.mvc.milhas.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositoryTest {
    UsuarioRepository repository;

    @Test
    public void testeDoBancoDeDados() {
        Usuario novo = new Usuario();

        novo.setNome("Marcelo");
        novo.setEmail("marcelo@gft.com");
        novo.setQuatroLetras("MAAS");
        novo.setSenha("123456");

//        this.repository.save(novo);
    }
}