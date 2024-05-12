package proyecto.edu.pe.proyecto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Perfil_ID;
    private String Perfil_Nombre;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
    private List<Usuario> usuarios;

}
