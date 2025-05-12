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

    /**
     * Adiciona um registro ao final do deque.
     * Seleciona o ultimo elemento do deque, salva em uma variável temporária, escreve o novo nó no proximo do anterior,
     * escreve o anterior no anterior do novo nó, a cauda no próximo do novo nó e o anterior da cauda recebe o novo nó.
     *
     * @param dado elemento a ser adicionado
     */
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

    
    /**
     * Obtém um registro em uma posição específica do deque.
     * Verifica se o índice é válido, percorre a lista até a posição desejada
     * e retorna o dado armazenado no nó encontrado.
     *
     * @param posicao posição do elemento a ser obtido
     * @return elemento na posição especificada
     */
    @Override
    public T obterRegistro(int posicao) {
        verificarIndice(posicao);
        No<T> atual = cabeca.proximo;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.dado;
    }

    
    /**
     * Remove um registro em uma posição específica do deque.
     * Verifica se o índice é válido, encontra o nó na posição desejada,
     * ajusta as referências dos nós adjacentes e retorna o dado removido.
     *
     * @param posicao posição do elemento a ser removido
     * @return elemento removido da posição especificada
     */
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

    
    /**
     * Retorna o tamanho atual do deque.
     * Retorna a variável que armazena o número de elementos no deque.
     *
     * @return número de elementos no deque
     */
    @Override
    public int obterTamanho() {
        return tamanho;
    }

    
    /**
     * Remove todos os registros do deque.
     * Redefine as referências da cabeça e cauda para seus estados iniciais
     * e zera o tamanho do deque.
     */
    @Override
    public void limparRegistros() {
        this.cabeca.proximo = cauda;
        this.cauda.anterior = cabeca;
        this.tamanho = 0;
    }

    /**
     * Verifica se o deque está vazio.
     * Retorna verdadeiro se o tamanho for zero, falso caso contrário.
     *
     * @return verdadeiro se o deque estiver vazio, falso caso contrário
     */
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Insere um elemento em uma posição específica do deque.
     * Verifica se o índice é válido, percorre até a posição desejada
     * e ajusta as referências dos nós adjacentes para incluir o novo elemento.
     *
     * @param elemento elemento a ser inserido
     * @param posicao  posição onde o elemento será inserido
     */
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

    /**
     * Substitui a primeira ocorrência de um elemento por outro no deque.
     * Percorre o deque procurando o elemento antigo e, ao encontrá-lo,
     * substitui pelo novo elemento.
     *
     * @param antigo elemento a ser substituído
     * @param novo   elemento que substituirá o antigo
     * @return verdadeiro se a substituição foi realizada, falso caso contrário
     */
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

    /**
     * Remove o último elemento do deque.
     * Verifica se o deque está vazio e, caso não esteja,
     * remove o elemento na última posição.
     *
     * @return o elemento removido ou null se o deque estiver vazio
     */
    @Override
    public T removerUltimo() {
        if(tamanho == 0) return null;
        return removerRegistro(tamanho -1);
    }

    /**
     * Remove o primeiro elemento do deque.
     * Verifica se o deque está vazio e, caso não esteja,
     * remove o elemento na primeira posição.
     *
     * @return o elemento removido ou null se o deque estiver vazio
     */
    @Override
    public T removerPrimeiro() {
        if(tamanho == 0) return null;
        return removerRegistro(0);
    }

    /**
     * Obtém o último elemento do deque sem removê-lo.
     * Retorna o dado armazenado no nó anterior à cauda.
     *
     * @return o último elemento do deque
     */
    @Override
    public T obterUltimoRegistro() {
        return cauda.anterior.dado;
    }

    
    /**
     * Obtém o índice da primeira ocorrência de um elemento no deque.
     * Percorre o deque procurando o elemento especificado e retorna sua posição.
     * Se o elemento não for encontrado, retorna -1.
     *
     * @param elemento elemento a ser procurado no deque
     * @return índice do elemento encontrado ou -1 se não encontrado
     */
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

    
    /**
     * Verifica se um índice está dentro dos limites válidos do deque.
     * Lança uma exceção se o índice for menor que zero ou maior ou igual ao tamanho do deque.
     *
     * @param indice índice a ser verificado
     * @throws IndexOutOfBoundsException se o índice estiver fora dos limites válidos
     */
    private void verificarIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
    }

    /**
     * Retorna uma representação em string do deque.
     * Cria uma string contendo todos os elementos do deque,
     * cada um em uma nova linha com seu respectivo índice.
     *
     * @return string representando o conteúdo do deque
     */
    public String toString() {
        String ret = "";
        for (int i = 0; i < tamanho; i++) {
             ret += "Indice: " + i + " - " + obterRegistro(i) + "\n";
        }
        return ret;
    }


    /**
     * Converte o deque em um array.
     * Cria um novo array do tamanho do deque e transfere todos os elementos,
     * mantendo a ordem em que aparecem no deque.
     *
     * @return array contendo todos os elementos do deque
     */
    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        // Criação de um array genérico do tipo T
        T[] array = (T[]) new Object[tamanho];

        // Declaração das variáveis do loop a partir do primeiro elemento (cabeça + 1) da lista e tamanho 0
        No<T> atual = cabeca.proximo;
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
