package Interfaces;
import System.Usuario;

public interface LoginInterface {
    boolean autenticar(String nome, String senha);
    String getNivelAcesso(String nome);
}
