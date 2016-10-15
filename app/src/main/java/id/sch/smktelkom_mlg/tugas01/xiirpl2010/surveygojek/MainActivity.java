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

            String Komen = etKomen.getText().toString();
            int stratlen1 = cbHasil1.length();
            String irb;

            if (cb1.isChecked()) cbHasil1 += "\t- "+ cb1.getText() +"\n";
            if (cb2.isChecked()) cbHasil1 += "\t- "+ cb2.getText() +"\n";
            if (cb3.isChecked()) cbHasil1 += "\t- "+ cb3.getText() +"\n";
            if (cb4.isChecked()) cbHasil1 += "\t- "+ cb4.getText() +"\n";
            if (cbHasil1.length()==stratlen1) cbHasil1+= "Tidak mendapatkan Pelayanan";

            if (rgKepuasan.getCheckedRadioButtonId()!= -1)
            {
                RadioButton rb = (RadioButton) findViewById(rgKepuasan.getCheckedRadioButtonId());
                irb = rb.getText().toString();
            }
            else
            {
                irb = null;
            }
            if (irb == null)
            {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Anda harus mengisi Input Kepuasan!!");
                builder1.setCancelable(true);

                builder1.setNeutralButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                //startActivity(new Intent(CourseActivity.this, MainActivity.class));
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
            else
            {
                tvHasil.setText("Pelanggan telah mengunakan fasilitas "+ spFasilitas.getSelectedItem().toString()+"\n" +
                        "Pelanggan mendapatkan : \n"+ cbHasil1 +" Pelanggan "+ irb+" dengan pelayanan Gojek\n" +
                        "Pelanggan memberikan Komentar dan saran: " + Komen +" ");
                kondisiawal();
            }
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
