package com.example.mb_cl_201029426.laboratoire3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CodeAccesValide extends AppCompatActivity {

    String S_CodeValide = "1337";
    boolean valide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_acces_valide);
        //Prend la première activité
        Intent intent = getIntent();
        //Récupaire les paramètres Username et le code d'entré
        String Username = intent.getStringExtra("Username");
        String S_CodeEntree = intent.getStringExtra("Password");
        LinearLayout unLayout = (LinearLayout)findViewById((R.id.Layout));
        TextView UsernameTV = (TextView)findViewById(R.id.TV_Username);

        //Si le code d'accès est valide
        if(S_CodeValide.equals(S_CodeEntree) )
        {
            UsernameTV.setText(getResources().getText(R.string.valide) + " " + Username);
            unLayout.setBackgroundColor(Color.rgb(0, 255, 0));
            UsernameTV.setTextColor(Color.rgb(0,0,0));
        }
        //Si le Code d'accès est invalide
        else
        {
            UsernameTV.setText(getResources().getText(R.string.invalide));
            unLayout.setBackgroundColor(Color.rgb(255, 0, 0));
            UsernameTV.setTextColor(Color.rgb(255, 255, 255));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_acces_valide, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
