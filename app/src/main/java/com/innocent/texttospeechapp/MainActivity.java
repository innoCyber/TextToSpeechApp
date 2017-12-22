package com.innocent.texttospeechapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech textToSpeech;
    private Button speakButton;
    private EditText getInputedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
;
        textToSpeech = new TextToSpeech (this, this);

        getInputedText = (EditText) findViewById(R.id.editTextView);
        speakButton = (Button) findViewById(R.id.speakButton);
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    @Override
    public void onInit(int text) {

        if(text == TextToSpeech.SUCCESS){
            int language = textToSpeech.setLanguage(Locale.ENGLISH);
            if(language==TextToSpeech.LANG_MISSING_DATA || language==TextToSpeech.LANG_NOT_SUPPORTED){
                speakButton.setEnabled(true);
                speak();
            }else{

            }
        }else{

        }

    }

    private void speak(){
        String text = getInputedText.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH, null);
    }
}
