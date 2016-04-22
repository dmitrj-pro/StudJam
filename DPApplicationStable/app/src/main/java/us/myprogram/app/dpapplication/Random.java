package us.myprogram.app.dpapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.Calendar;
import java.util.Date;

public class Random extends AppCompatActivity {
    //1- generate Int
    //2 - generate double
    //3 - generate boolean
    //4 - generate string
    //5 - Сложный вопрос
    protected int rem;
    private int RandVopr;
    protected java.util.Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);
        r=new java.util.Random();
        if(!Menu.isWork) {
            RandVopr = r.nextInt() % 1023;
        }
    }
    private int randInt(int min,int max){
        int res=0;
        if((max-min)<0){
            res=(-1)*r.nextInt((-1)*(max-min));
            res+=min;
        } else {
            res = r.nextInt(max - min) + min;
        }
        return res;
    }
    public void gen(View view){
        TextView out = (TextView) findViewById(R.id.generator);
        if(rem==1) {
            CheckBox ch = (CheckBox) findViewById(R.id.gran);
            if (ch.isChecked()) {
                int min = Integer.parseInt(((EditText) findViewById(R.id.min)).getText().toString());
                int max = Integer.parseInt(((EditText) findViewById(R.id.max)).getText().toString());
                out.setText(Integer.toString(this.randInt(min, max)));
            } else {
                out.setText(Integer.toString(r.nextInt()));
            }
            return;
        }
        if(rem==2) {
            CheckBox ch = (CheckBox) findViewById(R.id.gran);
            if (ch.isChecked()) {
                int min = Integer.parseInt(((EditText) findViewById(R.id.min)).getText().toString());
                int max = Integer.parseInt(((EditText) findViewById(R.id.max)).getText().toString());
                out.setText(Integer.toString(this.randInt(min, max-1))+Double.toString(r.nextDouble()).substring(1));
            } else {
                out.setText(Integer.toString(r.nextInt())+Double.toString(r.nextDouble()));
            }
            return;
        }
        if(rem==3){
            boolean b=r.nextBoolean();
            out.setText(Boolean.toString(b));
            return;
        }
        if(rem==4){
            EditText ed=(EditText)findViewById(R.id.leng);
            String rand="";
            int len=0;
            if(ed.getText().toString().length()>0){
                rand=ed.getText().toString();
                EditText tm=(EditText)findViewById(R.id.max);
                int min=0;
                int max=0;
                if(tm.getText().length()==0){
                    max=10;
                } else {
                    max = Integer.parseInt(tm.getText().toString());
                }
                tm=(EditText)findViewById(R.id.min);
                if(tm.getText().length()==0){
                    min=0;
                } else {
                    min = Integer.parseInt(tm.getText().toString());
                }
                len=this.randInt(min, max);

            } else {
                rand=getString(R.string.rand_num)+getString(R.string.rand_spec)+getString(R.string.rand_string)+getString(R.string.Rand_string);
                rand+=getString(R.string.rand_language)+getString(R.string.Rand_language);
                len=r.nextInt(100);
            }
            final int length=rand.length();
            String res="";
            for(int i=0;i<len;i++){
                res+=rand.charAt(this.randInt(0,length));
            }
            out.setText(res);
            return;
        }
        if(rem==5){
            String str=((EditText)findViewById(R.id.max)).getText().toString();
            int res=RandVopr;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)==' '){
                    continue;
                }
                int tmp=(int)str.charAt(i);
                res+=tmp*(i+1);
            }
            Calendar c=Calendar.getInstance();
            Date dd=c.getTime();
            res-=5*dd.getDay();
            res*=dd.getMonth();
            res-=dd.getYear();
            res=res%2;
            if(res==1){
                str=getResources().getString(R.string.yes);
            }
            if(res==0){
                str=getResources().getString(R.string.no);
            }
            out.setText(str);
            return;
        }
    }
    private void Clear(){
        CheckBox t=(CheckBox)findViewById(R.id.integer);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.real);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.bool);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.vopr);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.str);
        t.setChecked(false);
        findViewById(R.id.gran).setVisibility(View.INVISIBLE);
        t=(CheckBox)findViewById(R.id.gran);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.tmp2);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.tmp3);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.tmp4);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.tmp5);
        t.setChecked(false);
        t=(CheckBox)findViewById(R.id.tmp6);
        t.setChecked(false);
        findViewById(R.id.bgen).setVisibility(View.INVISIBLE);
        findViewById(R.id.generator).setVisibility(View.INVISIBLE);
        findViewById(R.id.min).setVisibility(View.INVISIBLE);
        findViewById(R.id.tmin).setVisibility(View.INVISIBLE);
        findViewById(R.id.tmax).setVisibility(View.INVISIBLE);
        findViewById(R.id.max).setVisibility(View.INVISIBLE);
        findViewById(R.id.tmp2).setVisibility(View.INVISIBLE);
        findViewById(R.id.tmp3).setVisibility(View.INVISIBLE);
        findViewById(R.id.tmp4).setVisibility(View.INVISIBLE);
        findViewById(R.id.tmp6).setVisibility(View.INVISIBLE);
        findViewById(R.id.tmp5).setVisibility(View.INVISIBLE);
        findViewById(R.id.leng).setVisibility(View.INVISIBLE);
        findViewById(R.id.length).setVisibility(View.INVISIBLE);
        findViewById(R.id.sending).setVisibility(View.INVISIBLE);
        RelativeLayout.LayoutParams p=(RelativeLayout.LayoutParams)findViewById(R.id.gran).getLayoutParams();
        p.addRule(RelativeLayout.BELOW, R.id.vopr);
        p=(RelativeLayout.LayoutParams)findViewById(R.id.generator).getLayoutParams();
        p.addRule(RelativeLayout.BELOW,R.id.gran);
        {
            EditText ed=(EditText)findViewById(R.id.max);
            ed.setText("");
            ed=(EditText)findViewById(R.id.min);
            ed.setText("");
        }
    }
    public void gran(View view){
        CheckBox chec=(CheckBox)findViewById(R.id.gran);
        if(chec.isChecked()) {
            if ((rem == 1)||(rem==2)) {
                //set Text
                TextView tmp = (TextView) findViewById(R.id.tmin);
                tmp.setText(getResources().getString(R.string.rmin));
                tmp = (TextView) findViewById(R.id.tmax);
                tmp.setText(getResources().getString((R.string.rmax)));
                EditText etmp=(EditText)findViewById(R.id.min);
                etmp.setInputType(InputType.TYPE_CLASS_NUMBER);
                etmp=(EditText)findViewById(R.id.max);
                etmp.setInputType(InputType.TYPE_CLASS_NUMBER);
                //visible text
                findViewById(R.id.tmin).setVisibility(View.VISIBLE);
                findViewById(R.id.tmax).setVisibility(View.VISIBLE);
                findViewById(R.id.min).setVisibility(View.VISIBLE);
                findViewById(R.id.max).setVisibility(View.VISIBLE);
                //Set Bellow
                RelativeLayout.LayoutParams g = (RelativeLayout.LayoutParams) findViewById(R.id.tmin).getLayoutParams();
                g.addRule(RelativeLayout.BELOW, R.id.gran);
                g = (RelativeLayout.LayoutParams) findViewById(R.id.min).getLayoutParams();
                g.addRule(RelativeLayout.BELOW, R.id.tmin);

                g = (RelativeLayout.LayoutParams) findViewById(R.id.tmax).getLayoutParams();
                g.addRule(RelativeLayout.BELOW, R.id.min);
                g = (RelativeLayout.LayoutParams) findViewById(R.id.max).getLayoutParams();
                g.addRule(RelativeLayout.BELOW, R.id.tmax);

                g = (RelativeLayout.LayoutParams) findViewById(R.id.generator).getLayoutParams();
                g.addRule(RelativeLayout.BELOW, R.id.max);
                return;
            }
            if (rem==4){
                EditText tmp=(EditText)findViewById(R.id.leng);
                tmp.setText(tmp.getText()+getString(R.string.Rand_language));
            }
        }else {
            if((rem==1)||(rem==2)){
                RelativeLayout.LayoutParams p=(RelativeLayout.LayoutParams)findViewById(R.id.generator).getLayoutParams();
                p.addRule(RelativeLayout.BELOW, R.id.gran);
                findViewById(R.id.min).setVisibility(View.INVISIBLE);
                findViewById(R.id.tmin).setVisibility(View.INVISIBLE);
                findViewById(R.id.tmax).setVisibility(View.INVISIBLE);
                findViewById(R.id.max).setVisibility(View.INVISIBLE);
            }
            if(rem==4){
                EditText tmp=(EditText)findViewById(R.id.leng);
                String str=tmp.getText().toString();
                int tmps=str.indexOf(getString(R.string.Rand_language));
                str=str.substring(0,tmps)+str.substring(tmps+getString(R.string.Rand_language).length());
                tmp.setText(str);
            }
        }
    }
    public void integer(View view){
        this.Clear();
        rem=1;
        CheckBox t=(CheckBox)findViewById(R.id.integer);
        t.setChecked(true);
        findViewById(R.id.gran).setVisibility(View.VISIBLE);
        t=(CheckBox)findViewById(R.id.gran);
        t.setText(getResources().getString(R.string.rgran));

        findViewById(R.id.bgen).setVisibility(View.VISIBLE);
        findViewById(R.id.generator).setVisibility(View.VISIBLE);
        findViewById(R.id.sending).setVisibility(View.VISIBLE);
    }
    public void real(View view){
        Clear();
        rem=2;
        CheckBox t=(CheckBox)findViewById(R.id.real);
        t.setChecked(true);
        findViewById(R.id.gran).setVisibility(View.VISIBLE);
        t=(CheckBox)findViewById(R.id.gran);
        t.setText(getResources().getString(R.string.rgran));

        findViewById(R.id.bgen).setVisibility(View.VISIBLE);
        findViewById(R.id.generator).setVisibility(View.VISIBLE);
        findViewById(R.id.sending).setVisibility(View.VISIBLE);
    }
    public void bool(View view){
        Clear();
        rem=3;
        CheckBox t=(CheckBox)findViewById(R.id.bool);
        t.setChecked(true);
        RelativeLayout.LayoutParams p=(RelativeLayout.LayoutParams)findViewById(R.id.generator).getLayoutParams();
        p.addRule(RelativeLayout.BELOW, R.id.vopr);
        findViewById(R.id.bgen).setVisibility(View.VISIBLE);
        findViewById(R.id.generator).setVisibility(View.VISIBLE);
        findViewById(R.id.sending).setVisibility(View.VISIBLE);
    }
    public void string(View view){
        ((EditText)findViewById(R.id.leng)).setText("");
        Clear();
        rem=4;
        CheckBox t=(CheckBox)findViewById(R.id.str);
        t.setChecked(true);

        TextView tmp = (TextView) findViewById(R.id.tmin);
        tmp.setText(getResources().getString(R.string.rminlength));
        tmp = (TextView) findViewById(R.id.tmax);
        tmp.setText(getResources().getString((R.string.rmaxlength)));
        EditText etmp=(EditText)findViewById(R.id.min);
        etmp.setInputType(InputType.TYPE_CLASS_NUMBER);
        etmp=(EditText)findViewById(R.id.max);
        etmp.setInputType(InputType.TYPE_CLASS_NUMBER);
        tmp=(TextView)findViewById(R.id.length);
        tmp.setText(R.string.rsymbol);
        etmp=(EditText)findViewById(R.id.leng);
        etmp.setText("");
        etmp.setInputType(InputType.TYPE_CLASS_TEXT);
        t=(CheckBox)findViewById(R.id.gran);
        t.setText(getString(R.string.Rand_str_language));
        t=(CheckBox)findViewById(R.id.tmp2);
        t.setText(getString(R.string.rand_str_language));
        t=(CheckBox)findViewById(R.id.tmp3);
        t.setText(getString(R.string.Rand_str));
        t=(CheckBox)findViewById(R.id.tmp4);
        t.setText(getString(R.string.rand_str));
        t=(CheckBox)findViewById(R.id.tmp5);
        t.setText(getString(R.string.rand_num_str));
        t=(CheckBox)findViewById(R.id.tmp6);
        t.setText(getString(R.string.rand_spec_str));

        //visible text
        findViewById(R.id.tmin).setVisibility(View.VISIBLE);
        findViewById(R.id.tmp2).setVisibility(View.VISIBLE);
        findViewById(R.id.tmp3).setVisibility(View.VISIBLE);
        findViewById(R.id.tmp4).setVisibility(View.VISIBLE);
        findViewById(R.id.tmp5).setVisibility(View.VISIBLE);
        findViewById(R.id.tmp6).setVisibility(View.VISIBLE);
        findViewById(R.id.gran).setVisibility(View.VISIBLE);
        findViewById(R.id.leng).setVisibility(View.VISIBLE);
        findViewById(R.id.length).setVisibility(View.VISIBLE);
        findViewById(R.id.tmax).setVisibility(View.VISIBLE);
        findViewById(R.id.min).setVisibility(View.VISIBLE);
        findViewById(R.id.max).setVisibility(View.VISIBLE);
        //Set Bellow

        RelativeLayout.LayoutParams g = (RelativeLayout.LayoutParams) findViewById(R.id.tmin).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.vopr);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.min).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.tmin);

        g = (RelativeLayout.LayoutParams) findViewById(R.id.tmax).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.min);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.max).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.tmax);

        g = (RelativeLayout.LayoutParams) findViewById(R.id.gran).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.max);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.tmp2).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.gran);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.tmp3).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.tmp2);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.tmp4).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.tmp3);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.tmp5).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.tmp4);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.tmp6).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.tmp5);

        g = (RelativeLayout.LayoutParams) findViewById(R.id.length).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.tmp6);
        g = (RelativeLayout.LayoutParams) findViewById(R.id.leng).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.length);


        g = (RelativeLayout.LayoutParams) findViewById(R.id.generator).getLayoutParams();
        g.addRule(RelativeLayout.BELOW, R.id.leng);

        findViewById(R.id.bgen).setVisibility(View.VISIBLE);
        findViewById(R.id.generator).setVisibility(View.VISIBLE);
        findViewById(R.id.sending).setVisibility(View.VISIBLE);
    }
    public void send(View view){
        TextView out = (TextView) findViewById(R.id.generator);
        switch (rem){
            case 1:
            case 2:
                Menu.Send+=getText(R.string.rsendInt)+"\n"+out.getText();
                break;
            case 3:
                Menu.Send+=getText(R.string.rsendBool)+"\n"+out.getText();
                break;
            case 4:
                Menu.Send+=getText(R.string.rsendString)+"\n"+out.getText();
                break;
            case 5:
                Menu.Send+=getText(R.string.rsendVopr)+"'";
                String vopr=((EditText)findViewById(R.id.max)).getText().toString();
                Menu.Send+=vopr;
                /*if(!(vopr.charAt(vopr.length()-1)=='?')){
                    Menu.Send+="?";
                }*/
                Menu.Send+="':";
                Menu.Send+="\n"+out.getText();
                break;
        }
        Menu.Send+="\n";
        Intent menu=new Intent(this, Send.class);
        startActivity(menu);
    }
    public void Ctmp2(View view){
        CheckBox ch=(CheckBox)findViewById(R.id.tmp2);
        if(!ch.isChecked()){
            EditText tmp=(EditText)findViewById(R.id.leng);
            String str=tmp.getText().toString();
            int tmps=str.indexOf(getString(R.string.rand_language));
            str=str.substring(0,tmps)+str.substring(tmps+getString(R.string.rand_language).length());
            tmp.setText(str);
        } else {
            EditText tmp = (EditText) findViewById(R.id.leng);
            tmp.setText(tmp.getText() + getString(R.string.rand_language));
        }
    }
    public void Ctmp3(View view){
        CheckBox ch=(CheckBox)findViewById(R.id.tmp3);
        if(!ch.isChecked()){
            EditText tmp=(EditText)findViewById(R.id.leng);
            String str=tmp.getText().toString();
            int tmps=str.indexOf(getString(R.string.Rand_string));
            str=str.substring(0,tmps)+str.substring(tmps+getString(R.string.Rand_string).length());
            tmp.setText(str);
        } else {
            EditText tmp = (EditText) findViewById(R.id.leng);
            tmp.setText(tmp.getText() + getString(R.string.Rand_string));
        }
    }
    public void Ctmp4(View view){
        CheckBox ch=(CheckBox)findViewById(R.id.tmp4);
        if(!ch.isChecked()){
            EditText tmp=(EditText)findViewById(R.id.leng);
            String str=tmp.getText().toString();
            int tmps=str.indexOf(getString(R.string.rand_string));
            str=str.substring(0,tmps)+str.substring(tmps+getString(R.string.rand_string).length());
            tmp.setText(str);
        } else {
            EditText tmp = (EditText) findViewById(R.id.leng);
            tmp.setText(tmp.getText() + getString(R.string.rand_string));
        }
    }
    public void Ctmp5(View view){
        CheckBox ch=(CheckBox)findViewById(R.id.tmp5);
        if(!ch.isChecked()){
            EditText tmp=(EditText)findViewById(R.id.leng);
            String str=tmp.getText().toString();
            int tmps=str.indexOf(getString(R.string.rand_num));
            str=str.substring(0,tmps)+str.substring(tmps+getString(R.string.rand_num).length());
            tmp.setText(str);
        } else {
            EditText tmp = (EditText) findViewById(R.id.leng);
            tmp.setText(tmp.getText() + getString(R.string.rand_num));
        }
    }
    public void Ctmp6(View view){
        CheckBox ch=(CheckBox)findViewById(R.id.tmp6);
        if(!ch.isChecked()){
            EditText tmp=(EditText)findViewById(R.id.leng);
            String str=tmp.getText().toString();
            int tmps=str.indexOf(getString(R.string.rand_spec));
            str=str.substring(0,tmps)+str.substring(tmps+getString(R.string.rand_spec).length());
            tmp.setText(str);
        } else {
            EditText tmp = (EditText) findViewById(R.id.leng);
            tmp.setText(tmp.getText() + getString(R.string.rand_spec));
        }
    }
    public void vopr(View view){
        Clear();
        rem=5;
        CheckBox t=(CheckBox)findViewById(R.id.vopr);
        t.setChecked(true);

        {
            EditText etmp=(EditText)findViewById(R.id.max);
            etmp.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        {
            TextView tmp=(TextView)findViewById(R.id.tmax);
            tmp.setText(getResources().getString(R.string.rinput_vopr));
        }
        RelativeLayout.LayoutParams p=(RelativeLayout.LayoutParams)findViewById(R.id.tmax).getLayoutParams();
        p.addRule(RelativeLayout.BELOW, R.id.vopr);
        p=(RelativeLayout.LayoutParams)findViewById(R.id.max).getLayoutParams();
        p.addRule(RelativeLayout.BELOW, R.id.tmax);
        p=(RelativeLayout.LayoutParams)findViewById(R.id.generator).getLayoutParams();
        p.addRule(RelativeLayout.BELOW, R.id.max);
        findViewById(R.id.tmax).setVisibility(View.VISIBLE);
        findViewById(R.id.max).setVisibility(View.VISIBLE);
        findViewById(R.id.bgen).setVisibility(View.VISIBLE);
        findViewById(R.id.generator).setVisibility(View.VISIBLE);
        findViewById(R.id.sending).setVisibility(View.VISIBLE);

    }
}

