package proyecto.edu.pe.proyecto.response;

import proyecto.edu.pe.proyecto.entity.Empleado;

public record FindEmpleadoResponse(String code, String error, Iterable<Empleado> empleados) {
}
