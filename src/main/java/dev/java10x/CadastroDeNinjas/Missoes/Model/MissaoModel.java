package dev.java10x.CadastroDeNinjas.Missoes.Model;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private RankMissao dificuldade;

    //Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    /*public MissaoModel() {
    }

    public MissaoModel(String nome, RankMissao dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RankMissao getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(RankMissao dificuldade) {
        this.dificuldade = dificuldade;
    }*/
}
