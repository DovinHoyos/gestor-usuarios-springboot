package com.example.cursojavaspringboot.controllers;

import com.example.cursojavaspringboot.dao.UsuarioDao;
import com.example.cursojavaspringboot.dao.UsuarioDaoImp;
import com.example.cursojavaspringboot.models.Usuario;
import com.example.cursojavaspringboot.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogueado != null){

            return jwtUtil.create(String
                    .valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
        }
        return "FAIL";
    }
}
