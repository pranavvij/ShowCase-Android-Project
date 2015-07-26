package play.decisio.com.showcaselibrary;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final ArrayList<String> mListItemsCard;
    OnItemClickListener onItemClickListener;

    public RecyclerAdapter(ArrayList<String> listItemsCard) {
        this.mListItemsCard = listItemsCard;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.materialcard, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(mListItemsCard.get(position));
    }

    @Override
    public int getItemCount() {return mListItemsCard.size();}

    public void setOnItemClickListener(OnItemClickListener monItemClickListener){
        this.onItemClickListener=monItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
       public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }
       @Override
        public void onClick(View v) {
            if(onItemClickListener!=null) {
                onItemClickListener.onItemClick(v, getPosition());
            }
       }
    }
}