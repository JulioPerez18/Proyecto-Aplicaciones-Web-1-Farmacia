package proyecto.edu.pe.proyecto.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class DTOMedicamento implements Serializable {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int stock;
    private Date fechaCreacion;
    private Date fechavencimiento;
    private Double precio;
    private int estado;
    private String contenido;
    private int laboratorio;
    private int tipomedicamento;
    private int empleado;
}
