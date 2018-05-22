package huji.postpc.imagegallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AccessResponse {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View mButton;
    private List<Image> mImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        mButton = findViewById(R.id.button_images);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                AsyncRequest request = new AsyncRequest();
                request.delegate = MainActivity.this;
                request.execute();
            }
        });

    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(getApplicationContext(), mImages);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void getResult(Data data) {
        mImages.removeAll(mImages);
       mImages.addAll(data.getImages());
       mAdapter.notifyDataSetChanged();
    }
}