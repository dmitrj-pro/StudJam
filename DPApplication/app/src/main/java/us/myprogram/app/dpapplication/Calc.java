package us.myprogram.app.dpapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class Calc extends AppCompatActivity {
    protected String str;
    static public TreeMap<String,Integer> data;
    protected boolean op;
    private int index;
    public static int sch=16;
    public static String toS(double x){
        if(!Menu.isHard) {
            String res = "";
            long tmp = (int) Math.floor(x);
            boolean osMin=tmp<0;
            if(osMin){
                tmp=Math.abs(tmp);
            }
            while (tmp > 0) {
                long tm=tmp%sch;
                for(Map.Entry<String, Integer> et:data.entrySet()) {
                    if (et.getValue() == tm) {
                        res = et.getKey() + res;
                        break;
                    }
                }
                tmp /= sch;
            }
            if(osMin){
                res="-"+res;
            }
            return res;
        }
        return Double.toString(x);
    }
    public static double toD(String K){
        if(Menu.isHard){
            return Double.parseDouble(K);
        }
        double kk=0;
        for(int i=0;i<K.length();i++){
            String g=""+K.charAt(i);
            if(!data.containsKey(g)){
                throw new ExceptionInInitializerError("dd");
            }
            kk=kk*sch+data.get(g);
        }
        /*double res=0;
        int tmp=(int)Math.round(kk);
        int k=1;
        while(tmp>0){
            res+=k*(tmp%10);
            k*=sch;
            tmp/=10;
        }*/
        return kk;
    }

    public Calc(){
        str="";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        if(Menu.isWork){
            EditText e = (EditText)findViewById(R.id.edit);
            e.setVisibility(View.VISIBLE);
            findViewById(R.id.sedit).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.edit).setVisibility(View.INVISIBLE);
            findViewById(R.id.sedit).setVisibility(View.VISIBLE);
        }
        Calc.data=new TreeMap<String,Integer>();
        Calc.data.put("1",1);
        Calc.data.put("0",0);
        Calc.data.put("2",2);
        this.index=0;
        Calc.data.put("3",3);
        Calc.data.put("4",4);
        Calc.data.put("5",5);
        Calc.data.put("6",6);
        Calc.data.put("7",7);
        Calc.data.put("8",8);
        Calc.data.put("9",9);
        Calc.data.put("A",10);
        Calc.data.put("B",11);
        Calc.data.put("C",12);
        Calc.data.put("D",13);
        Calc.data.put("E",14);
        Calc.data.put("F",15);


        //this.UpdateButton();
        //this.UpdateSCH();
    }
    public void updateText(String strin){
        TextView f=(TextView)findViewById(R.id.sedit);
        String tmp=str.substring(0,this.index)+"|"+str.substring(this.index);
        f.setText(tmp + strin);
        EditText g=(EditText)findViewById(R.id.edit);
        g.setText(tmp + strin);
    }
    public void updateText(){
        this.updateText("");
    }
    public void back(View view){
        finish();
    }
    private void click_number(String st){
        if(op){
            op=false;
        }
        str=str.substring(0,index)+st+str.substring(index);
        index++;
        updateText();
    }
    public void key_1(View view){
        click_number("1");
    }
    public void key_2(View view){
        click_number("2");
    }
    public void key_3(View view){
        click_number("3");
    }
    public void key_4(View view){
        click_number("4");
    }
    public void key_5(View view){
        click_number("5");
    }
    public void key_6(View view){
        click_number("6");
    }
    public void key_7(View view){
        click_number("7");
    }
    public void key_8(View view){
        click_number("8");
    }
    public void key_9(View view){
        click_number("9");
    }
    public void key_0(View view){
        click_number("0");
    }
    public void key_A(View view){
        click_number("A");
    }
    public void key_B(View view){
        click_number("B");
    }
    public void key_C(View view){
        click_number("C");
    }
    public void key_D(View view){
        click_number("D");
    }
    public void key_E(View view){
        click_number("E");
    }
    public void key_F(View view){
        click_number("F");
    }
    public void key_so(View view){
        if(index!=str.length()){
            str=str.substring(0,index)+"("+str.substring(index);
            index++;
            updateText();
            return;
        }
        if(op){
            str=str.substring(0,index)+"("+str.substring(index)+")";
            index++;
            updateText();
            op=false;
        }
    }
    public void key_sc(View view){
        if(index!=str.length()){
            str=str.substring(0,index)+")"+str.substring(index);
            index++;
            updateText();
            return;
        }
    }
    public void key_r(View view){
        EditText f=(EditText)findViewById(R.id.edit);
        TextView g=(TextView) findViewById(R.id.sedit);
        if(Menu.isWork){
            str=f.getText().toString();
        }
        double res=0;
        try {
            res = ExpressionEstimator.calculate(str);

        } catch (Exception e){

        }
        f.setText(Calc.toS(res));
        g.setText(Calc.toS(res));
    }
    private void key_operator(String st){
        if(index!=str.length()){
            str=str.substring(0,index)+st+str.substring(index);
            index++;
            updateText();
            return;
        }
        if(op){
            for(int i=str.length()-1; i>=0;i++){
                try {
                    char c = str.charAt(i);
                } catch (Exception ee){
                    str=str.substring(0,i-1);
                    str+=st;
                    break;
                }
            }
        } else {
            str+=st;
            index+=1;
        }
        op=true;
        updateText();
    }
    public void key_m(View view){
        this.key_operator("-");
    }
    public void key_u(View view){
        this.key_operator("*");
    }
    public void sm(View view){
        if(Calc.sch>2){
            double res=this.Convert_1();
            sch--;
            this.UpdateButton();
            this.UpdateSCH();
            str=Calc.toS(res);
            index=str.length();
            this.updateText();
        }
    }
    private void UpdateSCH(){
        TextView tr=(TextView)findViewById(R.id.ssch);
        tr.setText(Integer.toString(Calc.sch));
    }
    private double Convert_1(){
        EditText f=(EditText)findViewById(R.id.edit);
        if(Menu.isWork){
            str=f.getText().toString();
        }
        try {
            return ExpressionEstimator.calculate(str);

        } catch (Exception e){

        }
        return 0;
    }
    private void UpdateButton(){
        if(sch<16){
            findViewById(R.id.kF).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.kF).setVisibility(View.VISIBLE);
        }
        if(sch<15){
            findViewById(R.id.kE).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.kE).setVisibility(View.VISIBLE);
        }
        if(sch<14){
            findViewById(R.id.kD).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.kD).setVisibility(View.VISIBLE);
        }
        if(sch<13){
            findViewById(R.id.kc).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.kc).setVisibility(View.VISIBLE);
        }
        if(sch<12){
            findViewById(R.id.kB).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.kB).setVisibility(View.VISIBLE);
        }
        if(sch<11){
            findViewById(R.id.kA).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.kA).setVisibility(View.VISIBLE);
        }
        if(sch<10){
            findViewById(R.id.k9).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k9).setVisibility(View.VISIBLE);
        }
        if(sch<9){
            findViewById(R.id.k8).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k8).setVisibility(View.VISIBLE);
        }
        if(sch<8){
            findViewById(R.id.k7).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k7).setVisibility(View.VISIBLE);
        }
        if(sch<7){
            findViewById(R.id.k6).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k6).setVisibility(View.VISIBLE);
        }
        if(sch<6){
            findViewById(R.id.k5).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k5).setVisibility(View.VISIBLE);
        }
        if(sch<5){
            findViewById(R.id.k4).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k4).setVisibility(View.VISIBLE);
        }
        if(sch<4){
            findViewById(R.id.k3).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k3).setVisibility(View.VISIBLE);
        }
        if(sch<3){
            findViewById(R.id.k2).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.k2).setVisibility(View.VISIBLE);
        }
    }
    public void sp(View view){
        if(Calc.sch<16){
            double res=this.Convert_1();
            sch++;
            this.UpdateButton();
            this.UpdateSCH();
            str =Calc.toS(res);
            index=str.length();
            this.updateText();
        }
    }
    public void key_p(View view){
        this.key_operator("+");
    }
    public void key_d(View view){
        this.key_operator("/");
    }
    public void key_Clear(View view){
        str="";
        index=0;
        updateText();
    }
    public void key_shr(View view){
        if(index<str.length())
            index++;
        updateText();
    }
    public void key_shl(View view){
        if(index>0)
            index--;
        updateText();
    }
    public void key_del(View view){
        if(str.length()==0){
            return;
        }
        str=str.substring(0,index-1)+str.substring(index);
        op=false;
        index--;
        if(str.length()==0){
            updateText();
            return;
        }
        try{
            if(str.charAt(index-1)==' '){
                throw new ExceptionInInitializerError();

            }
        } catch (ExceptionInInitializerError e){
            str=str.substring(0,index-1)+str.substring(index);
            index--;
            this.op=!this.op;
        }
        updateText();
    }
    public void send(View view){
        TextView t=(TextView) findViewById(R.id.sedit);
        Menu.send+=getString(R.string.csend)+"\n"+this.str+" = "+t.getText().toString()+"\n"+getString(R.string.csch)+" "+Integer.toString(Calc.sch)+"\n\n";
        Intent menu=new Intent(this, Send.class);
        startActivity(menu);
    }
}
