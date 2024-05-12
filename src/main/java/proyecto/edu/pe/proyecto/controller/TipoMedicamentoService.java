package proyecto.edu.pe.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.edu.pe.proyecto.DTO.DTOMedicamento;
import proyecto.edu.pe.proyecto.DTO.DTOTipoMedicamento;
import proyecto.edu.pe.proyecto.entity.Medicamento;
import proyecto.edu.pe.proyecto.entity.TipoMedicamento;
import proyecto.edu.pe.proyecto.repository.TipoMedicamentoDAO;
import proyecto.edu.pe.proyecto.response.CreateMedicamentoResponse;
import proyecto.edu.pe.proyecto.response.CreateTipoMedicamentoResponse;
import proyecto.edu.pe.proyecto.service.ITipoMedicamento;

@RestController
@RequestMapping("/tipomedicamento")
public class TipoMedicamentoService {

    @Autowired
    ITipoMedicamento dao;

    @Autowired
    TipoMedicamentoDAO tipoMedicamentoDAO;

    @PostMapping("add")
    public CreateTipoMedicamentoResponse InsertarTipoMedicamento(@RequestBody DTOTipoMedicamento dtoTipoMedicamento)
    {
        if(dtoTipoMedicamento.getTM_Codigo() == 0) {
            TipoMedicamento newtipo = dao.save(dtoTipoMedicamento);
            return new CreateTipoMedicamentoResponse("01","Medicamento " + newtipo.getTM_Nombre() + " añadido");
        }
        else {
            return new CreateTipoMedicamentoResponse("99","El parametro ID no esta permitido");
        }
    }





}
