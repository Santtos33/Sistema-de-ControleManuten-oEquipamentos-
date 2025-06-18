package dao;

import model.Manutencao;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManutencaoDAOTest {
    private ManutencaoDAO manutencaoDAO;

    @BeforeEach
    public void setUp() {
        manutencaoDAO = new ManutencaoDAO();
    }

    @Test
    public void testCadastrarManutencao() throws Exception {
        Manutencao m = new Manutencao(0, "preventiva", "Troca de óleo", new java.util.Date(), 1);
        manutencaoDAO.cadastrar(m);
        List<Manutencao> manutencoes = manutencaoDAO.listarPorEquipamento(1);
        assertTrue(manutencoes.size() > 0);
    }

    @Test
    public void testEditarManutencao() throws Exception {
        Manutencao m = new Manutencao(1, "preventiva", "Troca de óleo", new java.util.Date(), 1);
        manutencaoDAO.cadastrar(m);
        m.setDescricao("Troca de óleo editada");
        manutencaoDAO.editar(m);
        Manutencao manutencaoEditada = manutencaoDAO.listarPorEquipamento(1).get(0);
        assertEquals("Troca de óleo editada", manutencaoEditada.getDescricao());
    }

    @Test
    public void testExcluirManutencao() throws Exception {
        Manutencao m = new Manutencao(0, "preventiva", "Troca de óleo", new java.util.Date(), 1);
        manutencaoDAO.cadastrar(m);
        List<Manutencao> manutencoesAntes = manutencaoDAO.listarPorEquipamento(1);
        assertTrue(manutencoesAntes.size() > 0);
        manutencaoDAO.excluir(manutencoesAntes.get(0).getId());
        List<Manutencao> manutencoesDepois = manutencaoDAO.listarPorEquipamento(1);
        assertEquals(manutencoesAntes.size() - 1, manutencoesDepois.size());
    }

    @Test
    public void testListarManutencoesPorEquipamento() throws Exception {
        List<Manutencao> manutencoes = manutencaoDAO.listarPorEquipamento(1);
        assertNotNull(manutencoes);
    }
}
