package com.genggam.projekfilm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoAdapter extends RecyclerView.Adapter<MoAdapter.ViewHolder>{
    public ArrayList<SearchItem> listMo = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mo_adapter, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(listMo.get(position));
    }

    @Override
    public int getItemCount() {
        return listMo.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgPO)
        ImageView imgPo;
        @BindView(R.id.titlePo)
        TextView titlePo;
        @BindView(R.id.releaseVi)
        TextView releaseVi;
        @BindView(R.id.genre)
        TextView genre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(SearchItem data){
            titlePo.setText(data.getTitle());
            genre.setText(data.getType());
            releaseVi.setText(data.getYear());
            Glide.with(imgPo).load(data.getPoster()).into(imgPo);
        }
    }
}
