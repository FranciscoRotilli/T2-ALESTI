public class Deque<T> implements Lista<T>{
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanho;

    public Deque() {
        this.cabeca = null;
        this.cauda = null;
        this.cabeca.proximo = cauda;
        this.cauda.anterior = cabeca;
        this.tamanho = 0;
    }

    @Override
    public void adicionarRegistro(T dado) {
        No<T> novoNo = new No<>(dado);
        if (cabeca.proximo == null) {
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
        } else {
            No<T> anterior = cauda.anterior;
            anterior.proximo = novoNo;
            novoNo.anterior = anterior;
        }
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
            cabeca.proximo = atual.proximo;
            tamanho--;
            return removido;
        }
        No<T> anterior = null;
        for (int i = 0; i < posicao; i++) {
            anterior = atual;
            atual = atual.proximo;
        }
        assert anterior != null;
        anterior.proximo = atual.proximo;
        tamanho--;
        return atual.dado;
    }

    @Override
    public int obterTamanho() {
        return 0;
    }

    @Override
    public void limparRegistros() {

    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void inserirNaPosicao(Object elemento, int posicao) {

    }

    @Override
    public boolean substituirRegistro(Object antigo, Object novo) {
        return false;
    }

    @Override
    public T[] reverterLista() {
        return null;
    }

    @Override
    public T removerUltimo() {
        if(tamanho == 0) return null;
        if(tamanho == 1) {
            T aux = cauda.anterior.dado;
            cabeca.proximo = cauda;
            cauda.anterior = cabeca;
            tamanho --;
            return aux;
        }
        T aux = cauda.anterior.dado;
        cauda.anterior.anterior.proximo = cauda;
        cauda.anterior = cauda.anterior.anterior;
        tamanho --;
        return aux;
    }

    @Override
    public T removerPrimeiro() {
        if(tamanho == 0) return null;
        if(tamanho == 1) {
            T aux = cabeca.proximo.dado;
            cabeca.proximo = cauda;
            cauda.anterior = cabeca;
            tamanho --;
            return aux;
        }
        T aux = cabeca.proximo.dado;
        cabeca.proximo.proximo.anterior = cabeca;
        cabeca.proximo = cabeca.proximo.proximo;
        tamanho --;
        return aux;
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
}
