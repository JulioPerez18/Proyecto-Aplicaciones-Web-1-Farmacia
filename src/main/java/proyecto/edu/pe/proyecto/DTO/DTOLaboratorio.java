package proyecto.edu.pe.proyecto.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class DTOLaboratorio {
    private int Laboratorio_Codigo;
    private String Laboratorio_Nombre;
    private String  Laboratorio_Descripcion;
    private String  Laboratorio_Ubicacion;
    private String Laboratorio_Estado;

}
