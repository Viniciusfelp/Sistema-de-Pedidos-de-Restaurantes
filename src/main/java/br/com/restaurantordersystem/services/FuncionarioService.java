package br.com.restaurantordersystem.services;

import br.com.restaurantordersystem.models.funcionario.Funcionario;
import br.com.restaurantordersystem.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario criar(Funcionario funcionarioAux) {
        return funcionarioRepository.save(funcionarioAux);
    }

    public Funcionario atualizar(String cpf, Funcionario funcionarioAux) {
        var funcionario = funcionarioRepository.findById(cpf);
            funcionario.get().setCpf(funcionarioAux.getCpf());
            funcionario.get().setNome(funcionarioAux.getNome());
            funcionario.get().setEmail(funcionarioAux.getEmail());
            funcionario.get().setCargo(funcionarioAux.getCargo());
            return funcionarioRepository.save(funcionario.get());
    }

    public boolean existe(String cpf) {
        return !funcionarioRepository.existsById(cpf);
    }

    public Page<Funcionario> findAll(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }

    public Optional<Funcionario> bucarPorId(String cpf) {
        return funcionarioRepository.findById(cpf);
    }

    public void deletar(String cpf) {
        funcionarioRepository.deleteById(cpf);
    }
}
