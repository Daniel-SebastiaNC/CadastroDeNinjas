package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

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


}
