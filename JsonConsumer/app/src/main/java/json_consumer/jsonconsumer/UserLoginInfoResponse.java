package json_consumer.jsonconsumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 13/12/15.
 */
public class UserLoginInfoResponse {

    List<UserLoginInfo> data;

    public UserLoginInfoResponse() {
        data = new ArrayList<UserLoginInfo>();
    }

    public static UserLoginInfoResponse parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        UserLoginInfoResponse userLoginInfoResponse = gson.fromJson(response, UserLoginInfoResponse.class);
        return userLoginInfoResponse;
    }
}
