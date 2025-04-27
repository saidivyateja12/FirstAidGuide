package saidivyatejas3466626.developed.firstaidapp

import android.content.Context



object FirstAidPreferences {

    private const val STORAGE_NAME = "FIRST_AID_USER_PREFS"
    private const val LOGIN_FLAG = "LOGIN_FLAG"
    private const val USER_FULL_NAME = "USER_FULL_NAME"
    private const val USER_CONTACT_EMAIL = "USER_CONTACT_EMAIL"

    fun updateLoginStatus(context: Context, status: Boolean) {
        val sharedPref = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        sharedPref.edit().putBoolean(LOGIN_FLAG, status).apply()
    }

    fun getLoginStatus(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(LOGIN_FLAG, false)
    }

    fun updateUserName(context: Context, userName: String) {
        val sharedPref = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        sharedPref.edit().putString(USER_FULL_NAME, userName).apply()
    }

    fun getUserName(context: Context): String {
        val sharedPref = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(USER_FULL_NAME, "") ?: ""
    }

    fun updateUserEmail(context: Context, email: String) {
        val sharedPref = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        sharedPref.edit().putString(USER_CONTACT_EMAIL, email).apply()
    }

    fun getUserEmail(context: Context): String {
        val sharedPref = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(USER_CONTACT_EMAIL, "") ?: ""
    }
}
