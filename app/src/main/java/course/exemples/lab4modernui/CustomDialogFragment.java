package course.exemples.lab4modernui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by vitor on 15/11/2015.
 */
public class CustomDialogFragment extends DialogFragment{


    @Override
    public Dialog onCreateDialog ( Bundle savedInstanceState ){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.titulo_alerta);
        builder.setMessage(R.string.mensagem_alerta);
        builder.setPositiveButton(R.string.positivo_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent visitarSite = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                Intent chooser = Intent.createChooser( visitarSite,getResources().getString(R.string.seletor_button));
                startActivity(chooser);
            }
        });

        builder.setNegativeButton(R.string.negativo_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        return  builder.create();
    }

}
