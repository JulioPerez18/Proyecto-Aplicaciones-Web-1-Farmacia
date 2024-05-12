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
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EmpleadoID;
    private String EmpleadoNombre;
    private String EmpleadoApellido;
    private Date EmpleadoFechaNacimiento;
    private Double EmpleadoSalario;

    @JsonIgnore
    @ManyToMany(mappedBy = "empleados")
    private List<Medicamento> medicamentos;

}