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
