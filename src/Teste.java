public class Teste {
    public static void main(String[] args) {
        Lista<String> registros = new Deque<>();
        registros.adicionarRegistro("Gremio");
        registros.adicionarRegistro("Eterno");
        registros.adicionarRegistro("Leo Reprovado");
        registros.adicionarRegistro("Matheus fala muito");
        System.out.println(registros);
        System.out.println(registros.obterTamanho());
        System.out.println(registros.obterRegistro(1));
        System.out.println(registros.removerRegistro(1));
        System.out.println(registros);
        registros.inserirNaPosicao("testeAdd", 0);
        System.out.println(registros);
    }
}
