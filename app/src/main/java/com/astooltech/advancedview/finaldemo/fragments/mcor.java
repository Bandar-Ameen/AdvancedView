package com.astooltech.advancedview.finaldemo.fragments;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class mcor {
    private static LocalDataManager localDataManager;
    public static QiscusAccount getQiscusAccount() {

        return localDataManager.getAccountInfo();
    }
    private static class LocalDataManager {
        private SharedPreferences sharedPreferences;
        private final Gson gson;
        private String token;
        private String refreshToken;
        private Context c;
public LocalDataManager(Gson gson){

    this.gson = gson;
}
        LocalDataManager() {
            SharedPreferences sharedPreferencesOld  = c.getSharedPreferences("qiscus.cfg", Context.MODE_PRIVATE);

            try {
              /*  String sharedPrefsFile = JupukData.getFileName();
                boolean isActive = false;

                if (isActive) {
                    sharedPreferences = EncryptedSharedPreferences.create(
                            sharedPrefsFile,
                            JupukData.getFileKey(),
                            QiscusCore.getApps().getApplicationContext(),
                            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                    );

                } else {
                    MasterKey masterKey = new MasterKey.Builder(QiscusCore.getApps().getApplicationContext(), JupukData.getFileKey())
                            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                            .build();

                    sharedPreferences = EncryptedSharedPreferences.create(QiscusCore.getApps().getApplicationContext(),
                            sharedPrefsFile,
                            masterKey,
                            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
                }*/

                String dataAccount = sharedPreferencesOld.getString("cached_account", "");
                String LbUrl = sharedPreferencesOld.getString("lb_url", "");
                String brokerUrl = sharedPreferencesOld.getString("mqtt_broker_url", "");
                String fcmToken = sharedPreferencesOld.getString("fcm_token", "");


                SharedPreferences.Editor sharedPrefsEditor = sharedPreferences.edit();

                if (!dataAccount.isEmpty()) {
                    //migration to new Data
                    sharedPrefsEditor.putString("cached_account", dataAccount);
                }

                if (!LbUrl.isEmpty()) {
                    sharedPrefsEditor.putString("lb_url", LbUrl);
                }

                if (!brokerUrl.isEmpty()) {
                    sharedPrefsEditor.putString("mqtt_broker_url", brokerUrl);
                }

                if (!fcmToken.isEmpty()) {
                    sharedPrefsEditor.putString("fcm_token", fcmToken);
                }

                sharedPrefsEditor.apply();

                //remove old data
                sharedPreferencesOld.edit().clear().apply();


            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                sharedPreferences = sharedPreferencesOld;
            } catch (SecurityException e) {
                e.printStackTrace();
                sharedPreferences = sharedPreferencesOld;
            } catch (Exception e) {
                e.printStackTrace();
                sharedPreferences = sharedPreferencesOld;
            } catch (Error e) {
                e.printStackTrace();
                sharedPreferences = sharedPreferencesOld;
            }

            gson = new Gson();
            token = isLogged() ? getAccountInfo().getToken() : "";
            refreshToken = isLogged() ? getAccountInfo().getRefreshToken() : "";
        }

        private boolean isLogged() {
            return sharedPreferences.contains("cached_account");
        }

        private void saveAccountInfo(QiscusAccount qiscusAccount) {
            try {
                JSONObject data = new JSONObject(qiscusAccount.toString().substring(13));
                sharedPreferences.edit().putString("cached_account", data.toString()).apply();
            } catch (JSONException e) {
                sharedPreferences.edit().putString("cached_account", gson.toJson(qiscusAccount)).apply();
                e.printStackTrace();
            }

            setToken(qiscusAccount.getToken());
            setRefreshToken(qiscusAccount.getRefreshToken());
        }

        private QiscusAccount getAccountInfo() {
            QiscusAccount qiscusAccount = new QiscusAccount();
            try {
                JSONObject jsonObject = new JSONObject(sharedPreferences.getString("cached_account", ""));
                if (jsonObject.has("avatar")) {
                    qiscusAccount.setAvatar(jsonObject.optString("avatar", ""));
                }
                if (jsonObject.has("email")) {
                    qiscusAccount.setEmail(jsonObject.optString("email", ""));
                }
                if (jsonObject.has("id")) {
                    qiscusAccount.setId(jsonObject.optInt("id", 0));
                }
                if (jsonObject.has("token")) {
                    qiscusAccount.setToken(jsonObject.optString("token", ""));
                }
                if (jsonObject.has("refresh_token")) {
                    qiscusAccount.setRefreshToken(jsonObject.optString("refresh_token", ""));
                }
                if (jsonObject.has("token_expires_at")) {
                    qiscusAccount.setTokenExpiresAt(jsonObject.optString("token_expires_at", ""));
                }
                if (jsonObject.has("username")) {
                    qiscusAccount.setUsername(jsonObject.optString("username", ""));
                }

                if (jsonObject.has("extras")) {
                    if (jsonObject.optJSONObject("extras").toString().contains("nameValuePairs")) {
                        //migration from latest
                        qiscusAccount.setExtras(jsonObject.optJSONObject("extras").getJSONObject("nameValuePairs"));
                    } else {
                        qiscusAccount.setExtras(jsonObject.optJSONObject("extras"));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return qiscusAccount;
        }

        private String getToken() {
            return token == null ? token = "" : token;
        }

        private void setToken(String token) {
            this.token = token;
        }

        private String getRefreshToken() {
            return refreshToken == null ? refreshToken = "" : refreshToken;
        }

        private void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        private String getFcmToken() {
            return sharedPreferences.getString("fcm_token", null);
        }

        private void setFcmToken(String fcmToken) {
            sharedPreferences.edit().putString("fcm_token", fcmToken).apply();
        }

        /**
         * this is used if enableMqttLB = true
         *
         * @return mqttBrokerUrl
         */
        private String getMqttBrokerUrl() {
            return sharedPreferences.getString("mqtt_broker_url", null);
        }

        private void setEnableDisableRealtimeManually(Boolean enableDisableRealtimeManually) {
            sharedPreferences.edit().putBoolean("realtime_enable_disable", enableDisableRealtimeManually).apply();
        }

        /**
         * save local sharedPref for enable / disable realtime (manual)
         *
         * @return mqttBrokerUrl
         */
        private Boolean getEnableDisableRealtimeManually() {
            return sharedPreferences.getBoolean("realtime_enable_disable", true);
        }


        /**
         * this is used if enableMqttLB = true
         *
         * @param mqttBrokerUrl
         */
        private void setMqttBrokerUrl(String mqttBrokerUrl) {
            sharedPreferences.edit().putString("mqtt_broker_url", mqttBrokerUrl).apply();
        }

        /**
         * this is used if enableMqttLB = true
         *
         * @return UrlLB
         */
        private String getURLLB() {
            return sharedPreferences.getString("lb_url", null);
        }

        /**
         * this is used if enableMqttLB = true
         *
         * @param urlLb
         */
        private void setURLLB(String urlLb) {
            sharedPreferences.edit().putString("lb_url", urlLb).apply();
        }

        /**
         * Mechanism for MQTT LB
         *
         * @return boolean
         */
        private boolean willGetNewNodeMqttBrokerUrl() {
            return sharedPreferences.getBoolean("mqtt_will_get_new", true);
        }

        private void setWillGetNewNodeMqttBrokerUrl(boolean will) {
            sharedPreferences.edit().putBoolean("mqtt_will_get_new", will).apply();
        }

        private void clearData() {
            sharedPreferences.edit().clear().apply();
            setToken("");
            setRefreshToken("");
        }
    }
}
