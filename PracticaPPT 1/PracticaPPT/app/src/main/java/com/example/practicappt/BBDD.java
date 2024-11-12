package com.example.practicappt;

import android.renderscript.ScriptGroup;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BBDD {
    InputStream datos;

    public InputStream bbdd(String cadena) {
        try {
            URL url = new URL(cadena);
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            datos = urlcon.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }
}
