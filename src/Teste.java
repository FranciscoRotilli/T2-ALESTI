public class Teste {
    public static void main(String[] args) {
        String entrada = "42 64 58 4c 6b 4a 48 61 4b 68 6a 4e 4e 70 56 65 34 4a 6c 61 31 4a 6b 55 7a 67 6b 56 6f 68 44 62 71 64 54 33 39 47 62 79 78 6b 63 30 64 45 55 59 46 54 61 70 39 32 4e 7a 46 46 65 72 56 57 62 33 70 55 63 73 5a 46 57 4d 39 31 51 66 70 6c 65 70 4a 6c 52 4f 68 56 4c 46 42 7a 54 4f 35 47 53 4a 6c 33 54 74 49 6b 5a 6e 46 55 61 6b 4a 48 55 35 48 53 49 64 6b 54 31 63 7a 5a 4c 35 55 56 34 6c 44 57 6a 31 69 61 69 52 6a 59 32 4d 6e 56 61 68 6b 4e 31 68 6a 51 42 5a 6b 4d 6c 4d 58 4c 7a 4e 57 4c 7a 31 47 63 6e 5a 5a 6b 4d 6c 30 32 62 6a 35 43 64 75 56 47 64 75 39 32 59 79 56 32 63 31 56 47 62 6e 39";
        String[] entradaArray = entrada.split(" ");
        Deque<String> dq = new Deque<>();

        // Adiciona elementos no deque
        for (String s : entradaArray) {
            dq.adicionarRegistro(s);
        }

        // Imprime do ultimo até o primeiro
        for (int i = 0; i < dq.obterTamanho(); i++) {
            System.out.print(dq.removerUltimo() + " ");
        }
    }
}