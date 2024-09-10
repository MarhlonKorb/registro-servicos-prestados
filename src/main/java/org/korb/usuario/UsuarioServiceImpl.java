package org.korb.usuario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public void create(UsuarioInputResouce usuarioInputResouce) {
        validateInputFields(usuarioInputResouce.email(), usuarioInputResouce.nome());
        usuarioRepository.persist(usuarioInputResouce.convertToEntity());
    }

    private void validateInputFields(String email, String nome) {
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("Email não pode ser vazio");
        }
        if (nome == null || nome.isEmpty()) {
            throw new RuntimeException("Nome não pode ser vazio");
        }
    }
}
