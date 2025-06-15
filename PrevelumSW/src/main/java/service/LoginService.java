package service;
import System.Usuario;
import Interfaces.LoginInterface;
import java.util.ArrayList;
import java.util.List;

public class LoginService implements LoginInterface {
    private List<Usuario> usuarios;
    
    public LoginService(){
        usuarios = new ArrayList<>();
        // Usuários pré-cadastrados
        usuarios.add(new Usuario("adm", "adm123"));
        usuarios.add(new Usuario("operador", "op123"));
        usuarios.add(new Usuario("aprendiz", "apr123"));
    }
    
    @Override
    public boolean autenticar(String nome, String senha){
        for (Usuario u : usuarios){
            if(u.getNome().equals(nome)&& u.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String getNivelAcesso(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        switch(nome){
            case "adm":
                return "Administrador";
            case "operador":
                return "Operador";
            case "aprendiz":
                return "Aprendiz";
            default:
                return null;
        }
    }
}
