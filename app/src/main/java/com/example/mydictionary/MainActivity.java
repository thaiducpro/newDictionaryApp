package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Notification;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private String userInput;
    private String dictionary = "cambridge";
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        webView = (WebView) findViewById(R.id.browser);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://dictionary.cambridge.org/us/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    public void emptyInput(){
        if (userInput==null){
            userInput= "hello";

        }

    }

    public void search(View view){
        userInput = ((EditText)(findViewById(R.id.input))).getText().toString();
        emptyInput();
        if(dictionary == "cambridge") {
            webView.loadUrl("https://dictionary.cambridge.org/us/dictionary/english/" + userInput);
        }else if(dictionary =="oxford"){
            webView.loadUrl("https://www.oxfordlearnersdictionaries.com/definition/english/"+userInput);

        }else if(dictionary == "dictionary"){
            webView.loadUrl("https://www.dictionary.com/browse/"+userInput);

        }

    }

    public void cambridge(View view){
        userInput = ((EditText)(findViewById(R.id.input))).getText().toString();
        dictionary = "cambridge";
        emptyInput();
        webView.loadUrl("https://dictionary.cambridge.org/us/dictionary/english/"+userInput);

    }
    public void oxford(View view){
        userInput = ((EditText)(findViewById(R.id.input))).getText().toString();
        dictionary = "oxford";
        emptyInput();
        webView.loadUrl("https://www.oxfordlearnersdictionaries.com/definition/english/"+userInput);

    }
    public void dictionary(View view){
        userInput = ((EditText)(findViewById(R.id.input))).getText().toString();
        dictionary = "dictionary";
        emptyInput();
        webView.loadUrl("https://www.dictionary.com/browse/"+userInput);

    }
    public void google(View view){
        emptyInput();
        webView.loadUrl("https://dictionary.cambridge.org/us/dictionary/english/"+userInput);

    }

}