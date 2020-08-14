package com.example.calculator.utils;

import android.view.View;
import android.widget.Toast;

public class AppUtils {
    public static void showMessage(View view, int message, int i) {
        if( i == 1)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
