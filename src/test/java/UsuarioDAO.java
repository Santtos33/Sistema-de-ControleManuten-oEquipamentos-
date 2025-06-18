package dao;

import model.Usuario;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioDAOTest {
    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void testCadastrarUsuario() throws Exception {
        Usuario usuario = new Usuario(0, "João", "joao123", "senha123");
        usuarioDAO.cadastrar(usuario);
        Usuario usuarioAutenticado = usuarioDAO.autenticar("joao123", "senha123");
        assertNotNull(usuarioAutenticado);
    }

    @Test
    public void testEditarUsuario() throws Exception {
        Usuario usuario = new Usuario(1, "João", "joao123", "senha123");
        usuarioDAO.cadastrar(usuario);
        usuario.setNome("João Editado");
        usuarioDAO.editar(usuario);
        Usuario usuarioEditado = usuarioDAO.autenticar("joao123", "senha123");
        assertEquals("João Editado", usuarioEditado.getNome());
    }

    @Test
    public void testExcluirUsuario() throws Exception {
        Usuario usuario = new Usuario(0, "João", "joao123", "senha123");
        usuarioDAO.cadastrar(usuario);
        usuarioDAO.excluir(1); // Supondo que o id do usuário é 1
        Usuario usuarioAutenticado = usuarioDAO.autenticar("joao123", "senha123");
        assertNull(usuarioAutenticado);
    }

    @Test
    public void testAutenticarUsuario() throws Exception {
        Usuario usuario = new Usuario(0, "João", "joao123", "senha123");
        usuarioDAO.cadastrar(usuario);
        Usuario usuarioAutenticado = usuarioDAO.autenticar("joao123", "senha123");
        assertNotNull(usuarioAutenticado);
    }
}
