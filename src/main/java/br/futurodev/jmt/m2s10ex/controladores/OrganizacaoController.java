package br.futurodev.jmt.m2s10ex.controladores;

import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRespostaDto;
import br.futurodev.jmt.m2s10ex.servicos.OrganizacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("organizacoes")
public class OrganizacaoController {

    private final OrganizacaoService service;

    @GetMapping
    public List<OrganizacaoRespostaDto> get() {
        return service.buscarTodos();
    }

    @GetMapping("{id}")
    public OrganizacaoRespostaDto getId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizacaoRespostaDto post(@RequestBody OrganizacaoRequisicaoDto dto) {
        return service.criar(dto);
    }

    @PutMapping("{id}")
    public OrganizacaoRespostaDto put(
            @PathVariable Long id,
            @RequestBody OrganizacaoRequisicaoDto dto
    ) {
        return service.alterar(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.excluir(id);
    }

}
