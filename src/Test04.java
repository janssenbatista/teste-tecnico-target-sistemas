// 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
// SP – R$67.836,43
// RJ – R$36.678,66
// MG – R$29.229,88
// ES – R$27.165,48
// Outros – R$19.849,53

// Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.

import java.util.List;

public class Test04 {
    public static void main(String[] args) {
        var faturamentos = List.of(
                new FaturamentoPorCidade("SP", 67836.43),
                new FaturamentoPorCidade("RJ", 36678.66),
                new FaturamentoPorCidade("MG", 29229.88),
                new FaturamentoPorCidade("ES", 27165.48),
                new FaturamentoPorCidade("Outros", 19849.53)
        );
        var faturamentoTotal = faturamentos.stream().mapToDouble(FaturamentoPorCidade::valor).reduce(Double::sum);
        faturamentos.forEach(f -> {
            var percentual = f.valor() / faturamentoTotal.getAsDouble() * 100;
            System.out.printf("O faturamento da cidade %s equivale a %.2f%% do faturamento total%n", f.cidade(), percentual);
        });
    }
}

record FaturamentoPorCidade(String cidade, Double valor) {}
