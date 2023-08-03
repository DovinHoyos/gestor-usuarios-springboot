package com.example.cursojavaspringboot.controllers;

import com.example.cursojavaspringboot.dao.UsuarioDao;
import com.example.cursojavaspringboot.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController{

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "/api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "/api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable long id){
        return null;
    }
    @RequestMapping(value = "/api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();

    }
    @RequestMapping(value = "/api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }
}
