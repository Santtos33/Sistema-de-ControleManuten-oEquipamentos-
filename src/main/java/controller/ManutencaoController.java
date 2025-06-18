package controller;

import dao.ManutencaoDAO;
import model.Manutencao;

import java.util.List;

public class ManutencaoController {
    private ManutencaoDAO dao = new ManutencaoDAO();

    public void cadastrarManutencao(Manutencao m) throws Exception {
        dao.cadastrar(m);
    }

    public List<Manutencao> listarManutencoesPorEquipamento(int equipamentoId) throws Exception {
        return dao.listarPorEquipamento(equipamentoId);
    }

}
