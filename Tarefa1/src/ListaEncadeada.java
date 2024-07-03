public class ListaEncadeada {
    private Node head;
    private int tamanho;

    public static class Node{
        int valor;
        Node proximo;

        Node(int valor){
            this.valor = valor;
            this.proximo = null;
        }
    }

    public ListaEncadeada(){
        this.head = null;
        this.tamanho = 0;
    }

    public void push(Node node){
        if (head == null){
            head = node;
        }
        else {
            Node atual = head;
            while (atual.proximo != null){
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        tamanho++;
    }
    public Node pop(){
        if (head == null) {
            throw new RuntimeException("Lista está vazia");
        }
        if (head.proximo == null){
            Node node = head;
            head = null;
            tamanho--;
            return node;
        }
        Node atual = head;
        while (atual.proximo.proximo != null){
            atual = atual.proximo;
        }
        Node node = atual.proximo;
        atual.proximo = null;
        tamanho--;
        return node;
    }

    public void insert(int index, Node node){
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        if (index == 0) {
            node.proximo = head;
            head = node;
        }
        else {
            Node atual = head;
            for (int i = 0; i < index - 1; i++){
                atual = atual.proximo;
            }
            node.proximo = atual.proximo;
            atual.proximo = node;
        }
        tamanho++;
    }

    public void remove(int index){
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        if (index == 0){
            head = head.proximo;
        }
        else {
            Node atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    public Node elementAt(int index){
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        Node atual = head;
        for (int i = 0; i < index; i++){
            atual = atual.proximo;
        }
        return atual;
    }

    public int size(){
        return tamanho;
    }

    public void printList(){
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        lista.push(node1);
        lista.push(node2);
        lista.push(node3);
        lista.printList();

        lista.insert(1, node4);
        lista.printList();

        lista.remove(2);
        lista.printList();

        Node node = lista.pop();
        System.out.println("Nó removido: " + node.valor);
        lista.printList();

        Node elemento = lista.elementAt(1);
        System.out.println("Elemento no índice 1: " + elemento.valor);

        System.out.println("Tamanho da lista: " + lista.size());
    }
}
