package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;
import pt.ipleiria.estg.ei.p2.blast.modelo.bases.BaseSuportadora;


public class CaixaSurpresa extends SuportadoSensivelOndaChoqueSemForca {

    protected boolean isOvo;
    private Ovo ovo;

    public CaixaSurpresa(BaseSuportadora baseSuportadora, boolean isOvo) {
        super(baseSuportadora);
        if (isOvo == true) {
            ovo = new Ovo();
        }
        else {
            ovo = null;
        }

    }

    @Override
    public void explodir() {
       super.explodir();
        if (this.isOvo == true) {
            getJogo().incrementarPontuacao(160);
            getJogo().informarDestruicaoCaixaSurpesaComOvo(this);
            getJogo().influenciarObjetivoDoJogo(this.ovo);

        } else {
            getJogo().incrementarPontuacao(80);
            getJogo().informarDestruicaoCaixaSurpesaSemOvo(this);
        }
    }
}
