package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;

import java.util.List;

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

    protected boolean isBonusCombinado(List<SuportadoAgrupavelBonus> grupo) {
        for(SuportadoAgrupavelBonus v : grupo){
            if (!v.getClass().getName().equals(this.getClass().getName())){
                return true;
            }
        }
        return false;
    }







}
