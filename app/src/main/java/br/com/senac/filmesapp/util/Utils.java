package br.com.senac.filmesapp.util;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import java.text.DecimalFormat;

public class Utils {
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static String formatDouble(Double value){
        return String.format("%.2f",value);
    }
}
