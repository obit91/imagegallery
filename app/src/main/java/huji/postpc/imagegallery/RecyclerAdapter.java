package huji.postpc.imagegallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by obit91 on 5/22/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private List<Image> mDataSource;
    private Context mContext;

    public RecyclerAdapter(Context context, List<Image> dataSources) {
        mDataSource = dataSources;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ri_img, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.text.setText(mDataSource.get(position).getId());
        Picasso.with(mContext).load(mDataSource.get(position).getLink()).resize(120, 60).into(holder.image);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            text = (TextView)view.findViewById(R.id.ri_txt);
            image = (ImageView)view.findViewById(R.id.ri_img);
        }
    }
}