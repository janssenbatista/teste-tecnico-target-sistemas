// 5) Escreva um programa que inverta os caracteres de um string.
//
// IMPORTANTE:
// a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
// b) Evite usar funções prontas, como, por exemplo, reverse;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a string a ser invertida: ");
        String s = sc.nextLine();
        String stringInvertida = reverseString(s);
        System.out.printf("O inverso de %s é %s%n", s, stringInvertida);
    }

    private static String reverseString(String s) {
        byte[] bytes = s.getBytes();
        for (int i = 0, j = bytes.length - 1; i < bytes.length / 2; i++, j--) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
        }
        return new String(bytes);
    }
}
