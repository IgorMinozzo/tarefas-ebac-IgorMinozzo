package br.com.ebac.memelandia.meme.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categoria-meme-service", url = "http://localhost:8082")
public interface CategoriaMemeClient {

    @GetMapping("/categorias/{id}")
    CategoriaMemeDto buscarPorId(@PathVariable("id") Long id);

    class CategoriaMemeDto {
        private Long id;
        private String nome;
        private String descricao;

        public CategoriaMemeDto() {}

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
    }
}

