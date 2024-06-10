package br.com.igor.domain;


import javax.persistence.*;


@Entity
@Table(name = "TB_CARRO")
public class Carro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "VALOR", nullable = false)
	private Double valor;
	
	@OneToOne
	@JoinColumn(name = "id_marca_fk",
		foreignKey = @ForeignKey(name = "fk_marca_carro"),
		referencedColumnName = "id", nullable = false
		)
	private Marca marca;
	
	@OneToOne
	@JoinColumn(name = "id_acessorio_fk",
	foreignKey = @ForeignKey(name = "fk_acessorio_carro"),
	referencedColumnName = "id", nullable = false
	)
	private Acessorio acessorio;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
	
	
}
