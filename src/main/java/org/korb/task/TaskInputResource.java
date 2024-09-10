package org.korb.task;

import java.time.LocalDateTime;

public record TaskInputResource(String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, Long idCliente, Long idUsuario
                                ) {
}
