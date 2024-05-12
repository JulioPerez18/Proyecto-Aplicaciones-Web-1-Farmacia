package proyecto.edu.pe.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "laboratorio")
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Laboratorio_Codigo;
    private String Laboratorio_Nombre;
    private String  Laboratorio_Descripcion;
    private String  Laboratorio_Ubicacion;
    private String Laboratorio_Estado;

    @JsonIgnore
    @OneToMany(mappedBy = "laboratorio")
    List<Medicamento> medicamentos ;

}
