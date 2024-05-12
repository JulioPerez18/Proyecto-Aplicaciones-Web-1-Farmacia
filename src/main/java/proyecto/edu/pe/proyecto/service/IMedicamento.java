package proyecto.edu.pe.proyecto.service;

import proyecto.edu.pe.proyecto.DTO.DTOMedicamento;
import proyecto.edu.pe.proyecto.entity.Medicamento;

public interface IMedicamento {

    Medicamento save(DTOMedicamento dtomedicamento);
    Medicamento update(DTOMedicamento dtomedicamento);
    Medicamento findbyID(Integer id);
    void delete(Medicamento medicamento);
    Iterable<Medicamento> findAll();

    Iterable<Medicamento> findByPrecioMayora(double precio);
}
