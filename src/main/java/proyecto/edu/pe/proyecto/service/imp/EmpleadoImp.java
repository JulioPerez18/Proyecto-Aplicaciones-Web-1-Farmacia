package proyecto.edu.pe.proyecto.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.edu.pe.proyecto.DTO.DTOEmpleado;
import proyecto.edu.pe.proyecto.entity.Empleado;
import proyecto.edu.pe.proyecto.repository.EmpleadoDAO;
import proyecto.edu.pe.proyecto.service.IEmpleado;

@Service
public class EmpleadoImp implements IEmpleado {

    @Autowired
    public EmpleadoDAO dao;

    @Transactional
    @Override
    public Empleado save(DTOEmpleado dtoEmpleado) {

        Empleado empleado = Empleado.builder()
                .EmpleadoNombre(dtoEmpleado.getEmpleadoNombre())
                .EmpleadoApellido(dtoEmpleado.getEmpleadoApellido())
                .EmpleadoFechaNacimiento(dtoEmpleado.getEmpleadoFechaNacimiento())
                .EmpleadoSalario(dtoEmpleado.getEmpleadoSalario())
                .build();
        return dao.save(empleado);
    }

    @Transactional(readOnly = true)
    @Override
    public Empleado findById(Integer id){

        return dao.findById(id).orElse(null);
    }

    @Override
    public void delete(Empleado empleado){ dao.delete(empleado);}

    @Override
    public Iterable<Empleado> findall() {
        Iterable<Empleado> empleados = dao.findAll();
        return empleados;
    }

}
