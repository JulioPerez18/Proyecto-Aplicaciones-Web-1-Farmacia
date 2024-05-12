package proyecto.edu.pe.proyecto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import proyecto.edu.pe.proyecto.entity.Medicamento;

public interface MedicamentoDAO extends CrudRepository<Medicamento, Integer> {
    @Query("Select m from Medicamento m where m.precio > ?1")
    Iterable<Medicamento> getMedicamentoporPrecio(double precio);
}
