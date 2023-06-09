package br.com.restaurantordersystem.models.funcionario;

public record DetalhamentoFuncionarioRecord(String nome, String email, String cargo) {
    public DetalhamentoFuncionarioRecord(Funcionario funcionario) {
        this(funcionario.getNome(), funcionario.getEmail(), funcionario.getCargo());
    }
}
