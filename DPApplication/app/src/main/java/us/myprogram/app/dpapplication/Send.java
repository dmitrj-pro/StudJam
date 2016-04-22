package us.myprogram.app.dpapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;

public class Send extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
    }
    public void Sending(View view){
        EditText f=(EditText)findViewById(R.id.smail);
        Intent inte=new Intent(Intent.ACTION_SEND);
        inte.setData(android.net.Uri.parse("mailto:"));
        inte.setType("text/plain");
        inte.putExtra(Intent.EXTRA_TEXT, Menu.Send + "\n\n" + getString(R.string.scalc) + " " + Menu.version.toString());
        inte.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.sthema));
        inte.putExtra(Intent.EXTRA_EMAIL, f.getText().toString());
        startActivity(Intent.createChooser(inte, getString(R.string.asend)));
        Menu.Send="";
    }
}
