package proyecto.edu.pe.proyecto.response;

import proyecto.edu.pe.proyecto.entity.Usuario;

public record UsuarioLoginResponse(String code, String error, String token) {
}
