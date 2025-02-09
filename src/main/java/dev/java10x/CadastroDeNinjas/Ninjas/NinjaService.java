package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel mostrarNinjaPorId(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        //ninja.orElse(null);
        if (ninja.isEmpty()){
            return null;
        } else {
            return ninja.get();
        }

    }

    public NinjaModel cirarNinja(NinjaModel ninjaModel) {
        return ninjaRepository.save(ninjaModel);
    }

    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaModel alterarPorId(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

}
