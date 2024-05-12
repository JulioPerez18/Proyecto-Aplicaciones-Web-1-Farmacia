package proyecto.edu.pe.proyecto.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class DTOTipoMedicamento {
    private int TM_Codigo;
    private String TM_Nombre;
    private String TM_Descripcion;
    private int TM_Estado;
}
