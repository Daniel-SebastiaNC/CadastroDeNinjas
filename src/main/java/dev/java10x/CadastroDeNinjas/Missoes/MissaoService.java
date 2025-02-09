package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }

    public List<MissaoModel> mostrarTodos(){
        return missaoRepository.findAll();
    }
}
