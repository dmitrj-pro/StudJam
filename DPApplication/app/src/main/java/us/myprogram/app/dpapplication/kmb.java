package us.myprogram.app.dpapplication;

import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class kmb extends AppCompatActivity {
    private int all;
    private int user;
    private int pad;
    private game p;
    private game _user;
    private boolean _view;
    private java.util.Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        p=new game();
        _view=false;
        _user=new game();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kmb);
        r=new Random();
    }
    public void updateCheats(){
        if(Menu.isWork){
            ImageView img=(ImageView) findViewById(R.id.imageView);
            if(_view){
                int N=p.getN();
                if(N==1){
                    img.setImageResource(R.drawable.kamen);
                }
                if (N==2){
                    img.setImageResource(R.drawable.bumaga);
                }
                if(N==0){
                    img.setImageResource(R.drawable.noschnizi);
                }
            } else {
                img.setImageResource(R.drawable.vop);
            }
        }
    }
    public void send(View view){
        Menu.send+=getString(R.string.kmi)+" "+Integer.toString(all)+" "+getString(R.string.kmi2)+" "+Integer.toString(this.user)+getString(R.string.kmi3)+" "+Integer.toString(pad)+".\n";
        Intent menu=new Intent(this, Send.class);
        startActivity(menu);
    }
    public void cheats(View view) {
        if (Menu.isWork) {
            _view = !_view;
            ImageView img = (ImageView) findViewById(R.id.imageView);
            if (_view) {
                int N = p.getN();
                if (N == 1) {
                    img.setImageResource(R.drawable.kamen);
                }
                if (N == 2) {
                    img.setImageResource(R.drawable.bumaga);
                }
                if (N == 0) {
                    img.setImageResource(R.drawable.noschnizi);
                }
            } else {
                img.setImageResource(R.drawable.vop);
            }
        }
    }
    public void run(){
        if(Menu.isHard){
            p=new game(_user.getN()+1);
        }
        int r=game.mensche(p,_user);
        all++;
        if(r==1){
            user++;
        }
        if(r==-1){
            pad++;
        }
        TextView data=(TextView)findViewById(R.id.kolall);
        data.setText(Integer.toString(all));
        data=(TextView)findViewById(R.id.koluser);
        data.setText(Integer.toString(user));
        data=(TextView)findViewById(R.id.kolpad);
        data.setText(Integer.toString(pad));
        if(!Menu.isHard){
            p=new game(this.r.nextInt(50));
        }
        this.updateCheats();
    }
    public void kamen(View view){
        _user=game.kamen();
        this.run();
    }
    public void nosch(View view){
        _user=game.noschnizi();
        this.run();
    }
    public void bumaga(View view){
        _user=game.bumaga();
        this.run();
    }
}

