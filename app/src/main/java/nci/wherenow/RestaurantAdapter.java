package nci.wherenow;

/**
 * Created by Jamie on 13/03/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

 /*
 *RecyclerView.Adapter
 *RecyclerView.ViewHolder
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{

    private Context mCtx;
    private List<Restaurant> restaurantList;
    private Button mapsBtn;


    public RestaurantAdapter(Context mCtx, List<Restaurant> restaurantList) {
        this.mCtx = mCtx;
        this.restaurantList = restaurantList;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new RestaurantViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Restaurant Restaurant = restaurantList.get(position);

        holder.textViewTitle.setText(Restaurant.getTitle());
        holder.textViewShortDesc.setText(Restaurant.getShortdesc());
        holder.textViewRating.setText(String.valueOf(Restaurant.getRating()));
        holder.textViewPrice.setText(String.valueOf(Restaurant.getPrice()));

        holder.imageView.setImageDrawable((mCtx.getResources().getDrawable(Restaurant.getImage())));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;


        public RestaurantViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }

    }

}
