package dao;

import model.Usuario;
import util.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public void cadastrar(Usuario usuario) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha()); // Em produção, use hash!
        ps.executeUpdate();
        con.close();
    }

    public Usuario autenticar(String login, String senha) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha); // Em produção, use hash!
        ResultSet rs = ps.executeQuery();
        Usuario usuario = null;
        if (rs.next()) {
            usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("login"),
                    rs.getString("senha")
            );
        }
        con.close();
        return usuario;
    }

    public void editar(Usuario usuario) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha()); // Em produção, use hash!
        ps.setInt(4, usuario.getId());
        ps.executeUpdate();
        con.close();
    }

    public void excluir(int id) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
