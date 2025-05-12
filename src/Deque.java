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
        No<T> atual = cabeca.proximo;
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
        this.cabeca.proximo = cauda;
        this.cauda.anterior = cabeca;
        this.tamanho = 0;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void inserirNaPosicao(T elemento, int posicao) {
        verificarIndice(posicao);
        No<T> novoNo = new No<>(elemento);
        No<T> atual = cabeca.proximo;
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
    public boolean substituirRegistro(T antigo, T novo) {
        No<T> atual = cabeca.proximo;
        while (atual != cauda) {
            if (atual.dado.equals(antigo)) {
                atual.dado = novo;
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

//    @Override
//    public T[] reverterLista() {
//        No<T> atual = cabeca;
//
//        while(atual != null){
//            No<T> noDepois = atual.proximo;
//            atual.proximo = atual.anterior;
//            atual.anterior = noDepois;
//            atual = noDepois;
//        }
//
//        No<T> temp = cabeca;
//        cabeca = cauda;
//        cauda = temp;
//
//        return null;
//    }

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
        return cauda.anterior.dado;
    }

    @Override
    public int obterIndice(Object elemento) {
        No<T> atual = cabeca.proximo;
        int indice = 0;
        while (atual != cauda) {
            if (atual.dado.equals(elemento)) {
                return indice;
            }
            atual = atual.proximo;
            indice++;
        }
        return -1; // Retorna -1 se o elemento não for encontrado
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

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        // Criação de um array genérico do tipo T
        T[] array = (T[]) new Object[tamanho];

        // Declaração das variáveis do loop a partir da cabeça da lista e tamanho 0
        No<T> atual = cabeca;
        int indice = 0;

        while (atual != null) {
            // Copia o elemento atual para o array
            array[indice++] = atual.dado;

            // O Atual vai para o próximo nó
            atual = atual.proximo;
        }
        return array; // Retorna o array preenchido
    }
}
