public class FibonacciDinamico {

    private static final int MAX_ELEMENTOS = 100;

    private static final long[] elementosFib = new long[MAX_ELEMENTOS];

    public static long encontrarElementoPd(int n ){
        for (int i = 0; i < MAX_ELEMENTOS; i++ ){
            elementosFib[i] = -1;
        }

        return encontarElemento(n);
    }

    public static long encontarElemento(int n ){
        if (elementosFib[n] == -1){
            if (n <= 1){
                elementosFib[n] = n;
            }
            else {
                elementosFib[n] = encontarElemento(n - 1) + encontarElemento(n - 2);
            }
        }

        return elementosFib[n];
    }

    public static void main(String[] args) {
        int n = 50;

        System.out.println("Elemento " + n + ": " + encontrarElementoPd(n));
    }
}
