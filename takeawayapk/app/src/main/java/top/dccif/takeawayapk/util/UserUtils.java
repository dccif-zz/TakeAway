package top.dccif.takeawayapk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONObject;

public class UserUtils {
    private static final String APIURL_SIGNUP = "";
    private static final String APIURL_SIGNIN = "";
    public static String mUsername = null;
    public static int minimumUsernameLength = 6;
    public static int minimumPasswordLength = 6;
    private static Context context;

    public static void init(Context context) {
        UserUtils.context = context;
        mUsername = getUsername();
    }

    public static boolean isLogined() {
        return mUsername != null;
    }

    public static boolean login(String username, String password) {
        JSONObject jsonResponse = Utils.connectAndGetJSONObject(APIURL_SIGNIN,
                "POST", String.format("op=signin&username=%s&password=%s", username, password));
        try {
            String status = jsonResponse.getString("status");
            Log.d("UserUtils_login:", status);
            boolean success = status.equals("success");
            if (success) {
                setUsername(username);

                //载入地址
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AddressUtils.Init();
                    }
                }).start();
            }
            return success;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean logout() {
        setUsername("");
        return true;
    }

    public static boolean signup(String username, String password) {
        JSONObject jsonResponse = Utils.connectAndGetJSONObject(APIURL_SIGNUP,
                "POST", String.format("op=signup&username=%s&password=%s", username, password));
        try {
            String status = jsonResponse.getString("status");
            Log.d("UserUtils_signup", status);
            return status.equals("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getUsername() {
        SharedPreferences preferences = context.getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
        return preferences.getString("username", null);
    }

    public static void setUsername(String username) {
        SharedPreferences.Editor editor = context.getSharedPreferences("AccountInfo", Context.MODE_PRIVATE).edit();
        editor.clear();
        mUsername = null;
        if (!username.equals("")) {
            mUsername = username;
            editor.putString("username", username);
        }
        editor.commit();
    }

    public static boolean isUsernameValid(String username) {
        if (Character.isDigit(username.charAt(0)) || username.length() < UserUtils.minimumUsernameLength)
            return false;
        return true;
    }

    public static boolean isPasswordValid(String password) {
        if (TextUtils.isEmpty(password) || password.length() < UserUtils.minimumPasswordLength)
            return false;
        return true;
    }
}
