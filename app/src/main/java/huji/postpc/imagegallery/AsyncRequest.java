package huji.postpc.imagegallery;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsyncRequest extends AsyncTask<Void, Void, Data> {

    AccessResponse delegate = null;

    @Override
    protected Data doInBackground(Void... voids) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgur.com/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImgurService service = retrofit.create(ImgurService.class);
        Call<ResponseData> method = service.getAlbum();
        Response<ResponseData> resp = null;
        ResponseData respData = null;
        try {
            resp = method.execute();
            if (resp.isSuccessful())
                respData = resp.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respData.getData();
    }

    @Override
    protected void onPostExecute(Data result) {
        if(delegate != null)
        {
            delegate.getResult(result);
        }
    }
}