package System;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Carlos Eduardo
 */
public class GerenciadorDados implements ClienteInterface {
    private static GerenciadorDados instance = new GerenciadorDados();
    
    private GerenciadorDados() {}

    public static GerenciadorDados getInstance() {
        return instance;

    }

    public void adicionarProdutos(Produtos produto) {
        String sql = "INSERT INTO Produtos (nome, utilidade, valor, status) VALUES (?,?,?,?)";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getUtilidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setString(4, produto.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    public void marcarComoVendido(int idProduto) {
        String sql = "UPDATE Produtos SET status = 'Vendido' WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao vender: " + e.getMessage());
        }
    }

    public void removerCliente(int IdCliente) {
        String sql = "DELETE FROM Clientes WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, IdCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    public List<Produtos> buscarProdutos(String termo) {
        List<Produtos> produtos = new ArrayList<>();
        termo = termo.toLowerCase();
        for (Produtos p : produtos) {
            if (p.getNome().toLowerCase().contains(termo) || p.getUtilidade().toLowerCase().contains(termo)) {
                produtos.add(p);
            }
        }
        return produtos;
    }

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (nome, cpf, telefone, email) VALUES(?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getText().trim());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Clientes SET nome = ?, cliente = ?, telefone = ?, email = ?";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getText().trim());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public List<Produtos> listarProdutosVendidos() {
        List<Produtos> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produtos WHERE status = 'Vendido'";
        try (Connection conn = ConexaoBD.getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                produtos.add(new Produtos(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("utilidade"),
                        rs.getDouble("valor"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos vendidos: " + e.getMessage());
        }
        return produtos;
    }

    public void excluirProduto(int idProduto) {
        String sql = "DELETE FROM Produtos WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
        }
    }

    public List<Cliente> pesquisarClientes(String cpf) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "SELECT * FROM Clientes WHERE cpf LIKE ?";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + cpf + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar Cliente: " + e.getMessage());
        }
        return clientes;
    }

    public List<Produtos> listarProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produtos";
        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                produtos.add(new Produtos(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("utilidade"),
                        rs.getDouble("valor"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }
    
    public void registrarVenda(Venda venda){
        String sql = "INSERT INTO Vendas (id_P, id_C, data) VALUES (?, ?, ?) ";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, venda.getIdP());
            if (venda.getIdC() != null){
                stmt.setInt(2, venda.getIdC());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }
            stmt.setTimestamp(3, Timestamp.valueOf(venda.getDataVenda()));
            stmt.execute();
        }catch (SQLException e){
            System.err.println("Erro ao registrar venda: "+ e.getMessage());
        }
    }

}
