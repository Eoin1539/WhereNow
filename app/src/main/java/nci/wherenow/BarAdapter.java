package nci.wherenow;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.BarViewHolder>{

    private Context mCtx;
    private List<Bar> barList;
    private Button mapsBtn;


    public BarAdapter(Context mCtx, List<Bar> barList) {
        this.mCtx = mCtx;
        this.barList = barList;
    }

    @Override
    public BarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new BarViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BarViewHolder holder, int position) {
        Bar Bar = barList.get(position);

        holder.textViewTitle.setText(Bar.getTitle());
        holder.textViewAddress.setText(Bar.getAddress());
        holder.textViewDistance.setText(String.valueOf(Bar.getDistance()));
        holder.textViewDuration.setText(String.valueOf(Bar.getDuration()));

        holder.imageView.setImageDrawable((mCtx.getResources().getDrawable(Bar.getImage())));
    }

    @Override
    public int getItemCount() {
        return barList.size();
    }

    class BarViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle, textViewAddress, textViewDistance, textViewDuration;


        public BarViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            textViewDistance = itemView.findViewById(R.id.textViewDistance);
            textViewDuration = itemView.findViewById(R.id.textViewDuration);
        }

    }

}
