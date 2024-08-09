import java.util.ArrayList;
import java.util.List;

public class Exercicio1 {

        public static void main(String[] args) {
            int[] S = {1, 2, 3};
            int n = 2;
            List<List<Integer>> result = subsets(S, n);
            System.out.println(result);

        }

        public static List<List<Integer>> subsets(int[] S, int n) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(S, n, 0, new ArrayList<>(), result);
            return result;
        }

        private static void backtrack(int[] S, int n, int start, List<Integer> subset, List<List<Integer>> result) {
            // Se o subset atual tem n elementos, adiciona-o ao resultado
            if (subset.size() == n) {
                result.add(new ArrayList<>(subset));
                return;
            }

            // Tenta adicionar cada elemento de S ao subset atual
            for (int i = start; i < S.length; i++) {
                // Adiciona S[i] ao subset
                subset.add(S[i]);
                // Continua a construir o subset
                backtrack(S, n, i + 1, subset, result);
                // Remove o último elemento para explorar outras combinações
                subset.remove(subset.size() - 1);
            }
        }
}
