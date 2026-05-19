package padroes.memento;


public class ContaEstadoNegativa implements ContaEstado {

    private ContaEstadoNegativa() {}

    private static final ContaEstadoNegativa INSTANCE = new ContaEstadoNegativa();

    public static ContaEstadoNegativa getInstance() {
        return INSTANCE;
    }

    @Override
    public String getNomeEstado() {
        return "Negativa";
    }

    @Override
    public String getDescricao() {
        return "Conta negativa: saldo devedor, juros aplicáveis.";
    }
}
