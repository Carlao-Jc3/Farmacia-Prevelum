package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Eduardo
 */
public class conectaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/prevelum";
    private static final String USUARIO = "root";
    private static final String SENHA = "CAmysql2025DU";
    private static Connection conexao = null;

    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (SQLException e) {
                throw new SQLException("Erro ao conectar ao banco: " + e.getMessage());
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
