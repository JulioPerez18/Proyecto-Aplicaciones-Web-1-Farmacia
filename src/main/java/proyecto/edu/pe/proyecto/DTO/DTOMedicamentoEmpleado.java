package proyecto.edu.pe.proyecto.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class DTOMedicamentoEmpleado {
    private int medico;
    private int empleado;

}
