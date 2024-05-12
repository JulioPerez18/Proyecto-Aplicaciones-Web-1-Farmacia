package proyecto.edu.pe.proyecto.service;

import proyecto.edu.pe.proyecto.DTO.DTOEmpleado;
import proyecto.edu.pe.proyecto.entity.Empleado;

public interface IEmpleado {

    Empleado save(DTOEmpleado dtoEmpleado);
    Empleado findById (Integer id);
    void delete(Empleado empleado);
    Iterable<Empleado> findall();
}
