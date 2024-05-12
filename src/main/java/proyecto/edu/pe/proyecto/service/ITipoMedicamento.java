package proyecto.edu.pe.proyecto.service;

import proyecto.edu.pe.proyecto.DTO.DTOTipoMedicamento;
import proyecto.edu.pe.proyecto.entity.Medicamento;
import proyecto.edu.pe.proyecto.entity.TipoMedicamento;

public interface ITipoMedicamento {

    TipoMedicamento findbyID(Integer id);
    TipoMedicamento save(DTOTipoMedicamento dtoTipoMedicamento);
}
