package maufdh.dev.notas.Activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.poovam.pinedittextfield.CirclePinField;
import com.poovam.pinedittextfield.PinField;

import maufdh.dev.notas.Application.App;
import maufdh.dev.notas.R;

public class CodeActivity extends AppCompatActivity {
    private CirclePinField pincode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        setToolbar();
        pincode=(CirclePinField)findViewById(R.id.activityCode_pinCode);
        pincode.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {
            @Override
            public void onTextComplete(String s) {
                if(s.equals(App.prefs.getString("code","null")))
                {
                    Snackbar.make(getWindow().getDecorView().getRootView(),"Código correct",Snackbar.LENGTH_SHORT).show();
                }else{
                    //Incorrect
                    Snackbar.make(getWindow().getDecorView().getRootView(),"Código incorrecto",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_code); //Muestra el toolbar como ActionBar
        setSupportActionBar(toolbar);//Muestra titulo de toolbar
    }
}
