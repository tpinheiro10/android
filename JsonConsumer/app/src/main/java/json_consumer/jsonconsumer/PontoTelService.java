package json_consumer.jsonconsumer;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by thiago on 13/12/15.
 */
public interface PontoTelService {

    @GET("/pontotel-docs/data.json")
    Call<UserLoginInfoResponse> getJson();
}
