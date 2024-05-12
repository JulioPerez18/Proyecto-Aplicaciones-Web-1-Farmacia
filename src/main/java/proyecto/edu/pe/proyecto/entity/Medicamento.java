package proyecto.edu.pe.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;
    private String descripcion;
    private int stock;
    private Date fechaCreacion;
    private Date fechavencimiento;
    private Double precio;
    private int estado;
    private String contenido;

    @ManyToOne()
    @JoinColumn(name = "Laboratorio", nullable = false)
    Laboratorio laboratorio;

    @ManyToOne()
    @JoinColumn(name = "Tipo_Medicamento", nullable = false)
    TipoMedicamento tipoMedicamento;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "medicamentoempleado",
            joinColumns = @JoinColumn(name = "codigo", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "EmpleadoID", nullable = false)
    )
    private List<Empleado> empleados;

}
