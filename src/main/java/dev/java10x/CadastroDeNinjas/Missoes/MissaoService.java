package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public MissaoModel mostrarPorId( Long id){
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        if (missao.isEmpty()) {
            return null;
        } else {
            return missao.get();
        }
    }

    public MissaoModel alterarPorId(Long id, MissaoModel missao){
        if (missaoRepository.existsById(id)) {
            missao.setId(id);
            return missaoRepository.save(missao);
        } else {
            return null;
        }
    }

    public void deletaPorId(Long id){
        missaoRepository.deleteById(id);
    }
}
