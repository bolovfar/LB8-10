package com.example.hm;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    EditText strLogin, strPassword;
    Button btnSave;

    SharedPreferences sPref;

    String Login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strLogin = (EditText) findViewById(R.id.strLogin);
        strPassword = (EditText) findViewById(R.id.strPassword);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            default:
                break;
        }
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        Login = strPassword.getText().toString();
        ed.putString(Login + " Login:", strLogin.getText().toString());
        ed.commit();
        ed.putString(Login + " Password:", strPassword.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
///data/data/com.example.hm/shared_prefs/MainActivity.xml
    }
}



