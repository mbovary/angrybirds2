package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;

import pt.ipleiria.estg.ei.p2.blast.modelo.bases.BaseSuportadora;

public class Vidro extends SuportadoSensivelOndaChoqueSemForca {

    public Vidro(BaseSuportadora baseSuportadora) {
        super(baseSuportadora);
    }

    @Override
    public void explodir() {
        super.explodir();
        getJogo().incrementarPontuacao(50);
    }


}
