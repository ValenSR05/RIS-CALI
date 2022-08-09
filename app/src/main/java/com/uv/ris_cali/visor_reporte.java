package com.uv.ris_cali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class visor_reporte extends AppCompatActivity {

    String url="https://andrescobar28.github.io/PF_SW_2022_1/geovisor_login.html";
    private WebView miWebView2;

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "¡Has ingresado con éxito!", Toast.LENGTH_SHORT).show();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_reporte);

        miWebView2=findViewById(R.id.miVisor2);
        miWebView2.getSettings().setJavaScriptEnabled(true);
        miWebView2.getSettings().setAppCacheEnabled(true);
        miWebView2.setWebViewClient(new WebViewClient());
        miWebView2.loadUrl(url);
        miWebView2.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
    }
    public boolean onKeyDown(int KeyCode, KeyEvent event){

        if (event.getAction()==KeyEvent.ACTION_DOWN){
            switch (KeyCode){
                case KeyEvent.KEYCODE_BACK:
                    if (miWebView2.canGoBack()){
                        miWebView2.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(KeyCode, event);
    }
}
