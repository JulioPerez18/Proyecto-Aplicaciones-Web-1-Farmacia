package proyecto.edu.pe.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import proyecto.edu.pe.proyecto.entity.Empleado;

public interface EmpleadoDAO extends CrudRepository<Empleado, Integer> {
}
