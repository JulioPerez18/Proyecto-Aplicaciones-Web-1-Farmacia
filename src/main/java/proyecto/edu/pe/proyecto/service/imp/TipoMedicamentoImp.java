package proyecto.edu.pe.proyecto.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.edu.pe.proyecto.DTO.DTOTipoMedicamento;
import proyecto.edu.pe.proyecto.entity.Medicamento;
import proyecto.edu.pe.proyecto.entity.TipoMedicamento;
import proyecto.edu.pe.proyecto.repository.TipoMedicamentoDAO;
import proyecto.edu.pe.proyecto.service.ITipoMedicamento;

@Service
public class TipoMedicamentoImp implements ITipoMedicamento {

    @Autowired
    TipoMedicamentoDAO dao;

    @Transactional(readOnly = true)
    @Override
    public TipoMedicamento findbyID(Integer id) {
        return dao.findById(id).orElse(null);
    }

    public TipoMedicamento save(DTOTipoMedicamento dtoTipoMedicamento){

        TipoMedicamento tipomedicamento =
                TipoMedicamento.builder()
                        .TM_Estado(dtoTipoMedicamento.getTM_Estado())
                        .TM_Nombre(dtoTipoMedicamento.getTM_Nombre())
                        .TM_Descripcion(dtoTipoMedicamento.getTM_Descripcion())
                        .build();

        return dao.save(tipomedicamento);

    }
}