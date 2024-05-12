package proyecto.edu.pe.proyecto.response;

import proyecto.edu.pe.proyecto.entity.Medicamento;

public record FindMedicamentoResponse(String codigo, String mensaje, Medicamento medicamento) {
}
