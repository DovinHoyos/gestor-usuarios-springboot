package com.example.cursojavaspringboot.controllers;

import com.example.cursojavaspringboot.dao.UsuarioDao;
import com.example.cursojavaspringboot.dao.UsuarioDaoImp;
import com.example.cursojavaspringboot.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuarioDao.verificarCredenciales(usuario)){
            return "OK";
        }
        return "FAIL";
    }
}
