import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Exercicio2 {

        public static void main(String[] args) {
            int quantia = 18;
            int[] moedas = {5, 2, 1};
            List<Integer> troco = darTroco(quantia, moedas);

            System.out.println("Moedas usadas: " + troco);
            System.out.println("Número total de moedas: " + troco.size());
        }

        public static List<Integer> darTroco(int quantia, int[] moedas) {
            // Ordena as moedas em ordem decrescente
            Arrays.sort(moedas);
            int n = moedas.length;
            List<Integer> resultado = new ArrayList<>();

            // Percorre as moedas da maior para a menor
            for (int i = n - 1; i >= 0; i--) {
                // Enquanto a quantia restante for maior ou igual à moeda atual
                while (quantia >= moedas[i]) {
                    // Adiciona a moeda ao resultado
                    resultado.add(moedas[i]);
                    // Subtrai o valor da moeda da quantia restante
                    quantia -= moedas[i];
                }
            }
            return resultado;
        }
    }
