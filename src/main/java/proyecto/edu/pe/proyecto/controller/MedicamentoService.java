package proyecto.edu.pe.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import proyecto.edu.pe.proyecto.DTO.DTOMedicamento;
import proyecto.edu.pe.proyecto.entity.Laboratorio;
import proyecto.edu.pe.proyecto.entity.Medicamento;
import proyecto.edu.pe.proyecto.response.*;
import proyecto.edu.pe.proyecto.service.IMedicamento;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoService {

    @Autowired
    IMedicamento dao;

    @PostMapping("add")
    public CreateMedicamentoResponse InsertarMedicamento(@RequestBody DTOMedicamento dtomedicamento)
    {
        if(dtomedicamento.getCodigo() == 0) {
            Medicamento newmed = dao.save(dtomedicamento);
            return new CreateMedicamentoResponse("01","Medicamento " + newmed.getNombre() + " añadido");
        }
        else {
            return new CreateMedicamentoResponse("99","El parametro ID no esta permitido");
        }
    }

    @GetMapping("/find/{id}")
    public FindMedicamentoResponse findMedicamento(@PathVariable Integer id){
        Medicamento medicamento = dao.findbyID(id);

        if (medicamento == null){
            return new FindMedicamentoResponse("99", "error",null);
        }

        return  new FindMedicamentoResponse("01",null, medicamento);
    }

    @GetMapping("/medicamentos")
    public FindMedicamentosResponse findMedicamentos(){
        Iterable<Medicamento> medicamentos = dao.findAll();

        return  new FindMedicamentosResponse("01",null, medicamentos);
    }

    @PutMapping("modificar")
    public UpdateMedicamentoResponse updateMedicamento(@RequestBody DTOMedicamento dtomedicamento)
    {
        Medicamento med;
        if (dao.findbyID(dtomedicamento.getCodigo()) == null) {
            return new UpdateMedicamentoResponse("01", "Error");
        }

        med = dao.update(dtomedicamento);
        return new UpdateMedicamentoResponse("01", "Medicamento " + med.getNombre() + dtomedicamento.getEmpleado() + " fue modificado");
    }

    @DeleteMapping("eliminar/{id}")
    public DeleteMedicoResponse deleteMedicamento(@PathVariable int id)
    {
        try{
            Medicamento med = dao.findbyID(id);
            dao.delete(med);
            return new DeleteMedicoResponse("01", med.getNombre()+" eliminado");
        }catch (DataAccessException ex){
            return new DeleteMedicoResponse("99", "Error al querer eliminar");
        }
    }

    @GetMapping("preciomayora/{precio}")
    public FindMedicamentosResponse findMedicamentoPrecioMayora(){
        Iterable<Medicamento> medicamentos = dao.findAll();

        return  new FindMedicamentosResponse("01",null, medicamentos);
    }

    @GetMapping("/medicamentosprecio/{precio}")
    public FindMedicamentosResponse findMedicamentosByPrecio(@PathVariable double precio){
        Iterable<Medicamento> medicamentos = dao.findByPrecioMayora(precio);

        if (medicamentos == null)
        {
            return  new FindMedicamentosResponse("90","No se encontraron registros en Medicamentos", null);
        }

        return  new FindMedicamentosResponse("01",null, medicamentos);
    }


}
