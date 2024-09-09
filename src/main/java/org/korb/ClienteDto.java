package org.korb;

public record ClienteDto(String nome, String email, String telefone){

    static Cliente convertToEntity(ClienteDto clienteDto){
        return new Cliente(clienteDto.nome(), clienteDto.email(), clienteDto.telefone());
    }
}
