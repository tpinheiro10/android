package json_consumer.jsonconsumer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    UserLoginInfoResponse userLoginInfoResponse = new UserLoginInfoResponse();

    UserLoginInfo u = new UserLoginInfo("1234","Afonso", "9845");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        run();
    }

    public void run() {
        OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://s3-sa-east-1.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PontoTelService service = retrofit.create(PontoTelService.class);

        Call<UserLoginInfoResponse> call = service.getJson();
        call.enqueue(new Callback<UserLoginInfoResponse>() {
            @Override
            public void onResponse(Response<UserLoginInfoResponse> response, Retrofit retrofit) {
                userLoginInfoResponse = response.body();
                System.out.println("onResponse");
                for(UserLoginInfo u : userLoginInfoResponse.data){
                    items.add(u.toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("onFailure");
                finish();
            }
        });

    }

}
