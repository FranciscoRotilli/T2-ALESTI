import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        Lista<String> registros = new Deque<>();
        registros.adicionarRegistro("Gremio");
        System.out.println(registros.obterTamanho());
        registros.adicionarRegistro("Eterno");
        registros.adicionarRegistro("Leo Reprovado");
        registros.adicionarRegistro("Matheus fala muito");
        System.out.println(registros);

    }
}
