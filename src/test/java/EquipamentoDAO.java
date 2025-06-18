package dao;

import model.Equipamento;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EquipamentoDAOTest {
    private EquipamentoDAO equipamentoDAO;

    @BeforeEach
    public void setUp() {
        equipamentoDAO = new EquipamentoDAO();
    }

    @Test
    public void testCadastrarEquipamento() throws Exception {
        Equipamento eq = new Equipamento(0, "Bomba", "Fabricante A", new java.util.Date(), "Local 1");
        equipamentoDAO.cadastrar(eq);
        List<Equipamento> equipamentos = equipamentoDAO.listar();
        assertTrue(equipamentos.size() > 0);
    }

    @Test
    public void testEditarEquipamento() throws Exception {
        Equipamento eq = new Equipamento(1, "Bomba", "Fabricante A", new java.util.Date(), "Local 1");
        equipamentoDAO.cadastrar(eq);
        eq.setNome("Bomba Editada");
        equipamentoDAO.editar(eq);
        Equipamento equipamentoEditado = equipamentoDAO.listar().get(0);
        assertEquals("Bomba Editada", equipamentoEditado.getNome());
    }

    @Test
    public void testExcluirEquipamento() throws Exception {
        Equipamento eq = new Equipamento(0, "Bomba", "Fabricante A", new java.util.Date(), "Local 1");
        equipamentoDAO.cadastrar(eq);
        List<Equipamento> equipamentosAntes = equipamentoDAO.listar();
        assertTrue(equipamentosAntes.size() > 0);
        equipamentoDAO.excluir(equipamentosAntes.get(0).getId());
        List<Equipamento> equipamentosDepois = equipamentoDAO.listar();
        assertEquals(equipamentosAntes.size() - 1, equipamentosDepois.size());
    }

    @Test
    public void testListarEquipamentos() throws Exception {
        List<Equipamento> equipamentos = equipamentoDAO.listar();
        assertNotNull(equipamentos);
    }
}
