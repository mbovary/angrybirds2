package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;

import java.util.List;

import pt.ipleiria.estg.ei.p2.blast.modelo.Especie;
import pt.ipleiria.estg.ei.p2.blast.modelo.bases.BaseSuportadora;

public class Laser extends SuportadoAgrupavelBonus {

    private static Especie especie;

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
        aplicarDestruicaoSimples();
    }


    public static Especie getEspecie() {
        return especie;
    }

    @Override
    public void reagirInteracao() {
        List<SuportadoAgrupavelBonus> grupo = getBaseSuportadora().getGrupoFormado();

        for (SuportadoAgrupavelBonus v : grupo)
            v.explodir();

        if (grupo.size() == 1) {// só o próprio
            aplicarDestruicaoSimples();
        } else {
            if (!isBonusCombinado(grupo)) {
                aplicarDestruicaoDupla();
            } else if (isBonusCombinadoBomba(grupo)){
                aplicarDestruicaoCombinadaBomba();
            } else if (isBonusCombinadoFoguete(grupo)){
                aplicarDestruicaoCombinadaFoguete();
            }

        }

    }


    protected boolean isBonusCombinadoBomba(List<SuportadoAgrupavelBonus> grupo) {
        for(SuportadoAgrupavelBonus v : grupo) {
            if (v instanceof Bomba) {
                return true;
            }
        }
        return false;
    }

    protected boolean isBonusCombinadoFoguete(List<SuportadoAgrupavelBonus> grupo) {
        for(SuportadoAgrupavelBonus v : grupo) {
            if (v instanceof Bomba) {
                return false;
            } else if (v instanceof Foguete) {
                return true;
            }
        }
            return false;
    }


    protected void aplicarDestruicaoSimples() {
        getJogo().informarLaserDisparado(this);
        List<BaseSuportadora> bases = getJogo().getAreaJogavel().getBasesSuportadorasMesmaEspecie(this.baseSuportadora.getPosicao(), especie);
        for (BaseSuportadora base: bases){
            if (base.getSuportado() != null && base.getSuportado() instanceof Balao)
                base.getSuportado().explodir();
        }
    }

    protected void aplicarDestruicaoDupla() {
        getJogo().informarCombinacaoLaserDisparado(this);
        List<BaseSuportadora> bases = getJogo().getAreaJogavel().getTodasAsBases();
        for (BaseSuportadora base: bases){
            if (base.getSuportado() != null)
                base.getSuportado().explodir();
        }
    }

    private void aplicarDestruicaoCombinadaBomba() {
        getJogo().informarCombinacaoLaserBombaDisparados(this);
        List<BaseSuportadora> bases = getJogo().getAreaJogavel().getBasesSuportadorasMesmaEspecie(this.baseSuportadora.getPosicao(), especie);
        for (BaseSuportadora base: bases) {
            if (base.getSuportado() != null && base.getSuportado() instanceof Balao)  {
                base.getSuportado().explodir();
                getJogo().getAreaJogavel().criarBomba(base);
                base.getSuportado().reagirBonus();
            }
        }
    }
    private void aplicarDestruicaoCombinadaFoguete() {
        getJogo().informarCombinacaoLaserFogueteDisparados(this);
        List<BaseSuportadora> bases = getJogo().getAreaJogavel().getBasesSuportadorasMesmaEspecie(this.baseSuportadora.getPosicao(), especie);
        for (BaseSuportadora base: bases) {
            if (base.getSuportado() != null && base.getSuportado() instanceof Balao)  {
                base.getSuportado().explodir();
                getJogo().getAreaJogavel().criarFoguete(base);
                base.getSuportado().reagirBonus();
            }
        }
    }



}
