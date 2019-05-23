package com.example.tpdm_u4_examen;

import android.graphics.Bitmap;

public class Hora {
    Bitmap img;
    float horaX;
    float horaY;
    boolean correcta;


    public Hora(Bitmap img, float horaX, float horaY, boolean correcta){
        this.img = img;
        this.horaX = horaX;
        this.horaY = horaY;
        this.correcta = correcta;
    }

    public boolean fueTocada(float toqueX,float toqueY){
        if( toqueX > horaX  && toqueX < (horaX + img.getWidth() )){

            if( toqueY > horaY  && toqueY < (horaY + img.getWidth() )){
                return true;
            }
        }
        return false;
    }
}
