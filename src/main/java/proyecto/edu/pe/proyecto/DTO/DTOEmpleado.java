package proyecto.edu.pe.proyecto.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Builder
public class DTOEmpleado {

    private int EmpleadoID;
    private String EmpleadoNombre;
    private String EmpleadoApellido;
    private Date EmpleadoFechaNacimiento;
    private Double EmpleadoSalario;

}
