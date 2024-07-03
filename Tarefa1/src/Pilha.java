public class Pilha {
    private Node topo;
    private int tamanho;

    private class Node{
        int valor;
        Node proximo;

        Node(int valor){
            this.valor = valor;
            this.proximo = null;
        }
    }

    public Pilha(){
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(int valor){
        Node novoNode = new Node(valor);
        novoNode.proximo = topo;
        topo = novoNode;
        tamanho++;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("Pilha está vazia");
        }
        int valor = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    public int top(){
        if (isEmpty()){
            throw new RuntimeException("Pilha está vazia");
        }
        return topo.valor;
    }

    public boolean isEmpty(){
        return topo == null;
    }

    public int size(){
        return tamanho;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo da pilha: " + pilha.top());
        System.out.println("Tamanho da pilha: " + pilha.size());

        System.out.println("Elemento removido: " + pilha.pop());
        System.out.println("Topo da pilha: " + pilha.top());
        System.out.println("Tamanho da pilha: " + pilha.size());

        System.out.println("A pilha está vazia? " + pilha.isEmpty());
    }
}
