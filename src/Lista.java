public interface Lista<T> {
    void adicionarRegistro(T dado);
    T obterRegistro(int posicao);
    T removerRegistro(int posicao);
    T removerUltimo();
    T removerPrimeiro();
    int obterTamanho();
    void limparRegistros();
    boolean estaVazia();
    void inserirNaPosicao(T elemento, int posicao);
    boolean substituirRegistro(T antigo, T novo);
    T obterUltimoRegistro();
    int obterIndice(T elemento);
    T[] toArray();
}