package fisei.uta.edu.ec.yurisolisprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private int LAUNCH_ACTIVITY_2 = 1;
    String nombre, base;
    private EditText edit_nombre;
    private EditText edit_base;
    private EditText edit_apellido;
    private EditText edit_exponente;
    private EditText edit_numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        edit_nombre = findViewById(R.id.editText_nombre_activity3);
        edit_base = findViewById(R.id.editText_base_activity3);
        edit_apellido = findViewById(R.id.editText_apellido_activity3);
        edit_exponente = findViewById(R.id.editText_exponente_activity3);
        edit_numero = findViewById(R.id.editText_factorial_activity3);

    }

    public void AbrirActivity2(View view){
        Intent intent = new Intent(this, Actividad2.class);
        intent.putExtra("nombre", edit_nombre.getText().toString());
        intent.putExtra("base", edit_base.getText().toString());
        startActivityForResult(intent, LAUNCH_ACTIVITY_2);
    }

    public void CerrarActivity3(View view){
        String nombre,apellido,base, exponente, numero;
        nombre = edit_nombre.getText().toString();
        base = edit_base.getText().toString();
        apellido = edit_apellido.getText().toString();
        exponente = edit_exponente.getText().toString();
        numero = edit_numero.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);
        this.finish();
    }

}