package System;

import java.util.List;

public interface ClienteInterface {
    void cadastrarCliente(Cliente cliente, String nivelAcesso);
    void atualizarCliente(Cliente cliente, String nivelAcesso);
    void removerClientes(String cpf, String nivelAcesso);
    List<Cliente> pesquisarPorNome(String nomeParcial);
}
