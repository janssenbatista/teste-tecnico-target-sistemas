// 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
// O menor valor de faturamento ocorrido em um dia do mês;
// O maior valor de faturamento ocorrido em um dia do mês;
// Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
//
// IMPORTANTE:
// a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
// b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test03 {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Faturamento> faturamentos = mapper.readValue(new File("dados.json"), new TypeReference<>() {
            });
            var diasComFaturamento = faturamentos.stream().filter(faturamento -> faturamento.valor() > 0).toList();
            var menorFaturamento = diasComFaturamento.get(0);
            var maiorFaturamento = diasComFaturamento.get(0);
            for (Faturamento faturamento : diasComFaturamento) {
                if (faturamento.valor() > maiorFaturamento.valor()) {
                    maiorFaturamento = faturamento;
                }
                if (faturamento.valor() < menorFaturamento.valor()) {
                    menorFaturamento = faturamento;
                }
            }
            System.out.println("==================================================");
            System.out.println("Menor faturamento ocorrido em um dia do mês: " + menorFaturamento.valor());
            System.out.println("==================================================");
            System.out.println("Maior faturamento ocorrido em um dia do mês: " + maiorFaturamento.valor());
            System.out.println("==================================================");
            var mediaMensal = diasComFaturamento.stream().mapToDouble(Faturamento::valor).average();
            System.out.println("Média mensal: " + mediaMensal.getAsDouble());
            System.out.println("==================================================");
            var numeroDeDiasComFaturamentoSuperiorAMediaMensal = diasComFaturamento.stream()
                    .filter(faturamento -> faturamento.valor() > mediaMensal.getAsDouble())
                    .mapToInt(Faturamento::dia)
                    .toArray().length;
            System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + numeroDeDiasComFaturamentoSuperiorAMediaMensal);
            System.out.println("==================================================");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

record Faturamento(int dia, double valor) {
}
