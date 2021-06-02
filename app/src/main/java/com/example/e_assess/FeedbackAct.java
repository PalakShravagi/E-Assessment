package com.example.e_assess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


public class FeedbackAct extends AppCompatActivity {
    EditText fromid;
    EditText msg;
    Button btn;
    String toid = "pashk.firebase11@gmail.com";
    String subject = "Feedback";
    FirebaseDatabase fb;

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState); setContentView(R.layout.activity_main);
        final EditText edit1=(EditText) findViewById(R.id.editTextStudent1);
        final EditText edit2=(EditText) findViewById(R.id.editTextStudent2);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener (new View.OnClickListener(){
        @Override
        public void onClick(View v){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType ("message/html");
        i.putExtra (Intent.EXTRA_EMAIL,new String("xyz@gmail.com"));
        i.putExtra (Intent.EXTRA_SUBJECT, "Feedback From App");
        i.putExtra (Intent.EXTRA_TEXT,"Name: "+edit1.getText()+"\n Message: "+edit2.getText());
        try {
            startActivity(Intent.createChooser(i, "Please select Email"));
        }
        catch (ActivityNotFoundException ex)
        {
            Toast.makeText(FeedbackAct.this, "Therte aRE no emil clients", Toast.LENGTH_SHORT).show();
        }
    }
});
}
        }
