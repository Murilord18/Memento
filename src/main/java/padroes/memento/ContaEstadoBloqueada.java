package padroes.memento;


public class ContaEstadoBloqueada implements ContaEstado {

    private ContaEstadoBloqueada() {}

    private static final ContaEstadoBloqueada INSTANCE = new ContaEstadoBloqueada();

    public static ContaEstadoBloqueada getInstance() {
        return INSTANCE;
    }

    @Override
    public String getNomeEstado() {
        return "Bloqueada";
    }

    @Override
    public String getDescricao() {
        return "Conta bloqueada: nenhuma movimentação permitida.";
    }
}
