public class FatorialRecursivo {
    public static long fatorial(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        else {
            return n * fatorial(n-1);
        }
    }

    public static void main(String[] args) {
        int numero1 = 3;
        int numero2 = 100;

        System.out.println("Fatorial de " + numero1 + " é: " + fatorial(numero1));
        System.out.println("Fatorial de " + numero2 + " é: " + fatorial(numero2));
    }

}
// não é possivel calcular o fatorial de um numero acima de 100 com uma solução recursiva
// pois a recursão em java usa call stack, que tem um tamanho limitado. Para numeros grandes como 100
// pode exceder o limite resultando em um StackOverFlowError.