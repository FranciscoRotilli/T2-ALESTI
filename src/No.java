public class No<T> {
    T dado;
    No<T> proximo;
    No<T> anterior;

    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}
