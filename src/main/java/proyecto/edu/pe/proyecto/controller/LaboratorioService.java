package proyecto.edu.pe.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.edu.pe.proyecto.DTO.DTOLaboratorio;
import proyecto.edu.pe.proyecto.DTO.DTOMedicamento;
import proyecto.edu.pe.proyecto.entity.Laboratorio;
import proyecto.edu.pe.proyecto.entity.Medicamento;
import proyecto.edu.pe.proyecto.repository.LaboratorioDAO;
import proyecto.edu.pe.proyecto.response.CreateLaboratorioResponse;
import proyecto.edu.pe.proyecto.response.CreateMedicamentoResponse;
import proyecto.edu.pe.proyecto.response.FindLaboratorioResponse;
import proyecto.edu.pe.proyecto.service.ILaboratorio;
import proyecto.edu.pe.proyecto.service.IMedicamento;

import java.util.List;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioService {

    @Autowired
    ILaboratorio daoLaboratorio;

    @GetMapping("/find/{id}")
    public FindLaboratorioResponse findLaboratorio(@PathVariable Integer id){
        Laboratorio laboratorio = daoLaboratorio.findbyID(id);

        if (laboratorio == null){
            return new FindLaboratorioResponse("99", "error",null);
        }

        return  new FindLaboratorioResponse("01",null, laboratorio);
    }

    @PostMapping("add")
    public CreateLaboratorioResponse InsertarMedicamento(@RequestBody DTOLaboratorio dtoLaboratorio)
    {
        if(dtoLaboratorio.getLaboratorio_Codigo() == 0) {
            Laboratorio laboratorio = daoLaboratorio.save(dtoLaboratorio);
            return new CreateLaboratorioResponse("01","Medicamento " + laboratorio.getLaboratorio_Nombre() + " añadido");
        }
        else {
            return new CreateLaboratorioResponse("99","El parametro ID no esta permitido");
        }
    }


}
