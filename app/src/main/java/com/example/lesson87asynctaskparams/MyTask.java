package com.example.lesson87asynctaskparams;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MyTask extends AsyncTask<String, Integer, Void> {

    private TextView mTV;

    public MyTask(View mTV) {
        this.mTV = (TextView) mTV;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mTV.setText("Begin");
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            int cnt = 0;
            // загружаем файл
            for (String url : strings) {
                downloadFile(url);
                // выводим промежуточные результаты
                publishProgress(++cnt);
            }
            // разъединяемся
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mTV.setText("Downloaded " + values[0] + " files");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mTV.setText("End");
    }

    private void downloadFile(String url) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
