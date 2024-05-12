package proyecto.edu.pe.proyecto.service;

import proyecto.edu.pe.proyecto.DTO.DTOLaboratorio;
import proyecto.edu.pe.proyecto.entity.Laboratorio;

public interface ILaboratorio {
    Laboratorio save(DTOLaboratorio dtolaboratorio);
    Laboratorio findbyID(Integer id);
    void delete(Laboratorio laboratorio);
}
