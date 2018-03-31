package nci.wherenow;


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
        holder.textViewAddress.setText(Restaurant.getAddress());
        holder.textViewDistance.setText(String.valueOf(Restaurant.getDistance()));
        holder.textViewDuration.setText(String.valueOf(Restaurant.getDuration()));

        holder.imageView.setImageDrawable((mCtx.getResources().getDrawable(Restaurant.getImage())));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle, textViewAddress, textViewDistance, textViewDuration;


        public RestaurantViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            textViewDistance = itemView.findViewById(R.id.textViewDistance);
            textViewDuration = itemView.findViewById(R.id.textViewDuration);
        }

    }

}
