package padroes.memento;

/**
 * Estado: Conta Encerrada — conta encerrada pelo titular ou pelo banco.
 */
public class ContaEstadoEncerrada implements ContaEstado {

    private ContaEstadoEncerrada() {}

    private static final ContaEstadoEncerrada INSTANCE = new ContaEstadoEncerrada();

    public static ContaEstadoEncerrada getInstance() {
        return INSTANCE;
    }

    @Override
    public String getNomeEstado() {
        return "Encerrada";
    }

    @Override
    public String getDescricao() {
        return "Conta encerrada: não é possível realizar operações.";
    }
}
