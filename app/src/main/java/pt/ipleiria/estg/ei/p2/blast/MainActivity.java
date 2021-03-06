package pt.ipleiria.estg.ei.p2.blast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import pt.ipleiria.estg.dei.gridcomponent.GridComponent;
import pt.ipleiria.estg.dei.gridcomponent.GridPanelEventHandler;
import pt.ipleiria.estg.ei.p2.blast.modelo.Jogo;

import static pt.ipleiria.estg.ei.p2.blast.R.id.menuBooster;
import static pt.ipleiria.estg.ei.p2.blast.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements GridPanelEventHandler {

    private Jogo jogo;
    private GridComponent gridComponent;
    private RepresentadorAndroid representadorAndroid;
    private GridComponent gridComponentInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        gridComponent = (GridComponent) findViewById(R.id.gridAreaJogavel);
        gridComponentInfo = (GridComponent) findViewById(R.id.gridInfo);

        iniciarJogo();


    }

    //CRIAR O BOOSTER NO MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.booster, menu);
         return true;
    }


   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case menuBooster:
                countbooster = jogo.getAreaJogavel().explodirBoosters();

                item.setVisible(false);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    } */



    private void iniciarJogo() {
        limparComponente(gridComponent);
        limparComponente(gridComponentInfo);
        gridComponent.enableEvents();


        //criar o jogo
        jogo = new Jogo();

        //definir o representador em android
        //além do jogo é necessário passar o contexto e o grid
        representadorAndroid = new RepresentadorAndroid(jogo, this, gridComponent, gridComponentInfo);

        //iterar pela 1ª vez para criar balões
        jogo.iterar();


        //definir o tempo entre as iterações do motor (como no jogo atual não há
        //nenhum elemento que necessite "contar" o tempo, o valor do parâmetro
        //pode ser 1 segundo = 1000ms)
        gridComponent.startIterations(1000);

        //definir esta classe como sendo o ouvinte dos eventos do componente
        gridComponent.setEventHandler(this);

        // coordenar os repaints e outros eventos com a grelha de cima
        gridComponent.coordinateWith(gridComponentInfo);
    }

    private void limparComponente(GridComponent gridComponent) {
        gridComponent.reinitialize();
    }

    @Override
    public void pressed(int linha, int coluna) {

    }

    @Override
    public void released(int linha, int coluna) {
        //vamos assumir que apenas interessa saber onde se levantou o dedo
        if (jogo.interagir(linha, coluna)) {
            jogo.iterar();
            representadorAndroid.representarInfo();
        }
    }

    @Override
    public void dragged(int linha, int coluna) {

    }


    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == RepresentadorAndroid.JOGAR_NOVAMENTE) {
            if (resultCode == RESULT_OK) {
                //added so that the booster icon appears again after restart of the game
                invalidateOptionsMenu();
                iniciarJogo();
            } else {
                //added so that the booster icon appears again after restart of the game
                 invalidateOptionsMenu();
                 finish();
            }
        }

    }



    public void activateBooster(MenuItem item) {
        jogo.getAreaJogavel().explodirBoosters();
        onMenuItemSelected(menuBooster, item.setVisible(false));


    }
    }
