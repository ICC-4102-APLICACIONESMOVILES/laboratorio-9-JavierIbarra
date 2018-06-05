package com.example.javier.laboratorio10;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class WebInterface {
    Context contexto;

    WebInterface(Context cont){
        contexto = cont;
    }

    @JavascriptInterface
    public void consoleMessage(String mensaje){
        Log.d("Mens",mensaje);
    }

    @JavascriptInterface
    public void finishActivity(){
        Activity activity=(Activity) contexto;
        activity.finish();
    }
}
