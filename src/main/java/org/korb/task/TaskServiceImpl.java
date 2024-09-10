package org.korb.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.korb.cliente.Cliente;
import org.korb.cliente.ClienteRepository;
import org.korb.usuario.Usuario;
import org.korb.usuario.UsuarioRepository;

import java.util.Set;

@ApplicationScoped
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final ClienteRepository clienteRepository;

    private final UsuarioRepository usuarioRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
        this.taskRepository = taskRepository;
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public void create(TaskInputResource taskInputResource) throws Exception {
        var clienteEncontrado = clienteRepository.findById(taskInputResource.idCliente());
        var usuarioEncontrado = usuarioRepository.findById(taskInputResource.idUsuario());
        validateInputFields(clienteEncontrado, usuarioEncontrado);
        var task = new TaskInputDto(taskInputResource.descricao(), taskInputResource.dataInicio(), taskInputResource.dataFim(), clienteEncontrado, usuarioEncontrado);
        taskRepository.create(task);
    }

    @Override
    public Set<Task> findByUsuarioId(Long idUsuario) {
        return taskRepository.findByUsuarioId(idUsuario);
    }

    private void validateInputFields(Cliente cliente, Usuario usuario) throws Exception {
        if (cliente == null) {
            throw new NotFoundException(String.format("Cliente %d não encontrado. Favor informe o cliente da task.", cliente.getId()));
        }
        if (usuario == null) {
            throw new NotFoundException(String.format("Usuario %d não encontrado. Favor informe o usuário da task.", usuario.getId()));
        }
    }
}
