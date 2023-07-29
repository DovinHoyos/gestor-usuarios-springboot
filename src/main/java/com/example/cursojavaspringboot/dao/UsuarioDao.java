package com.example.cursojavaspringboot.dao;

import com.example.cursojavaspringboot.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);
}
