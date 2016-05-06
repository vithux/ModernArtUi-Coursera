package course.exemples.lab4modernui;

import android.app.*;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar barraControle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final LinearLayout caixaVermelha = (LinearLayout) findViewById(R.id.caixa_vermelha);
        final LinearLayout caixaAmarela = (LinearLayout) findViewById(R.id.caixa_amarela);
        final LinearLayout caixaCinza = (LinearLayout) findViewById(R.id.caixa_cinza);
        final LinearLayout caixaAzul = (LinearLayout) findViewById(R.id.caixa_azul);
        final LinearLayout caixaVerde = (LinearLayout) findViewById(R.id.caixa_verde);



        barraControle = (SeekBar) findViewById(R.id.seek_bar);

        barraControle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                atualizaCor(caixaVermelha, (255 - progress), 0, 0);
                atualizaCor(caixaAmarela, 255, (255 - progress), 0);
                atualizaCor(caixaVerde, 0, (255 - progress), 0);
                atualizaCor(caixaAzul, 0, 0, (255 - progress));
                atualizaCor(caixaCinza, (200 - progress), (200 - progress), (200 - progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void atualizaCor(LinearLayout caixaAtualiza, int corRed, int corGreen, int corBlue){
        caixaAtualiza.setBackground(new ColorDrawable(Color.rgb(corRed, corGreen, corBlue)));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            DialogFragment myDialogFragment = new CustomDialogFragment();
            myDialogFragment.show(getFragmentManager(), null);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
