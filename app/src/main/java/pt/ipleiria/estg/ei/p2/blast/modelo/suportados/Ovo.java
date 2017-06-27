package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;

import pt.ipleiria.estg.ei.p2.blast.modelo.Objetivavel;

public class Ovo extends Suportado implements Objetivavel {

    private CaixaSurpresa caixa;

    public Ovo(CaixaSurpresa caixa) {
        super(caixa.getBaseSuportadora());
        this.caixa = caixa;

            }


    @Override
    public void reagirBonus() {

    }

    @Override
    public void explodir() {
        getJogo().influenciarObjetivoDoJogo(this);
        getJogo().incrementarPontuacao(80);
        getJogo().informarExplosao(this);
    }
}
