//Sigam os comentárioos para entender o código e fazer as suas partes !!

//a parte do front precisa de alterções para integrar com o back, algo que tambhém precisa que vocês façam
//bug lógico do ultimo projeto resolvido 

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
}
