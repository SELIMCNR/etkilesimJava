package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button ok ;
    Button diaolog;
    ConstraintLayout layout;
    TextView sil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    ok = findViewById(R.id.button);
    layout = findViewById(R.id.layout);
    diaolog=findViewById(R.id.button2);
    sil = findViewById(R.id.textView);

    ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //Length_Indefınıte closa basana kadar ekranda kal
            Snackbar.make(layout,"This a snacbar", BaseTransientBottomBar.LENGTH_INDEFINITE).setAction("Close", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Toast mesasage",Toast.LENGTH_LONG).show();
                }
            }).show();
        }
    });

    diaolog.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        showDialogMessage();
        }


    });
    }


    private void showDialogMessage() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete").setMessage("Do you want to delete text ? ")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     dialogInterface.cancel(); //dialogu kapat
                        Toast.makeText(getApplicationContext(),"Dialog kapandı",Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sil.setText("");
                        Toast.makeText(getApplicationContext(),"Metin dilindi",Toast.LENGTH_LONG).show();
                    }
                }).show();
        alertDialog.create(); // mesajı oluştur

    }

}