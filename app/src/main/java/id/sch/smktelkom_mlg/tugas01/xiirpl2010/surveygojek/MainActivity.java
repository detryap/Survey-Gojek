package id.sch.smktelkom_mlg.tugas01.xiirpl2010.surveygojek;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tvHasil;
    EditText etKomen;
    Spinner spFasilitas;
    CheckBox cb1, cb2, cb3, cb4;
    RadioGroup rgKepuasan;
    String cbHasil1="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Survey Gojek");

        etKomen = (EditText) findViewById(R.id.editTextKomSar);
        spFasilitas = (Spinner) findViewById(R.id.spinnerFasilitas);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        rgKepuasan = (RadioGroup) findViewById(R.id.radioGroupKepuasan);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        kondisiawal();
        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                proses();
            }
        });
    }

    private void kondisiawal()
    {
        etKomen.setText("");
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        rgKepuasan.clearCheck();
        spFasilitas.setSelection(0);
        cbHasil1="";
    }

    private void proses()
    {
        if (isValid())
        {


        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String KomSar = etKomen.getText().toString();

        if (KomSar.isEmpty())
        {
            etKomen.setError("Anda belum mengisi komentar dan saran");
            valid =false;
        }
        else
        {
            etKomen.setError(null);
        }
        return  valid;
    }


}
