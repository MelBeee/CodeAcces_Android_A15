package com.example.mb_cl_201029426.laboratoire3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CodeAcces extends AppCompatActivity {

    //Compteur d'étoile
    int i = 0;
    //Edit Text pour Code Access
    EditText CodeAccesET;
    //String pour les étoiles
    String Etoile;
    //String Code Entrée
    String S_CodeEntree;
    //String Username
    String Username = "";
    //String Edit text pour la boite message
    EditText boiteMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_acces);
        //Initialisation des variables
        S_CodeEntree = new String();
        CodeAccesET = (EditText)findViewById(R.id.ET_CodeAcces);
        boiteMessage = (EditText)findViewById(R.id.ET_UserName);
        Etoile  = "";


        boiteMessage.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                Username = boiteMessage.getText().toString();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_acces, menu);
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

    //Écrit dans le Edit text de code accès les étoiles selon le nombre de fois appuyé
    public void CodeAccesWrite(View v)
    {
        //Si il y a moin de 4 étoiles
        if(i<=3)
        {
            //transforme la view en button
            Button ButtonNumber = (Button)v;
            //Sauvegarde le code entré par l'utilisateur
            S_CodeEntree += (String)ButtonNumber.getText();
            //Ajoute une étoile au code
            Etoile+="*";
            //écrit les étoiles dans le edit text de code accèss
            CodeAccesET.setText(Etoile);
            //incrémenteur le compteur des étoiles
            i += 1;
        }
    }
    public void Envoyer(View v)
    {
        //Si le Code n'est pas 4 chiffre de long un toast est envoyer
        if(S_CodeEntree.length() < 4)
        {
            Toast message = Toast.makeText( CodeAcces.this,
                    getResources().getText(R.string.T_Invalide_MDP), Toast.LENGTH_SHORT);
            message.show();
        }

        //Si il n'y a pas de nom d'utilisateur d'entré envoit un toast
        else if(Username.length() <= 0)
        {
            Toast message = Toast.makeText( CodeAcces.this,
                    getResources().getText(R.string.T_Invalide_Username), Toast.LENGTH_SHORT);
            message.show();
        }
        //Sinon lance la deuxième activité
        else
        {
            Intent intent = new Intent(this, CodeAccesValide.class);

            intent.putExtra("Username", Username);
            intent.putExtra("Password", S_CodeEntree);

            startActivity(intent);
        }
    }
    //Efface les étoiles
    public void Effacer(View v)
    {
        S_CodeEntree = FonctionSubstring(S_CodeEntree);
        Etoile= FonctionSubstring(Etoile);
        CodeAccesET.setText(Etoile);
        if(i >= 1)
        {
            i -= 1;
        }
    }
    //Fonction qui enlève le charactere de la fin a une string passer en paramèttre
    public String FonctionSubstring(String str) {
        if (str.length() > 0 && str != null) {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }
}
