package padroes.memento;

/**
 * Interface que representa o Estado de uma Conta Bancária.
 * Padrão Memento: cada estado é salvo no histórico da conta.
 */
public interface ContaEstado {

    String getNomeEstado();

    String getDescricao();

}
