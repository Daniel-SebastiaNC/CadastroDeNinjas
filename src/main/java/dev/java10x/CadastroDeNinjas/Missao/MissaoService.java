package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        MissaoModel missaoSalva = missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoSalva);
    }

    public List<MissaoDTO> mostrarTodos(){
        List<MissaoModel> missaoModels = missaoRepository.findAll();
        return missaoModels.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList())
        ;
    }

    public MissaoDTO mostrarPorId( Long id){
        Optional<MissaoModel> missao = missaoRepository.findById(id);

        return missao.map(missaoMapper::map).orElse(null);
        /*
        if (missao.isEmpty()) {
            return null;
        } else {
            return missaoMapper.map(missao.get());
        }*/
    }

    public MissaoDTO alterarPorId(Long id, MissaoDTO missaoDTO){
        if (missaoRepository.existsById(id)) {
            missaoDTO.setId(id);
            MissaoModel missaoModel = missaoMapper.map(missaoDTO);
            MissaoModel missaoSalva = missaoRepository.save(missaoModel);
            return missaoMapper.map(missaoSalva);
        } else {
            return null;
        }
    }

    public void deletaPorId(Long id){
        missaoRepository.deleteById(id);
    }
}
