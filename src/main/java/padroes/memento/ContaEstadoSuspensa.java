package padroes.memento;


public class ContaEstadoSuspensa implements ContaEstado {

    private ContaEstadoSuspensa() {}

    private static final ContaEstadoSuspensa INSTANCE = new ContaEstadoSuspensa();

    public static ContaEstadoSuspensa getInstance() {
        return INSTANCE;
    }

    @Override
    public String getNomeEstado() {
        return "Suspensa";
    }

    @Override
    public String getDescricao() {
        return "Conta suspensa: em análise de segurança, aguardando liberação.";
    }
}
