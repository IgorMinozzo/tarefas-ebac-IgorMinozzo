public class Fila {
    private Node frente;
    private Node traseira;
    private int tamanho;

    private class Node {
        int valor;
        Node proximo;

        Node (int valor){
            this.valor = valor;
            this.proximo = null;
        }
    }

    public Fila(){
        this.frente = null;
        this.traseira = null;
        this.tamanho = 0;
    }

    public void enqueue(int valor){
        Node novoNode = new Node(valor);
        if (isEmpty()) {
            frente = traseira = novoNode;
        }
        else {
            traseira.proximo = novoNode;
            traseira = novoNode;
        }
        tamanho++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Fila está vazia");
        }
        int valor = frente.valor;
        frente = frente.proximo;
        if (frente == null){
            traseira = null;
        }
        tamanho--;
        return valor;
    }

    public int rear(){
        if (isEmpty()){
            throw new RuntimeException("Fila está vazia");
        }
        return traseira.valor;
    }

    public int front(){
        if (isEmpty()){
            throw new RuntimeException("Fila está vazia");
        }
        return frente.valor;
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return frente == null;
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Elemento na frente da fila: " + fila.front());
        System.out.println("Elemento no final da fila: " + fila.rear());
        System.out.println("Tamanho da fila: " + fila.size());

        System.out.println("Elemento removido: " + fila.dequeue());
        System.out.println("Elemento na frente da fila: " + fila.front());
        System.out.println("Tamanho da fila: " + fila.size());

        System.out.println("A fila está vazia? " + fila.isEmpty());
    }
}
