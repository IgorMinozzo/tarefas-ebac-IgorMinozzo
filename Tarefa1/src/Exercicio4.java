public class Exercicio4 {

    public static void main(String[] args) {
        String[][] resumo = {
                {"Estrutura", "Método", "Tempo", "Espaço"},
                {"==============="},
                {"Pilha", "push", "O(1)", "O(1)"},
                {"Pilha", "pop", "O(1)", "O(1)"},
                {"==============="},
                {"Fila", "enqueue", "O(1)", "O(1)"},
                {"Fila", "dequeue", "O(1)", "O(1)"},
                {"Fila", "rear", "O(1)", "O(1)"},
                {"Fila", "front", "O(1)", "O(1)"},
                {"==============="},
                {"Lista Encadeada", "push", "O(n)", "O(1)"},
                {"Lista Encadeada", "pop", "O(n)", "O(1)"},
                {"Lista Encadeada", "insert", "O(n)", "O(1)"},
                {"Lista Encadeada", "remove", "O(n)", "O(1)"},
                {"Lista Encadeada", "elementAt", "O(n)", "O(1)"}
        };


        int[] colWidths = new int[resumo[0].length];
        for (String[] row : resumo) {
            for (int col = 0; col < row.length; col++) {
                colWidths[col] = Math.max(colWidths[col], row[col].length());
            }
        }


        for (String[] row : resumo) {
            for (int col = 0; col < row.length; col++) {
                System.out.print(padRight(row[col], colWidths[col] + 2));
            }
            System.out.println();
        }
    }


    private static String padRight(String text, int length) {
        return String.format("%-" + length + "s", text);
    }
}
