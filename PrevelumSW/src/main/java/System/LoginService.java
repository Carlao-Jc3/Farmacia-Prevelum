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
            return rs.next
        }
    }
}
