package com.uv.ris_cali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class visor extends AppCompatActivity {
    String url="https://andrescobar28.github.io/PF_SW_2022_1/geovisor_invitado.html";
    private WebView miWebView;

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "¡Has accedido como INVITADO!", Toast.LENGTH_SHORT).show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        miWebView=findViewById(R.id.miVisor2);
        miWebView.getSettings().setJavaScriptEnabled(true);
        miWebView.getSettings().setAppCacheEnabled(true);
        miWebView.setWebViewClient(new WebViewClient());
        miWebView.loadUrl(url);
        miWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

    }
    public boolean onKeyDown(int KeyCode, KeyEvent event){

        if (event.getAction()==KeyEvent.ACTION_DOWN){
            switch (KeyCode){
                case KeyEvent.KEYCODE_BACK:
                    if (miWebView.canGoBack()){
                        miWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(KeyCode, event);
    }
}