package dev.java10x.CadastroDeNinjas.Missoes;

public class MissaoMapper {
    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel(missaoDTO.getId(), missaoDTO.getNome(), missaoDTO.getDificuldade(), missaoDTO.getNinjas());

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO(missaoModel.getId(), missaoModel.getNome(), missaoModel.getDificuldade(), missaoModel.getNinjas());

        return missaoDTO;
    }
}
