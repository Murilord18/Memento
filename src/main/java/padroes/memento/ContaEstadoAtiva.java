package padroes.memento;


public class ContaEstadoAtiva implements ContaEstado {

    private ContaEstadoAtiva() {}

    private static final ContaEstadoAtiva INSTANCE = new ContaEstadoAtiva();

    public static ContaEstadoAtiva getInstance() {
        return INSTANCE;
    }

    @Override
    public String getNomeEstado() {
        return "Ativa";
    }

    @Override
    public String getDescricao() {
        return "Conta ativa: depósitos, saques e transferências permitidos.";
    }
}
