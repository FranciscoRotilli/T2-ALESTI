public class Deque<T> implements Lista<T>{
    private final No<T> cabeca;
    private final No<T> cauda;
    private int tamanho;

    public Deque() {
        this.cabeca = new No<>(null);
        this.cauda = new No<>(null);
        this.cabeca.proximo = cauda;
        this.cauda.anterior = cabeca;
        this.tamanho = 0;
    }

    @Override
    public void adicionarRegistro(T dado) {
        No<T> novoNo = new No<>(dado);
        No<T> anterior = cauda.anterior;
        anterior.proximo = novoNo;
        novoNo.anterior = anterior;
        novoNo.proximo = cauda;
        cauda.anterior = novoNo;
        tamanho++;
    }

    @Override
    public T obterRegistro(int posicao) {
        verificarIndice(posicao);
        No<T> atual = cabeca;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.dado;
    }

    @Override
    public T removerRegistro(int posicao) {
        verificarIndice(posicao);
        No<T> atual = cabeca.proximo;
        if (posicao == 0) {
            T removido = atual.dado;
            atual.proximo.anterior = cabeca;
            cabeca.proximo = atual.proximo;
            tamanho--;
            return removido;
        }
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
        T aux = atual.proximo.dado;
        atual.proximo.proximo.anterior = atual;
        atual.proximo = atual.proximo.proximo;

        tamanho--;
        return aux;
    }

    @Override
    public int obterTamanho() {
        return tamanho;
    }

    @Override
    public void limparRegistros() {

    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void inserirNaPosicao(T elemento, int posicao) {
        verificarIndice(posicao);
        No<T> novoNo = new No<>(elemento);
        No<T> atual = cauda;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        novoNo.anterior = atual;
        novoNo.proximo = atual.proximo;
        atual.proximo.anterior = novoNo;
        atual.proximo=novoNo;
        tamanho++;
    }

    @Override
    public boolean substituirRegistro(Object antigo, Object novo) {
        return false;
    }

    @Override
    public T[] reverterLista() {
        No<T> atual = cabeca;

        while(atual != null){
            No<T> noDepois = atual.proximo;
            atual.proximo = atual.anterior;
            atual.anterior = noDepois;
            atual = noDepois;
        }

        No<T> temp = cabeca;
        cabeca = cauda;
        cauda = temp;        
        
        return null;
    }

    @Override
    public T removerUltimo() {
        if(tamanho == 0) return null;
        return removerRegistro(tamanho -1);
    }

    @Override
    public T removerPrimeiro() {
        if(tamanho == 0) return null;
        return removerRegistro(0);
    }

    @Override
    public T obterUltimoRegistro() {
        return null;
    }

    @Override
    public int obterIndice(Object elemento) {
        return 0;
    }

    private void verificarIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < tamanho; i++) {
             ret += "Indice: " + i + " - " + obterRegistro(i) + "\n";
        }
        return ret;
    }
}
