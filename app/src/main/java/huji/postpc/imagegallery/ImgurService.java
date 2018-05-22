package huji.postpc.imagegallery;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ImgurService {
    @Headers("Authorization: Client-ID 51cd06c924c6f9f")
    @GET("album/QRqY6")
    Call<ResponseData> getAlbum();
}
