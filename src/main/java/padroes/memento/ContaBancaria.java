package padroes.memento;

import java.util.ArrayList;
import java.util.List;


public class ContaBancaria {

    private String numeroConta;
    private String titular;
    private ContaEstado estadoAtual;
    private List<ContaEstado> historicoEstados = new ArrayList<>();

    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
    }

    // ---------------------------------------------------------------
    // Getters informativos
    // ---------------------------------------------------------------

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public ContaEstado getEstado() {
        return estadoAtual;
    }

    public List<ContaEstado> getHistoricoEstados() {
        return historicoEstados;
    }

    // ---------------------------------------------------------------
    // Operações do Memento
    // ---------------------------------------------------------------

    /**
     * Define o novo estado da conta e o registra no histórico (memento).
     */
    public void setEstado(ContaEstado estado) {
        this.estadoAtual = estado;
        this.historicoEstados.add(estado);
    }

    /**
     * Restaura o estado de um índice específico do histórico.
     *
     * @param indice posição no histórico (0-based)
     * @throws IllegalArgumentException se o índice for inválido
     */
    public void restauraEstado(int indice) {
        if (indice < 0 || indice > historicoEstados.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estadoAtual = historicoEstados.get(indice);
    }
}
