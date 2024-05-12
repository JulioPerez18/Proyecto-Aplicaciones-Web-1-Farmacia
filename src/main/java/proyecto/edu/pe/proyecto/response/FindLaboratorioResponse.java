package proyecto.edu.pe.proyecto.response;

import proyecto.edu.pe.proyecto.entity.Laboratorio;

public record FindLaboratorioResponse(String code, String error, Laboratorio laboratorio) {
}
