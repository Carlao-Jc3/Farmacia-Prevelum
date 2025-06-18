package System;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginService implements LoginInterface {
    @Override
    public boolean autenticar(String usuario, String senha){
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND senha =? ";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }
    
    public String getNivelAcesso(String usuario){
        String sql =  "SELECT nivel_acesso FROM Usuarios WHERE Usuario = ? ";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return rs.getString("nivel_acesso");
            }
        }catch (SQLException e){
            System.err.println("Erro ao obter nível de acesso: " + e.getMessage());
        }
        return null;        
    }
}
