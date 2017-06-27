package pt.ipleiria.estg.ei.p2.blast.modelo.objetivos;

import pt.ipleiria.estg.ei.p2.blast.modelo.Objetivavel;
import pt.ipleiria.estg.ei.p2.blast.modelo.suportados.Ovo;


public class ObjetivoParcialOvo extends ObjetivoParcial {

    public ObjetivoParcialOvo(int quantidade) {
        super(quantidade);
    }

    @Override
    public boolean hasInfluencia(Objetivavel objetivavel) {
        return objetivavel instanceof Ovo;
    }
}
