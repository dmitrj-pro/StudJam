package us.myprogram.app.dpapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


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
        Intent menu=new Intent(this, run_menu.class);
        startActivity(menu);
    }
}
