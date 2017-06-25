package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;

import pt.ipleiria.estg.ei.p2.blast.modelo.bases.BaseSuportadora;

public abstract class SuportadoAgrupavelBonus extends SuportadoAgrupavel {
    public SuportadoAgrupavelBonus(BaseSuportadora baseSuportadora) {
        super(baseSuportadora);
    }

    @Override
    public boolean podeInteragir() {
        return true;
    }


    @Override
    public boolean agrupaCom(SuportadoAgrupavel suportado) {
        return suportado instanceof SuportadoAgrupavelBonus;
    }



}
