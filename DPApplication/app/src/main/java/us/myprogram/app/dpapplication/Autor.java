package us.myprogram.app.dpapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class Autor extends AppCompatActivity {
    private int dev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dev=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autor);
        TextView ver=(TextView)findViewById(R.id.aver);
        ver.setText(Menu.version.toString());
        ver=(TextView)findViewById(R.id.adata);
        ver.setText(Menu.date);
    }
    public void back(View view){
        finish();
    }
    public void send(View view){
        Menu.send+=getString(R.string.alibe)+" "+Menu.version.toString()+"\n"+getString(R.string.adatas)+" "+Menu.date+"\n\n";
        Intent menu=new Intent(this, Send.class);
        startActivity(menu);
    }
    public void developer(View view){
        dev++;
        Menu.developer=dev>4;
        if(Menu.developer){
            Toast.makeText(Autor.this, getString(R.string.adeveloper), Toast.LENGTH_SHORT).show();
        }
    }
}
