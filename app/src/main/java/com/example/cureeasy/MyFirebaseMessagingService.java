package com.example.cureeasy;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.FirebaseFunctionsException;
import com.google.firebase.functions.HttpsCallableResult;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.HashMap;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
String uid;
    FirebaseFunctions mFunctions;
    Map<String,String> result;
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("prev", MODE_PRIVATE);
        uid=pref.getString("userid",null);
        mFunctions = FirebaseFunctions.getInstance();
        sendTokenToServer(s);

    }

    public void sendTokenToServer(String s1)
    {
        addToken(s1)
                .addOnCompleteListener(new OnCompleteListener<Map<String,String>>() {
                    @Override
                    public void onComplete(@NonNull Task<Map<String,String>> task) {
                        if (!task.isSuccessful()) {
                            Exception e = task.getException();
                            if (e instanceof FirebaseFunctionsException) {
                                FirebaseFunctionsException ffe = (FirebaseFunctionsException) e;
                                FirebaseFunctionsException.Code code = ffe.getCode();
                                Object details = ffe.getDetails();
                            }

                            // ...
                        }
else
                        {
                            Log.e("Token Service","err");
                        }
                        // ...
                    }
                });
    }
    private Task<Map<String,String>> addToken(String text) {
        // Create the arguments to the callable function.
        Map<String, Object> data = new HashMap<>();
        data.put("token", text);
        data.put("userid", uid);

        return mFunctions
                .getHttpsCallable("addtoken")
                .call(data)
                .continueWith(new Continuation<HttpsCallableResult, Map<String,String>>() {
                    @Override
                    public Map<String,String> then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                        // This continuation runs on either success or failure, but if the task
                        // has failed then getResult() will throw an Exception which will be
                        // propagated down.
                        result = (Map<String,String>) task.getResult().getData();
                        return result;
                    }
                });
    }

}
