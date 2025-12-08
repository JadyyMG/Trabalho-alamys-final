//Sigam os comentárioos para entender o código e fazer as suas partes !!

//a parte do front precisa de alterções para integrar com o back, algo que tambhém precisa que vocês façam
//bug lógico do ultimo projeto resolvido 

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LotoFacilBack {

    // Gera 15 números sorteados aleatórios entre 1 e 25
    public static List<Integer> gerarSorteio() {

        Random rng = new Random();
        List<Integer> sorteio = new ArrayList<>();

        while (sorteio.size() < 15) {
            int num = rng.nextInt(25) + 1; // 1 a 25

            if (!sorteio.contains(num)) {
                sorteio.add(num);
            }
        }

        Collections.sort(sorteio);
        return sorteio;
    }

    // Conta quantos números da lista1 estão na lista2
    public static int compararListas(List<Integer> lista1, List<Integer> lista2) {
        int acertos = 0;

        for (int numero : lista1) {
            if (lista2.contains(numero)) {
                acertos++;
            }
        }
        return acertos;
    }

    // Retorna apenas os números acertados
    public static List<Integer> obterAcertos(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> acertos = new ArrayList<>();

        for (int numero : lista1) {
            if (lista2.contains(numero)) {
                acertos.add(numero);
            }
        }

        return acertos;
    }
    
     // coloca o valor das apostas conforme a quantidade de números selecionados
    public static double calcularValorAposta(int qtd) {
        return switch (qtd) {
            case 15 -> 3.50;
            case 16 -> 56.00;
            case 17 -> 476.00;
            case 18 -> 2856.00;
            default -> 0.0;
        };
    }



// Gera uma mensagem com resultado da aposta
public static String gerarMensagemResultado(List<Integer> aposta, List<Integer> sorteio) {

    int acertos = compararListas(aposta, sorteio);
    List<Integer> numsAcertados = obterAcertos(aposta, sorteio);

    return "Você acertou " + acertos + " números! Acertos: " + numsAcertados;
 }
}

// Probabilidade de Ganhar
public class ProbabilidadesLotoFacil {

    // Função para calcular fatorial
    public static long fatorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Função de combinações: C(n, k)
    public static long combinacao(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fatorial(n) / (fatorial(k) * fatorial(n - k));
    }

    /**
     * Calcula a probabilidade de acertar X acertos (13, 14 ou 15).
     *
     * @param escolhidos   Quantos números o usuário marcou (15 a 18)
     * @param acertosDesejados  Quantos acertos queremos calcular
     * @return Probabilidade em porcentagem
     */
    public static double calcularProbabilidade(int escolhidos, int acertosDesejados) {

        // total de combinações possíveis do sorteio (25, 15)
        long totalPossibilidades = combinacao(25, 15);

        // parte da fórmula: escolher "acertos" dentro dos números marcados
        long acertosNasEscolhas = combinacao(escolhidos, acertosDesejados);

        // parte da fórmula: escolher o restante entre os números NÃO marcados
        int numerosNaoEscolhidos = 25 - escolhidos;
        long errosFora = combinacao(numerosNaoEscolhidos, 15 - acertosDesejados);

        // total de combinações que dão exatamente aquele número de acertos
        long totalAcertos = acertosNasEscolhas * errosFora;

        // probabilidade
        return (double) totalAcertos / totalPossibilidades * 100.0;
    }


    public static void main(String[] args) {

        int escolhidos = 15; // pode ser 15, 16, 17 ou 18

        System.out.println("Probabilidades para aposta com " + escolhidos + " números:");
        System.out.printf("13 acertos: %.8f%%\n", calcularProbabilidade(escolhidos, 13));
        System.out.printf("14 acertos: %.8f%%\n", calcularProbabilidade(escolhidos, 14));
        System.out.printf("15 acertos: %.12f%%\n", calcularProbabilidade(escolhidos, 15));
    }
}
