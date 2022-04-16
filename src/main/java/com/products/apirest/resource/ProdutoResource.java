package com.products.apirest.resource;

import com.products.apirest.models.Produto;
import com.products.apirest.repositories.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//URI
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "API REST")
public class ProdutoResource {

    ProdutoRepository repository;

    //Devolve todos os produtos
    @GetMapping("/produtos")
    @Operation(summary = "CONSULTA", description = "Retorna todos os produtos")
    public List<Produto> listaProdutos(){
        return repository.findAll();
    }

    //Devolve Apenas um produto
    @GetMapping("/produto/{id}")
    @Operation(summary = "CONSULTA", description = "Retorna produto por ID")
    public Produto listaProdutoUnico(@PathVariable (value = "id") Long id){
        return repository.findById(id)
                .orElseThrow();
    }

    @PostMapping("/produto")
    //@RequestBody -> Objeto virá no corpo da requisição
    @Operation(summary = "INSERIR PRODUTO", description = "Adiciona um novo produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        if (produto != null)
            return repository.save(produto);
        else
            throw new IllegalStateException("Produto não pode ser nulo");
    }

    @DeleteMapping("/produto")
    @Operation(summary = "DELETAR", description = "Apaga produto por ID")
    public void deletaProduto(@RequestBody Produto produto){
        repository.delete(produto);
    }

    @PutMapping("/produto")
    @Operation(summary = "ATUALIZA", description = "Atualiza produto por ID")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return repository.save(produto);
    }

}
