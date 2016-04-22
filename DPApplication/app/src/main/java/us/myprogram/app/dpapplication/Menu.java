package us.myprogram.app.dpapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


public class Menu extends AppCompatActivity {
    public static boolean isWork;
    public static boolean isHard;
    public static String Send;
    public static Version version;
    public static String date;
    public static boolean Developer;
    public Menu(){
        isWork=false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Menu.Send="";
        Menu.Developer=false;
        Menu.date="22.04.2016";
        version=new Version(1,1,1,5);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.UpdateDeveloper();
    }
    public void UpdateDeveloper(){
        if(Menu.Developer){
            findViewById(R.id.isw).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.isw).setVisibility(View.INVISIBLE);
        }
    }
    public void autor(View view){
        Intent autr=new Intent(this, Autor.class);
        startActivity(autr);
        this.UpdateDeveloper();
    }
    public void calc(View view){
        Intent calc=new Intent(this,Calc.class);
        startActivity(calc);
    }
    public void work(View view){
        CheckBox c=(CheckBox)findViewById(R.id.isw);
        Menu.isWork=c.isChecked();
        if(Menu.isWork) {
            CheckBox tmps=(CheckBox)findViewById(R.id.hard);
            tmps.setChecked(Menu.isHard);
            findViewById(R.id.hard).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.hard).setVisibility(View.INVISIBLE);
        }
    }
    public void kmb(View view){
        Intent rand=new Intent(this,kmb.class);
        startActivity(rand);
    }
    public void rand(View view){
        Intent rand=new Intent(this,Random.class);
        startActivity(rand);
    }
    public void Hard(View view){
        CheckBox c=(CheckBox)findViewById(R.id.hard);
        Menu.isHard=c.isChecked();
    }

}
