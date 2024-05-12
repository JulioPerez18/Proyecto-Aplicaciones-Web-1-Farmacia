package proyecto.edu.pe.proyecto.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.edu.pe.proyecto.DTO.DTOMedicamento;
import proyecto.edu.pe.proyecto.entity.Empleado;
import proyecto.edu.pe.proyecto.entity.Laboratorio;
import proyecto.edu.pe.proyecto.entity.Medicamento;
import proyecto.edu.pe.proyecto.entity.TipoMedicamento;
import proyecto.edu.pe.proyecto.repository.MedicamentoDAO;
import proyecto.edu.pe.proyecto.service.IEmpleado;
import proyecto.edu.pe.proyecto.service.ILaboratorio;
import proyecto.edu.pe.proyecto.service.IMedicamento;
import proyecto.edu.pe.proyecto.service.ITipoMedicamento;

import java.util.List;

@Service
public class MedicamentoImpl implements IMedicamento {


    @Autowired
    MedicamentoDAO dao;
    @Autowired
    ILaboratorio daoLaboratorio;
    @Autowired
    ITipoMedicamento daoTipoMed;

    @Autowired
    IEmpleado daoEmp;
    @Transactional
    @Override
    public Medicamento save(DTOMedicamento dtomedicamento) {

        Laboratorio lab = daoLaboratorio.findbyID(dtomedicamento.getLaboratorio());
        TipoMedicamento tipoMedicamento = daoTipoMed.findbyID(dtomedicamento.getTipomedicamento());

        Medicamento medicamento = Medicamento.builder()
                .nombre(dtomedicamento.getNombre())
                .descripcion(dtomedicamento.getDescripcion())
                .stock(dtomedicamento.getStock())
                .estado(dtomedicamento.getStock())
                .fechaCreacion(dtomedicamento.getFechaCreacion())
                .fechavencimiento(dtomedicamento.getFechavencimiento())
                .precio(dtomedicamento.getPrecio())
                .contenido(dtomedicamento.getContenido())
                .laboratorio(lab)
                .tipoMedicamento(tipoMedicamento)
                .build();

        return dao.save(medicamento);
    }

    @Override
    public Medicamento update(DTOMedicamento dtomedicamento) {
        Laboratorio lab = daoLaboratorio.findbyID(dtomedicamento.getLaboratorio());
        TipoMedicamento tipoMedicamento = daoTipoMed.findbyID(dtomedicamento.getTipomedicamento());

        Empleado empleado = daoEmp.findById(dtomedicamento.getEmpleado());

        Medicamento medicamento = Medicamento.builder()
                .codigo(dtomedicamento.getCodigo())
                .nombre(dtomedicamento.getNombre())
                .descripcion(dtomedicamento.getDescripcion())
                .stock(dtomedicamento.getStock())
                .estado(dtomedicamento.getStock())
                .fechaCreacion(dtomedicamento.getFechaCreacion())
                .fechavencimiento(dtomedicamento.getFechavencimiento())
                .precio(dtomedicamento.getPrecio())
                .contenido(dtomedicamento.getContenido())
                .laboratorio(lab)
                .tipoMedicamento(tipoMedicamento)
                .empleados(List.of(empleado))
                .build();

        return dao.save(medicamento);
    }

    @Override
    public Medicamento findbyID(Integer id) {

        return dao.findById(id).orElse(null);
    }

    @Override
    public void delete(Medicamento medicamento) {
        dao.delete(medicamento);
    }

    @Override
    public Iterable<Medicamento> findAll() {
        Iterable<Medicamento> medicamentos = dao.findAll();
        return medicamentos;
    }

    @Override
    public Iterable<Medicamento> findByPrecioMayora(double precio) {
        return dao.getMedicamentoporPrecio(precio);
    }

}
