package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas(){

        List<NinjaModel> ninjas = ninjaRepository.findAll();

        /*
        List<NinjaDTO> ninjaDTO = new ArrayList<>();
        for (NinjaModel ninja : ninjaModel) {
            ninjaDTO.add(ninjaMapper.map(ninja));
        }*/

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());

    }

    public NinjaDTO mostrarNinjaPorId(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.map(ninjaMapper::map).orElse(null);
        /*if (ninja.isEmpty()){
            return null;
        } else {
            return ninjaMapper.map(ninja.get());
        }*/

    }

    public NinjaDTO cirarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO alterarPorId(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;

        /*if (ninjaRepository.existsById(id)) {
            ninjaDTO.setId(id);
            NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
            ninjaDTO = ninjaMapper.map(ninjaRepository.save(ninjaModel));
            return ninjaDTO;
        } else {
            return null;
        }*/
    }

}
