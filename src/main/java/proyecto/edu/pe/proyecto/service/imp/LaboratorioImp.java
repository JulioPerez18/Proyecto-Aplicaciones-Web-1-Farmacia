package proyecto.edu.pe.proyecto.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.edu.pe.proyecto.DTO.DTOLaboratorio;
import proyecto.edu.pe.proyecto.entity.Laboratorio;
import proyecto.edu.pe.proyecto.repository.LaboratorioDAO;
import proyecto.edu.pe.proyecto.service.ILaboratorio;

@Service
public class LaboratorioImp implements ILaboratorio {

    @Autowired
    public LaboratorioDAO dao;

    @Transactional
    @Override
    public Laboratorio save(DTOLaboratorio dtolaboratorio) {

        Laboratorio laboratorio = Laboratorio.builder()
                .Laboratorio_Descripcion(dtolaboratorio.getLaboratorio_Descripcion())
                .Laboratorio_Nombre(dtolaboratorio.getLaboratorio_Nombre())
                .Laboratorio_Ubicacion(dtolaboratorio.getLaboratorio_Ubicacion())
                .Laboratorio_Estado(dtolaboratorio.getLaboratorio_Estado())
                .build();

        return dao.save(laboratorio);
    }

    @Transactional(readOnly = true)
    @Override
    public Laboratorio findbyID(Integer id) {

        return dao.findById(id).orElse(null);
    }

    @Override
    public void delete(Laboratorio laboratorio) {
        dao.delete(laboratorio);
    }
}
