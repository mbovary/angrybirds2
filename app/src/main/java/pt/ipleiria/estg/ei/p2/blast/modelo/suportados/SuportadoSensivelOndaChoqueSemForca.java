package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;

import pt.ipleiria.estg.ei.p2.blast.modelo.bases.BaseSuportadora;

public class SuportadoSensivelOndaChoqueSemForca extends SuportadoSensivelOndaChoque {

    public SuportadoSensivelOndaChoqueSemForca(BaseSuportadora baseSuportadora) {
        super(baseSuportadora);
    }

    @Override
    public void receberOndaChoque() {
        explodir();
    }

    @Override
    public void reagirBonus() {
        explodir();
    }
}
