package dao;

import model.Manutencao;
import util.ConexaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {

    public void cadastrar(Manutencao m) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "INSERT INTO manutencoes (tipo, descricao, data, equipamento_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, m.getTipo());
        ps.setString(2, m.getDescricao());
        ps.setDate(3, new java.sql.Date(m.getData().getTime()));
        ps.setInt(4, m.getEquipamentoId());
        ps.executeUpdate();
        con.close();
    }

    public List<Manutencao> listarPorEquipamento(int equipamentoId) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "SELECT * FROM manutencoes WHERE equipamento_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, equipamentoId);
        ResultSet rs = ps.executeQuery();
        List<Manutencao> lista = new ArrayList<>();
        while (rs.next()) {
            Manutencao m = new Manutencao(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("descricao"),
                    rs.getDate("data"),
                    rs.getInt("equipamento_id")
            );
            lista.add(m);
        }
        con.close();
        return lista;
    }

    public void editar(Manutencao m) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "UPDATE manutencoes SET tipo = ?, descricao = ?, data = ?, equipamento_id = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, m.getTipo());
        ps.setString(2, m.getDescricao());
        ps.setDate(3, new java.sql.Date(m.getData().getTime()));
        ps.setInt(4, m.getEquipamentoId());
        ps.setInt(5, m.getId());
        ps.executeUpdate();
        con.close();
    }

    public void excluir(int id) throws Exception {
        Connection con = ConexaoUtil.getConnection();
        String sql = "DELETE FROM manutencoes WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
