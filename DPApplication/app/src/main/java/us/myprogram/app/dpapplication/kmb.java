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
    public void UpdateCheats(){
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
        Menu.Send+=getString(R.string.kmi)+" "+Integer.toString(all)+" "+getString(R.string.kmi2)+" "+Integer.toString(this.user)+getString(R.string.kmi3)+" "+Integer.toString(pad)+".\n";
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
        this.UpdateCheats();
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

class game{
    private int N;
    public game(){

    }
    public game(int N){
        while(N>=3){
            N-=3;
        }
        this.N=N;
    }
    public static game kamen(){
        game t=new game();
        t.N=1;
        return t;
    }
    public static game bumaga(){
        game t=new game();
        t.N=2;
        return t;
    }
    public static game noschnizi(){
        game t=new game();
        t.N=0;
        return t;
    }
    public static int mensche(game g1,game g2){
        int N1=g1.N;
        int N2=g2.N;
        if((N1==0)||(N2==0)){
            if(N1==0){
                if(N2==2){
                    return -1;
                }
            }
            if(N2==0){
                if(N1==2){
                    return 1;
                }
            }
        }
        if(N2-N1==1){
            return 1;
        }
        if(N2==N1){
            return 0;
        }
        return -1;
    }
    public int getN(){
        return N;
    }
}
