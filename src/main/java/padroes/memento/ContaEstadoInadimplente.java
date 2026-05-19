package padroes.memento;


public class ContaEstadoInadimplente implements ContaEstado {

    private ContaEstadoInadimplente() {}

    private static final ContaEstadoInadimplente INSTANCE = new ContaEstadoInadimplente();

    public static ContaEstadoInadimplente getInstance() {
        return INSTANCE;
    }

    @Override
    public String getNomeEstado() {
        return "Inadimplente";
    }

    @Override
    public String getDescricao() {
        return "Conta inadimplente: cliente com pagamentos em atraso, crédito suspenso.";
    }
}
