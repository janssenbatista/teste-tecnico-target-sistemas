// 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores
// anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde,
// informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado
// pertence ou não a sequência.

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um número:");
        int n = sc.nextInt();
        int[] sequence = calculateFibonacci(n);
        System.out.println(verifyNumber(n, sequence) ? "O número digitado pertence a sequência." : "O número digitado não pertence a sequência.");
    }

    private static int[] calculateFibonacci(int n) {
        int[] sequence = new int[n + 1];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }

    private static boolean verifyNumber(int n, int[] sequence) {
        boolean belongs = false;
        for (int j : sequence) {
            if (j == n) {
                belongs = true;
                break;
            }
        }
        return belongs;
    }
}
