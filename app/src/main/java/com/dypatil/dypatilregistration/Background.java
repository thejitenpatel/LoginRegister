package com.dypatil.dypatilregistration;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Background extends AsyncTask<String, Void, String> {
    private static final String TAG = "Background";
    Context context;
    protected ProgressDialog progressDialog;

    Background (Context ctx){
        Log.d(TAG, "Background: inside context");
        context = ctx;
    }

    //This method is called before doInBackground method
    @Override
    protected void onPreExecute() {
        Log.d(TAG, "onPreExecute: inside onPreExecute");
        progressDialog = ProgressDialog.show(context, "Autenticating", "Please wait!!!", true, false);
    }

    //This method is called after the doInBackground method
    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "onPostExecute: inside onPostExecute");
        progressDialog.dismiss();
    }

    //This method is executed when User has provided there credential
    @Override
    protected String doInBackground(String... params) {
        Log.d(TAG, "doInBackground: inside doInBackground");
        String type = params[0];
        String insertUrl = "ADD YOU'RE INSERT.php FILE LINK E.g jiten.com/insert.php";
        String loginUrl = "ADD YOU'RE LOGIN.php FILE LINK E.g. jiten.com/login.php";
        //If user is new & cliks on register then this block will be executed
        if(type.equalsIgnoreCase("register")){
            try {
                //this variables are those variable which is used in ur app for user credntials.
                String off = params[1];
                String mob = params[2];
                String pass = params[3];
                //Seeting up url connection
                URL url = new URL(insertUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") +
                        "&" + URLEncoder.encode("mob", "UTF-8") + "=" + URLEncoder.encode(mob, "UTF-8") + "=" +
                        "&" +  URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // IF user click on login then this block will be executed
        }else if(type.equalsIgnoreCase("login")){
            try {
                //This variables are those used for user login credentials
                String off = params[1];
                String pass = params[2];
                //Setting up the url connection
                URL url = new URL(loginUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") +
                        "&" +  URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
