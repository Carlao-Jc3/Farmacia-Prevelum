package System;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Carlos Eduardo
 */
public class GerenciadorDados {

    private static GerenciadorDados instance = new GerenciadorDados();
    private List<Produtos> produtos;
    private List<Cliente> clientes;
    private static int proximoIdProduto = 1;
    private static int proximoIdCliente = 1;

    private GerenciadorDados() {
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public static GerenciadorDados getInstance() {
        return instance;

    }

    public void adicionarProdutos(Produtos produto) {
        produto.setId(proximoIdProduto++);
        produto.setStatus("A venda");
        produtos.add(produto);
    }

    public void marcarComoVendido(int idProduto) {
        for (Produtos p : produtos) {
            if (p.getId() == idProduto) {
                p.setStatus("Vendido");
                break;
            }
        }
    }

    public void excluirProduto(int idProduto) {
        produtos.removeIf(produto -> produto.getId() == idProduto);
    }

    public List<Produtos> buscarProdutos(String termo) {
        List<Produtos> resultados = new ArrayList<>();
        termo = termo.toLowerCase();
        for (Produtos p : produtos) {
            if (p.getNome().toLowerCase().contains(termo) || p.getUtilidade().toLowerCase().contains(termo)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public void cadastrarCliente(Cliente cliente) {
        cliente.setId(proximoIdCliente++);
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public void atualizarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                break;
            }
        }
    }
    public List<Produtos> listarProdutosVendidos() {
    List<Produtos> vendidos = new ArrayList<>();
    for (Produtos p : produtos) {
        if ("Vendido".equals(p.getStatus())) {
            vendidos.add(p);
        }
    }
    return vendidos;
}

    public void removerCliente(int idCliente) {
        clientes.removeIf(cliente -> cliente.getId() == idCliente);
    }

    public List<Cliente> pesquisarClientes(String cpf) {
        List<Cliente> resultados = new ArrayList<>();
        cpf = cpf.toLowerCase();
        for (Cliente c : clientes) {
            if (c.getCpf().toLowerCase().contains(cpf)) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public List<Produtos> listarProdutos() {
        return new ArrayList<>(produtos);
    }

}
