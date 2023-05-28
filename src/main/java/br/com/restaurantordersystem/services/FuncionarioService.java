package br.com.restaurantordersystem.services;

import br.com.restaurantordersystem.models.Funcionario;
import br.com.restaurantordersystem.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
            funcionario.get().setSenha(funcionarioAux.getSenha());
            funcionario.get().setCargo(funcionarioAux.getCargo());
            return funcionarioRepository.save(funcionario.get());
    }

    public boolean existe(String cpf) {
        return !funcionarioRepository.existsById(cpf);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> bucarPorId(String cpf) {
        return funcionarioRepository.findById(cpf);
    }

    public void deletar(String cpf) {
        funcionarioRepository.deleteById(cpf);
    }
}
