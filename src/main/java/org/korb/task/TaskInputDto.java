package org.korb.task;

import org.korb.cliente.Cliente;
import org.korb.usuario.Usuario;

import java.time.LocalDateTime;

public record TaskInputDto(String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, Cliente cliente,
                           Usuario usuario
) {

    public Task convertToEntity() {
        return new Task(descricao(), dataInicio(), dataFim(), cliente(), usuario());
    }
}
