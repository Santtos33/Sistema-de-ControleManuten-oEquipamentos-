package controller;

import dao.EquipamentoDAO;
import model.Equipamento;
import java.util.List;

public class EquipamentoController {
    private EquipamentoDAO dao = new EquipamentoDAO();

    public void cadastrarEquipamento(Equipamento eq) throws Exception {
        dao.cadastrar(eq);
    }

    public List<Equipamento> listarEquipamentos() throws Exception {
        return dao.listar();
    }
}
