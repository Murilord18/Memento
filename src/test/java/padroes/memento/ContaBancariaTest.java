package padroes.memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void setUp() {
        conta = new ContaBancaria("001-2345-6", "João Silva");
    }

    // ------------------------------------------------------------------
    // 1. Armazenar estados no histórico
    // ------------------------------------------------------------------

    @Test
    void deveArmazenarEstados() {
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoBloqueada.getInstance());
        assertEquals(2, conta.getHistoricoEstados().size());
    }

    // ------------------------------------------------------------------
    // 2. Restaurar estado pelo índice 0 (primeiro estado)
    // ------------------------------------------------------------------

    @Test
    void deveRetornarEstadoInicial() {
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoBloqueada.getInstance());
        conta.restauraEstado(0);
        assertEquals(ContaEstadoAtiva.getInstance(), conta.getEstado());
    }

    // ------------------------------------------------------------------
    // 3. Restaurar estado por índice intermediário
    // ------------------------------------------------------------------

    @Test
    void deveRetornarEstadoAnterior() {
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoBloqueada.getInstance());
        conta.setEstado(ContaEstadoNegativa.getInstance());
        conta.setEstado(ContaEstadoEncerrada.getInstance());
        conta.restauraEstado(2);
        assertEquals(ContaEstadoNegativa.getInstance(), conta.getEstado());
    }

    // ------------------------------------------------------------------
    // 4. Lançar exceção para índice inválido
    // ------------------------------------------------------------------

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            conta.restauraEstado(0); // histórico ainda vazio
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    // ------------------------------------------------------------------
    // 5. Estado atual deve refletir o último setEstado
    // ------------------------------------------------------------------

    @Test
    void deveReflectirUltimoEstadoDefinido() {
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoInadimplente.getInstance());
        assertEquals("Inadimplente", conta.getEstado().getNomeEstado());
    }

    // ------------------------------------------------------------------
    // 6. Histórico deve crescer a cada mudança de estado
    // ------------------------------------------------------------------

    @Test
    void deveIncrementarHistoricoACadaMudanca() {
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoSuspensa.getInstance());
        conta.setEstado(ContaEstadoBloqueada.getInstance());
        conta.setEstado(ContaEstadoEncerrada.getInstance());
        assertEquals(4, conta.getHistoricoEstados().size());
    }

    // ------------------------------------------------------------------
    // 7. Restaurar estado não altera o tamanho do histórico
    // ------------------------------------------------------------------

    @Test
    void restaurarEstadoNaoAlteraHistorico() {
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoBloqueada.getInstance());
        conta.setEstado(ContaEstadoNegativa.getInstance());
        int tamanhoAntes = conta.getHistoricoEstados().size();
        conta.restauraEstado(0);
        assertEquals(tamanhoAntes, conta.getHistoricoEstados().size());
    }

    // ------------------------------------------------------------------
    // 8. Índice negativo deve lançar exceção
    // ------------------------------------------------------------------

    @Test
    void deveRetornarExcecaoIndiceNegativo() {
        conta.setEstado(ContaEstadoAtiva.getInstance());
        try {
            conta.restauraEstado(-1);
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    // ------------------------------------------------------------------
    // 9. Singleton — mesma instância para o mesmo estado
    // ------------------------------------------------------------------

    @Test
    void deveUsarMesmaInstanciaDoEstado() {
        assertSame(ContaEstadoAtiva.getInstance(), ContaEstadoAtiva.getInstance());
        assertSame(ContaEstadoEncerrada.getInstance(), ContaEstadoEncerrada.getInstance());
    }

    // ------------------------------------------------------------------
    // 10. Verifica nome e descrição de cada estado
    // ------------------------------------------------------------------

    @Test
    void deveRetornarNomeEDescricaoCorretosDeCadaEstado() {
        assertEquals("Ativa",         ContaEstadoAtiva.getInstance().getNomeEstado());
        assertEquals("Bloqueada",     ContaEstadoBloqueada.getInstance().getNomeEstado());
        assertEquals("Negativa",      ContaEstadoNegativa.getInstance().getNomeEstado());
        assertEquals("Encerrada",     ContaEstadoEncerrada.getInstance().getNomeEstado());
        assertEquals("Inadimplente",  ContaEstadoInadimplente.getInstance().getNomeEstado());
        assertEquals("Suspensa",      ContaEstadoSuspensa.getInstance().getNomeEstado());

        assertNotNull(ContaEstadoAtiva.getInstance().getDescricao());
        assertNotNull(ContaEstadoBloqueada.getInstance().getDescricao());
    }
}
