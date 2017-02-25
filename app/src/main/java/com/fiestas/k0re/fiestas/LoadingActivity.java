package com.fiestas.k0re.fiestas;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

    }

    public void enter(View v) {
        String pass = "conmuevete";
        String userPass;

        EditText passField;
        passField = (EditText)findViewById(R.id.PassField);
        userPass = (passField.getText()).toString();

        if (userPass.equals(pass)) {
            startActivity(new Intent(LoadingActivity.this, GenActivity.class));
        } else if (userPass.equals("pene")) {
            snackbar("lol que ases?");
        } else {
            snackbar("Contraseña incorrecta");
        }
    }

    private void snackbar(String msg) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG)
                .show();
    }
}
