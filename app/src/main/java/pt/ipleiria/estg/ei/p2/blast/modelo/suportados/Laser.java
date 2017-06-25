package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;

import pt.ipleiria.estg.ei.p2.blast.modelo.Especie;
import pt.ipleiria.estg.ei.p2.blast.modelo.bases.BaseSuportadora;

public class Laser extends SuportadoAgrupavelBonus {

    private Especie especie;

    public Laser(BaseSuportadora baseSuportadora) {
        super(baseSuportadora);
        this.especie = Especie.values()[baseSuportadora.getAreaJogavel().getValorAleatorio(Especie.values().length)];
    }

    public Laser(BaseSuportadora baseSuportadora, Especie especie) {
        super(baseSuportadora);
        this.especie = especie;
    }

    @Override
    public void reagirBonus() {

    }

    @Override
    public void reagirInteracao() {

    }
}
