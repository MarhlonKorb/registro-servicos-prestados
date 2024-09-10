package org.korb.usuario;

public record UsuarioInputResouce(String nome, String email) {

    public Usuario convertToEntity(){
        return new Usuario(nome(), email());
    }
}
