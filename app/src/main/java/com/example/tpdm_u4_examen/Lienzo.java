package com.example.tpdm_u4_examen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Lienzo extends View {
    CountDownTimer timer;
    Context context;
    Reloj reloj;
    Hora hora1;
    Hora hora2;
    boolean toqueHora1 = false;
    boolean toqueHora2 = false;
    String frase = "";
    int nivel = 1;
    Canvas canvas;
    boolean perder = false;
    boolean ganar = false;
    String nivelTxt = "";
    boolean juegoTerminado = false;

    public Lienzo(final Context context) {
        super(context);
        this.context = context;

        //Reloj del juego
        reloj = new Reloj();
        final int[] tiempoContador = {0};
        //Contador para salir del juego
        final int[] contadorSalir = {0};

        timer=new CountDownTimer(1500,60) {
            @Override
            public void onTick(long l) {
                tiempoContador[0]++;
                if(reloj.segundos>0){
                    if(tiempoContador[0] == 10){
                        reloj.segundos--;
                        tiempoContador[0] = 0;
                    }
                }
                if(juegoTerminado == false){
                    invalidate();
                }

            }

            @Override
            public void onFinish() {
                timer.start();
            }
        }.start();
    }

    @Override
    public void onDraw(Canvas canvas){
        if(perder == true){
            juegoPerdido(canvas);
            return;
        }
        if(ganar == true){
            juegoGanado(canvas);
        }

        //Si se agota el tiempo
        if(reloj.segundos == 0){
            juegoPerdido(canvas);
            return;
        }
        switch (nivel){
            case 1:
                nivel1(canvas);
                break;

            case 2:
                nivel2(canvas);
                break;

            case 3:
                nivel3(canvas);
                break;

            case 4:
                nivel4(canvas);
                break;

            case 5:
                nivel5(canvas);
                break;

            case 6:
                nivel6(canvas);
                break;
        }

        mostrarTablero(canvas);
    }

    //hora corecta 6:45
    public void nivel1(Canvas canvas){
        nivelTxt = "Nivel 1";
        frase = "hoy a las 5:45 tenemos partido de futbol";
        Paint p=new Paint();
        Bitmap imgHora1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.seiscuarentacinco);
        float horaX = 150;
        float horaY = 20;
        hora1 = new Hora(imgHora1,horaX,horaY,true);
        canvas.drawBitmap(hora1.img, hora1.horaX, hora1.horaY, p);

        Paint p1=new Paint();
        Bitmap imgHora2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.dosvsiete);
        horaX = 150;
        horaY = 850;
        hora2 = new Hora(imgHora2,horaX,horaY,false);

        canvas.drawBitmap(hora2.img, hora2.horaX, hora2.horaY, p1);
    }


    //hora corecta 2:30
    public void nivel2(Canvas canvas){
        nivelTxt = "Nivel 2";
        frase = "A las 2:30 es la hora de la comida ";
        Paint p=new Paint();
        Bitmap imgHora1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.seiscuarentacinco);
        float horaX = 150;
        float horaY = 20;
        hora1 = new Hora(imgHora1,horaX,horaY,false);
        canvas.drawBitmap(hora1.img, hora1.horaX, hora1.horaY, p);

        Paint p1=new Paint();
        Bitmap imgHora2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.dostreinta);
        horaX = 150;
        horaY = 850;
        hora2 = new Hora(imgHora2,horaX,horaY,true);

        canvas.drawBitmap(hora2.img, hora2.horaX, hora2.horaY, p1);
    }

    //hora corecta 7:00
    public void nivel3(Canvas canvas){
        nivelTxt = "Nivel 3";
        frase = "A las 7:00 es la hora de la cena";
        Paint p=new Paint();
        Bitmap imgHora1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.siete);
        float horaX = 150;
        float horaY = 20;
        hora1 = new Hora(imgHora1,horaX,horaY,true);
        canvas.drawBitmap(hora1.img, hora1.horaX, hora1.horaY, p);

        Paint p1=new Paint();
        Bitmap imgHora2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.unatreinta);
        horaX = 150;
        horaY = 850;
        hora2 = new Hora(imgHora2,horaX,horaY,false);

        canvas.drawBitmap(hora2.img, hora2.horaX, hora2.horaY, p1);
    }

    //hora corecta 1:25
    public void nivel4(Canvas canvas){
        nivelTxt = "Nivel 4";
        frase = "A las 1:25 empieza la pelicula";
        Paint p=new Paint();
        Bitmap imgHora1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.unavcinco);
        float horaX = 150;
        float horaY = 20;
        hora1 = new Hora(imgHora1,horaX,horaY,true);
        canvas.drawBitmap(hora1.img, hora1.horaX, hora1.horaY, p);

        Paint p1=new Paint();
        Bitmap imgHora2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.dostreinta);
        horaX = 150;
        horaY = 850;
        hora2 = new Hora(imgHora2,horaX,horaY,false);

        canvas.drawBitmap(hora2.img, hora2.horaX, hora2.horaY, p1);
    }

    //hora corecta 8:15
    public void nivel5(Canvas canvas){
        nivelTxt = "Nivel 5";
        frase = "A las 8:15 empiezan pokemon ";
        Paint p=new Paint();
        Bitmap imgHora1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.ochoquince);
        float horaX = 150;
        float horaY = 20;
        hora1 = new Hora(imgHora1,horaX,horaY,true);
        canvas.drawBitmap(hora1.img, hora1.horaX, hora1.horaY, p);

        Paint p1=new Paint();
        Bitmap imgHora2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.dostreinta);
        horaX = 150;
        horaY = 850;
        hora2 = new Hora(imgHora2,horaX,horaY,false);

        canvas.drawBitmap(hora2.img, hora2.horaX, hora2.horaY, p1);
    }

    //hora corecta 2;27
    public void nivel6(Canvas canvas){
        nivelTxt = "Nivel 6";
        frase = "A las 2:27 es la hora que sales de la escuela ";
        Paint p=new Paint();
        Bitmap imgHora1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.unatcinco);
        float horaX = 150;
        float horaY = 20;
        hora1 = new Hora(imgHora1,horaX,horaY,false);
        canvas.drawBitmap(hora1.img, hora1.horaX, hora1.horaY, p);

        Paint p1=new Paint();
        Bitmap imgHora2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.dosvsiete);
        horaX = 150;
        horaY = 850;
        hora2 = new Hora(imgHora2,horaX,horaY,true);

        canvas.drawBitmap(hora2.img, hora2.horaX, hora2.horaY, p1);
    }

    public void mostrarTablero(Canvas canvas){
        Paint pTexto=new Paint();
        //Segundos
        pTexto.setTextSize(50);
        pTexto.setColor(Color.rgb(0,0,0));
        canvas.drawText(String.valueOf(reloj.segundos),450,1750,pTexto);
        //Nivel
        pTexto.setTextSize(50);
        pTexto.setColor(Color.rgb(0,0,0));
        canvas.drawText(nivelTxt,400,1830,pTexto);
        //Frase
        pTexto.setTextSize(50);
        pTexto.setColor(Color.rgb(0,0,0));
        canvas.drawText(frase,80,1920,pTexto);
    }

    public boolean onTouchEvent(MotionEvent e){

        switch (e.getAction()){

            case MotionEvent.ACTION_DOWN:
                float toqueX=e.getX();
                float toqueY=e.getY();

                if(hora1.fueTocada(toqueX,toqueY)){
                    toqueHora1 = true;
                    if(hora1.correcta == true){
                        aumentarNivel();
                    }
                    else{
                        perder = true;
                    }
                }
                if(hora2.fueTocada(toqueX,toqueY)){
                    toqueHora2 = true;
                    if(hora2.correcta == true){
                        aumentarNivel();
                    }
                    else{
                        perder = true;
                    }
                }
                break;

            default:
                break;
        }
        return true;
    }

    public void aumentarNivel(){
        if(nivel < 7){
            nivel ++;
            reloj.segundos = 20;
        }
        if(nivel == 7){
            ganar = true;
        }
    }

    public void juegoPerdido(Canvas canvas){
        Paint pTexto=new Paint();
        //Segundos
        pTexto.setTextSize(70);
        pTexto.setColor(Color.rgb(255,0,0));
        canvas.drawText("Incorrecto, has perdido",50,800,pTexto);
        Toast.makeText(context,"Incorrecto, has perdido",Toast.LENGTH_LONG).show();
        Intent pantallaMain = new Intent(context,MainActivity.class);
        context.startActivity(pantallaMain);
        juegoTerminado = true;
    }

    public void juegoGanado(Canvas canvas){
        Paint pTexto=new Paint();
        //Segundos
        pTexto.setTextSize(70);
        pTexto.setColor(Color.rgb(0,255,0));
        canvas.drawText("Felicidades, ganaste el juego",50,800,pTexto);
        Toast.makeText(context,"Felicidades, ganaste el juego",Toast.LENGTH_LONG).show();
        Intent pantallaMain = new Intent(context,MainActivity.class);
        context.startActivity(pantallaMain);
        juegoTerminado = true;
    }

}
