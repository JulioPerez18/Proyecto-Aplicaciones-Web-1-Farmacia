package proyecto.edu.pe.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import proyecto.edu.pe.proyecto.entity.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    Usuario findByUsuarioCorreo(String UsuarioCorreo);

}
