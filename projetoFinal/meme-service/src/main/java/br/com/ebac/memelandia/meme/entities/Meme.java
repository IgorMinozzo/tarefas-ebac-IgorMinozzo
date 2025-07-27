package br.com.ebac.memelandia.meme.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "meme")
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @SequenceGenerator(name = "sequence_meme", sequenceName = "sequence_meme", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "categoria_meme_id", nullable = false)
    private Long categoriaMemeId;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public Meme() {}

    public Meme(String nome, String descricao, String url, Date dataCadastro, Long categoriaMemeId, Long usuarioId) {
        this.nome = nome;
        this.descricao = descricao;
        this.url = url;
        this.dataCadastro = dataCadastro;
        this.categoriaMemeId = categoriaMemeId;
        this.usuarioId = usuarioId;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getCategoriaMemeId() {
        return categoriaMemeId;
    }

    public void setCategoriaMemeId(Long categoriaMemeId) {
        this.categoriaMemeId = categoriaMemeId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}

