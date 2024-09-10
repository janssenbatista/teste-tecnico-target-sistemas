//    1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
//  Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
//  Imprimir(SOMA);
//  Ao final do processamento, qual será o valor da variável SOMA?

public class Test01 {
    public static void main(String[] args) {
        final int INDICE = 13;
        int soma = 0;
        int k = 0;
        while (k < INDICE) {
            k++;
            soma += k;
        }
        System.out.println("O valor final da variável soma é: " + soma);
    }
}
