package proyecto.edu.pe.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "tipomedicamento")
public class TipoMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TM_Codigo;
    private String TM_Nombre;
    private String TM_Descripcion;
    private int TM_Estado;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoMedicamento")
    List<Medicamento> medicamentos;
}
