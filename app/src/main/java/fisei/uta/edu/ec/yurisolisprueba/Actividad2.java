package fisei.uta.edu.ec.yurisolisprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {
    private int LAUNCH_ACTIVITY_2 = 1;
    private int LAUNCH_ACTIVITY_3 = 1;
    String nombre = "", apellido, base = "", exponente, numero;
    private Button button_cerrar_Activity2;
    private TextView text_nombre;
    private TextView text_base;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void AbrirTerceraActivity(View view){
        Intent intent = new Intent(this,Activity3.class);
        startActivityForResult(intent, LAUNCH_ACTIVITY_2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LAUNCH_ACTIVITY_3){
            if(resultCode == Activity.RESULT_OK){
                text_nombre = findViewById(R.id.editText_nombre_activity3);
                text_base = findViewById(R.id.editText_base_activity3);
                apellido = data.getStringExtra("apellido");
                exponente = data.getStringExtra("exponente");
                numero = data.getStringExtra("numero");

                button_cerrar_Activity2 = findViewById(R.id.button_cerrar_Activity2);

                nombre = getIntent().getExtras().getString("nombre");
                base = getIntent().getExtras().getString("base");

                text_nombre.setText(nombre);
                text_base.setText(base);

                if(!nombre.equals(""))
                    button_cerrar_Activity2.setEnabled(true);

            }

            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }
    public void AbrirActivity3(View view){
        Intent intent = new Intent(this, Activity3.class);
        startActivityForResult(intent, LAUNCH_ACTIVITY_3);
    }

    public void CerrarActivity2(View view){
        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);

        this.finish();;
    }
}