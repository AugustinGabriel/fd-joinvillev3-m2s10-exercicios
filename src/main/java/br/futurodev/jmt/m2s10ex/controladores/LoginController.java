package br.futurodev.jmt.m2s10ex.controladores;

import br.futurodev.jmt.m2s10ex.dtos.LoginRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.LoginRespostaDto;
import br.futurodev.jmt.m2s10ex.servicos.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {

    private final LoginService service;

    @PostMapping
    public LoginRespostaDto login(@RequestBody LoginRequisicaoDto dto) {
        return service.autenticar(dto);
    }

}
