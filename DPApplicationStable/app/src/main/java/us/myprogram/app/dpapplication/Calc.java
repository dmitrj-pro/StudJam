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

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class Calc extends AppCompatActivity {
    protected String str;
    static public TreeMap<String,Integer> data;
    protected boolean op;
    private int Index;
    public static int sch=16;
    public static String ToS(double x){
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
    public static double ToD(String K){
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
        this.Index=0;
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
        this.UpdateButton();
        this.UpdateSCH();
    }
    public void UpdateText(String strin){
        TextView f=(TextView)findViewById(R.id.sedit);
        String tmp=str.substring(0,this.Index)+"|"+str.substring(this.Index);
        f.setText(tmp + strin);
        EditText g=(EditText)findViewById(R.id.edit);
        g.setText(tmp + strin);
    }
    public void UpdateText(){
        this.UpdateText("");
    }
    public void back(View view){
        finish();
    }
    public void key_1(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"1"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_2(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"2"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_3(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"3"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_4(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"4"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_5(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"5"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_6(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"6"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_7(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"7"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_8(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"8"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_9(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"9"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_0(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"0"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_A(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"A"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_B(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"B"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_C(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"C"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_D(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"D"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_E(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"E"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_F(View view){
        if(op){
            op=false;
        }
        str=str.substring(0,Index)+"F"+str.substring(Index);
        Index++;
        UpdateText();
    }
    public void key_so(View view){
        if(Index!=str.length()){
            str=str.substring(0,Index)+"("+str.substring(Index);
            Index++;
            UpdateText();
            return;
        }
        if(op){
            str=str.substring(0,Index)+"("+str.substring(Index)+")";
            Index++;
            UpdateText();
            op=false;
        }
    }
    public void key_sc(View view){
        if(Index!=str.length()){
            str=str.substring(0,Index)+")"+str.substring(Index);
            Index++;
            UpdateText();
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
        f.setText(Calc.ToS(res));
        g.setText(Calc.ToS(res));
    }
    public void key_m(View view){
        if(Index!=str.length()){
            str=str.substring(0,Index)+"-"+str.substring(Index);
            Index++;
            UpdateText();
            return;
        }
        if(op){
            for(int i=str.length()-1; i>=0;i++){
                try {
                    char c = str.charAt(i);
                } catch (Exception ee){
                    str=str.substring(0,i-1);
                    str+="-";
                    break;
                }
            }
        } else {
            str+="-";
            Index+=1;
        }
        op=true;
        UpdateText();
    }
    public void key_u(View view){
        if(Index!=str.length()){
            str=str.substring(0,Index)+"*"+str.substring(Index);
            Index+=1;
            UpdateText();
            return;
        }
        if(op){
            for(int i=str.length()-1; i>=0;i++){
                try {
                    char c = str.charAt(i);
                } catch (Exception ee){
                    str=str.substring(0,i-1);
                    str+="*";
                    break;
                }
            }
        } else {
            str+="*";
            Index+=1;
        }
        op=true;
        UpdateText();
    }
    public void sm(View view){
        if(Calc.sch>2){
            double res=this.Convert_1();
            sch--;
            this.UpdateButton();
            this.UpdateSCH();
            str=Calc.ToS(res);
            Index=str.length();
            this.UpdateText();
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
            str =Calc.ToS(res);
            Index=str.length();
            this.UpdateText();
        }
    }
    public void key_p(View view){
        if(Index!=str.length()){
            str=str.substring(0,Index)+"+"+str.substring(Index);
            Index+=1;
            UpdateText();
            return;
        }
        if(op){
            for(int i=str.length()-1; i>=0;i++){
                try {
                    char c = str.charAt(i);
                } catch (Exception e){
                    str=str.substring(0,i-1);
                    str+="+";
                    break;
                }
            }
        } else {
            str+="+";
            Index+=1;
        }
        op=true;
        UpdateText();
    }
    public void key_d(View view){
        if(Index!=str.length()){
            str=str.substring(0,Index)+"/"+str.substring(Index);
            Index+=1;
            UpdateText();
            return;
        }
        if(op){
            for(int i=str.length()-1; i>=0;i++){
                try {
                    char c = str.charAt(i);
                } catch (Exception e){
                    str=str.substring(0,i-1);
                    str+="/";
                    break;
                }
            }
        } else {
            str+="/";
            Index+=1;
        }
        op=true;
        UpdateText();
    }
    public void key_Clear(View view){
        str="";
        Index=0;
        UpdateText();
    }
    public void key_shr(View view){
        if(Index<str.length())
            Index++;
        UpdateText();
    }
    public void key_shl(View view){
        if(Index>0)
            Index--;
        UpdateText();
    }
    public void key_del(View view){
        if(str.length()==0){
            return;
        }
        str=str.substring(0,Index-1)+str.substring(Index);
        op=false;
        Index--;
        if(str.length()==0){
            UpdateText();
            return;
        }
        try{
            if(str.charAt(Index-1)==' '){
                throw new ExceptionInInitializerError();

            }
        } catch (ExceptionInInitializerError e){
            str=str.substring(0,Index-1)+str.substring(Index);
            Index--;
            this.op=!this.op;
        }
        UpdateText();
    }
    public void send(View view){
        TextView t=(TextView) findViewById(R.id.sedit);
        Menu.Send+=getString(R.string.csend)+"\n"+this.str+" = "+t.getText().toString()+"\n"+getString(R.string.csch)+" "+Integer.toString(Calc.sch)+"\n\n";
        Intent menu=new Intent(this, Send.class);
        startActivity(menu);
    }
}
