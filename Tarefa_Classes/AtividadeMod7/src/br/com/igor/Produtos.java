package br.com.igor;

public class Produtos {

    private int codigo;
    private String nome;
    private Float valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }


    /**
     * O método imprime os atributos de Produto.
     */
    public void imprimirProduto(){
        System.out.println("--------------------------");
        System.out.println("Nome: "+ getNome());
        System.out.println("Valor: "+ getValor());
        System.out.println("Codigo: "+ getCodigo());
        System.out.println("--------------------------");
    }

    /**
     * Método que desconta 8% do valor do produto.
     */
    public void descontoProduto(){
        this.valor = (this.valor - (this.valor * 0.08f));
        setValor(this.valor);
    }

}
