package com.example.practicappt;

import static java.sql.Types.NULL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Registro extends AppCompatActivity {

    Intent w;
    EditText nick;
    String nickS, idS, u1S, u1N;
    InputStream query, exists, id, u1, iu1, uu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        nick = (EditText) findViewById(R.id.et_nick);
    }

    public void btn_confirm_onClick(View v) {
        try {
            w = new Intent(this, Juego.class);

            if (TextUtils.isEmpty(nick.getText().toString())) {
                nick.setError("Campo obligatorio");
                Toast.makeText(this, "Campo obligatorio", Toast.LENGTH_SHORT).show();
            } else {
                //COMPROBAMOS SI EXISTE EL NICK
                BBDD user = new BBDD();
                exists = user.bbdd("http://192.168.1.199:80/pptSELECTjugadores.php?nick=" +
                        nick.getText().toString());
                Scanner sc1 = new Scanner(exists);
                while (sc1.hasNext()) {
                    nickS = sc1.nextLine();
                }
                if (nickS.equals(nick.getText().toString())) {
                    Toast.makeText(this, "Nick ya existente. Inserte otro.", Toast.LENGTH_LONG).show();
                } else {
                    //INSERTAMOS EL NICK EN LA BBDD
                    BBDD data = new BBDD();
                    query = data.bbdd("http://192.168.1.199:80/pptINSERTjugadores.php?nick=" +
                            nick.getText().toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btn_start_onClick(View v) {
        try {
            if (TextUtils.isEmpty(nick.getText().toString())) {
                nick.setError("Campo obligatorio");
                Toast.makeText(this, "Campo obligatorio", Toast.LENGTH_SHORT).show();
            } else {
                //OBTENEMOS EL ID DEL NICK INSERTADO
                BBDD idn = new BBDD();
                id = idn.bbdd("http://192.168.1.199:80/pptSELECTidjugadores.php?nick=" +
                        nick.getText().toString());
                //
                Scanner sc2 = new Scanner(id);
                idS = sc2.nextLine();

                //COMPROBAMOS SI HAY UNA PARTIDA LIBRE
                BBDD u1n = new BBDD();
                u1 = u1n.bbdd("http://192.168.1.199:80/pptSELECTu2nullpartidas.php");
                Scanner sc3 = new Scanner(u1);
                u1S = "null";

                while (sc3.hasNext()) {
                    u1S = sc3.nextLine();
                }

                //Toast.makeText(this, u1S, Toast.LENGTH_SHORT).show();

                if (u1S.equals("null")) {
                    BBDD u1i = new BBDD();
                    iu1 = u1i.bbdd("http://192.168.1.199:80/pptINSERTu1partidas.php?u1=" +
                            idS);
                    Toast.makeText(this, "Partida nueva.", Toast.LENGTH_SHORT).show();
                    startActivity(w);
                } else {
                    BBDD u2u = new BBDD();
                    uu2 = u2u.bbdd("http://192.168.1.199:80/pptUPDATEu2partidas.php?u2=" +
                            idS);
                    Toast.makeText(this, "Partida encontrada.", Toast.LENGTH_SHORT).show();
                    startActivity(w);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btn_exit_onClick(View v) {
        try {
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}