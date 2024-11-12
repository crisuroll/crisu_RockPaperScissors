package com.example.practicappt;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.Scanner;

/* A FALTA DE
* - Cambiar TextView de Loading al encontrar un jugador.
* - Cambiar el ID de j_u1 por el nick de la otra tabla en los TextView
*/
public class Juego extends AppCompatActivity {
    Intent w;
    TextView found, p1, p2, winner;
    String u1, pa1, pa2;
    ImageButton rock, paper, scissors;
    InputStream j_u1, j_u2, su1, partida1, partida2;
    ImageView player1, player2;
    Button newB, exitB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        found = (TextView) findViewById(R.id.tv_playerfound);
        p1 = (TextView) findViewById(R.id.tv_player1);
        p2 = (TextView) findViewById(R.id.tv_player2);
        winner = (TextView) findViewById(R.id.tv_playerwinner);
        rock = (ImageButton) findViewById(R.id.imgbtn_r);
        paper = (ImageButton) findViewById(R.id.imgbtn_p);
        scissors = (ImageButton) findViewById(R.id.imgbtn_s);
        player1 = (ImageView) findViewById(R.id.img_player1);
        player2 = (ImageView) findViewById(R.id.img_player2);
        newB = findViewById(R.id.btn_new);
        exitB = findViewById(R.id.btn_exit2);
        newB.setVisibility(View.GONE);
        exitB.setVisibility(View.GONE);
        w = getIntent();
    }

    public void imgbtn_r_onClick(View v) {
        try {
            BBDD s1 = new BBDD();
            su1 = s1.bbdd("http://192.168.1.199:80/pptSELECTj_u1partidas.php");
            Scanner sc4 = new Scanner(su1);
            u1="null";
            while (sc4.hasNext()) {
                u1=sc4.nextLine();
            }

            if (u1.equals("null")) {
                BBDD j1 = new BBDD();
                j_u1 = j1.bbdd("http://192.168.1.199:80/pptINSERTj_u1.php?j_u1=" + 0);
                player1.setImageResource(R.drawable.ppt_r);
            } else {
                BBDD j2 = new BBDD();
                j_u2 = j2.bbdd("http://192.168.1.199:80/pptINSERTj_u2.php?j_u2=" + 0);
                player2.setImageResource(R.drawable.ppt_r);
            }
            paper.setClickable(false);
            paper.setEnabled(false);
            paper.setImageResource(R.drawable.ppt_p_bw);
            scissors.setClickable(false);
            scissors.setEnabled(false);
            scissors.setImageResource(R.drawable.ppt_s_bw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void imgbtn_p_onClick(View v) {
        try {
            BBDD s1 = new BBDD();
            su1 = s1.bbdd("http://192.168.1.199:80/pptSELECTj_u1partidas.php");
            Scanner sc4 = new Scanner(su1);
            u1="null";
            while (sc4.hasNext()) {
                u1=sc4.nextLine();
            }

            if (u1.equals("null")) {
                BBDD j1 = new BBDD();
                j_u1 = j1.bbdd("http://192.168.1.199:80/pptINSERTj_u1.php?j_u1=" + 1);
                player1.setImageResource(R.drawable.ppt_p);
            } else {
                BBDD j2 = new BBDD();
                j_u2 = j2.bbdd("http://192.168.1.199:80/pptINSERTj_u2.php?j_u2=" + 1);
                player2.setImageResource(R.drawable.ppt_p);
            }
            rock.setClickable(false);
            rock.setEnabled(false);
            rock.setImageResource(R.drawable.ppt_r_bw);
            scissors.setClickable(false);
            scissors.setEnabled(false);
            scissors.setImageResource(R.drawable.ppt_s_bw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void imgbtn_s_onClick(View v) {
        try {
            BBDD s1 = new BBDD();
            su1 = s1.bbdd("http://192.168.1.199:80/pptSELECTj_u1.php");
            Scanner sc4 = new Scanner(su1);
            u1="null";
            while (sc4.hasNext()) {
                u1=sc4.nextLine();
            }

            if (u1.equals("null")) {
                BBDD j1 = new BBDD();
                j_u1 = j1.bbdd("http://192.168.1.199:80/pptINSERTj_u1partidas.php?j_u1=" + 2);
                player1.setImageResource(R.drawable.ppt_s);
            } else {
                BBDD j2 = new BBDD();
                j_u2 = j2.bbdd("http://192.168.1.199:80/pptINSERTj_u2.php?j_u2=" + 2);
                player2.setImageResource(R.drawable.ppt_s);
            }
            rock.setClickable(false);
            rock.setEnabled(false);
            rock.setImageResource(R.drawable.ppt_r_bw);
            paper.setClickable(false);
            paper.setEnabled(false);
            paper.setImageResource(R.drawable.ppt_p_bw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //public void partida() {
        try {
            BBDD p1 = new BBDD();
            partida1 = p1.bbdd("http://192.168.1.199:80/pptSELECTresultado1.php");
            Scanner sc5 = new Scanner(partida1);
            pa1 = sc5.next().toString();
            BBDD p2 = new BBDD();
            partida2 = p2.bbdd("http://192.168.1.199:80/pptSELECTresultado2.php");
            Scanner sc6 = new Scanner(partida2);
            pa1 = sc6.next().toString();
            newB.setVisibility(View.VISIBLE);
            exitB.setVisibility(View.VISIBLE);

            if (pa1.equals("0")) {
                if (pa2.equals("1")) {
                    //gana pa2
                    winner.setText(pa2);
                } else {
                    //gana pa1
                    winner.setText(pa1);
                }
            } else if (pa1.equals("1")) {
                if (pa2.equals("2")) {
                    //gana pa2
                    winner.setText(pa2);
                } else {
                    //gana pa1
                    winner.setText(pa1);
                }
            } else if (pa1.equals("2")) {
                if (pa2.equals("0")) {
                    //gana pa2
                    winner.setText(pa2);
                } else {
                    //gana pa1
                    winner.setText(pa1);
                }
            } else if (pa1.equals(pa2)) {
                winner.setText("EMPATE");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    //}

    public void btn_new_onClick(View v) {
        recreate();
    }

    public void btn_exit2_onClick(View v) {
        finish();
    }
}
