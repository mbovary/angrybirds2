package pt.ipleiria.estg.ei.p2.blast.modelo.suportados;
import pt.ipleiria.estg.ei.p2.blast.modelo.bases.BaseSuportadora;


public class CaixaSurpresa extends SuportadoSensivelOndaChoqueSemForca {

    private static Ovo ovo;

    public CaixaSurpresa(BaseSuportadora baseSuportadora, boolean isOvo) {
        super(baseSuportadora);
        if (isOvo == true) {
            ovo = new Ovo(this);
            this.setOvo(ovo);
        }
        else {
            ovo = null;
        }

    }

    @Override
    public void explodir() {
       super.explodir();
        getJogo().incrementarPontuacao(80);
        if (ovo != null) {
            this.getOvo().explodir();
            this.libertarOvo();
            getJogo().informarDestruicaoCaixaSurpesaComOvo(this);

        } else {
            getJogo().informarDestruicaoCaixaSurpesaSemOvo(this);
        }
    }

    public static Ovo getOvo() {
        return ovo;
    }

    public void libertarOvo() {
        ovo = null;
    }

    public void setOvo(Ovo ovo) {
        this.ovo = ovo;
    }
}
