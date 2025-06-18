package dao;

import model.Equipamento;
import util.ConexaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {

    public void cadastrar(Equipamento eq) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "INSERT INTO equipamentos (nome, fabricante, data_aquisicao, localizacao) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, eq.getNome());
        ps.setString(2, eq.getFabricante());
        ps.setDate(3, new java.sql.Date(eq.getDataAquisicao().getTime()));
        ps.setString(4, eq.getLocalizacao());
        ps.executeUpdate();
        con.close();
    }

    public List<Equipamento> listar() throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "SELECT * FROM equipamentos";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Equipamento> lista = new ArrayList<>();
        while (rs.next()) {
            Equipamento eq = new Equipamento(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("fabricante"),
                    rs.getDate("data_aquisicao"),
                    rs.getString("localizacao")
            );
            lista.add(eq);
        }
        con.close();
        return lista;
    }

    public void editar(Equipamento eq) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "UPDATE equipamentos SET nome = ?, fabricante = ?, data_aquisicao = ?, localizacao = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, eq.getNome());
        ps.setString(2, eq.getFabricante());
        ps.setDate(3, new java.sql.Date(eq.getDataAquisicao().getTime()));
        ps.setString(4, eq.getLocalizacao());
        ps.setInt(5, eq.getId());
        ps.executeUpdate();
        con.close();
    }

    public void excluir(int id) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "DELETE FROM equipamentos WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
