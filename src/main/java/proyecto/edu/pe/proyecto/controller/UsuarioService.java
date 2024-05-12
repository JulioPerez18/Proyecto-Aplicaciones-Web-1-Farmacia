package proyecto.edu.pe.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import proyecto.edu.pe.proyecto.entity.Usuario;
import proyecto.edu.pe.proyecto.repository.UsuarioDAO;
import proyecto.edu.pe.proyecto.response.UsuarioLoginResponse;
import proyecto.edu.pe.proyecto.security.JWTAuthenticationConfig;
@RestController
@RequestMapping("/user")
public class UsuarioService {

    @Autowired
    UsuarioDAO dao;
    @Autowired
    JWTAuthenticationConfig jwtAuthenticationConfig;

    @PostMapping("/login")
    public UsuarioLoginResponse findUsers(@RequestBody Usuario user)
    {
        Usuario usuariobuscado = dao.findByUsuarioCorreo(user.getUsuarioCorreo());
        if(usuariobuscado == null){
            return new UsuarioLoginResponse("99","Credenciales Incorrectas", null);
        }
        if(new BCryptPasswordEncoder().matches(user.getUsuarioContrasenia(),usuariobuscado.getUsuarioContrasenia())){
            return  new UsuarioLoginResponse("99","Wrong password",null);

        }
        String token= jwtAuthenticationConfig.getJWTToken(user.getUsuarioCorreo());
        return new UsuarioLoginResponse("1",null, token);
    }
}
