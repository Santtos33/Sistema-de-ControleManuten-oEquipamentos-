package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario autenticar(String login, String senha) throws Exception {
        return dao.autenticar(login, senha);
    }


}
