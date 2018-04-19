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

import com.google.android.gms.fitness.data.Goal;

import java.util.List;



public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{

    List<Restaurant> restaurantList;

    public RestaurantAdapter(List<Restaurant> restaurantList) {

        this.restaurantList = restaurantList;
    }

    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);

        holder.title.setText(restaurant.getTitle());
        holder.address.setText(restaurant.getAddress());
        holder.distance.setText(restaurant.getDistance());
        holder.duration.setText(restaurant.getDuration());

        //holder.imageView.setImageDrawable((mCtx.getResources().getDrawable(Restaurant.getImage())));
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder{

        TextView title, address, distance, duration;

        public RestaurantViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.textViewTitle);
            address = (TextView)itemView.findViewById(R.id.textViewAddress);
            distance = (TextView)itemView.findViewById(R.id.textViewDistance);
            duration = (TextView)itemView.findViewById(R.id.textViewDuration);
        }
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

}
