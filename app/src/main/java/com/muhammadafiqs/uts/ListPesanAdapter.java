package com.muhammadafiqs.uts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;


public class ListPesanAdapter extends RecyclerView.Adapter<ListPesanAdapter.ListViewHolder> {
    private ArrayList<Pesan> listPesan;

    public ListPesanAdapter(ArrayList<Pesan> list){
        this.listPesan = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pesan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Pesan pesan = listPesan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(pesan.getFoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgFoto);
        holder.tvName.setText(pesan.getName());
        holder.tvDetail.setText(pesan.getDetail());

    }

    @Override
    public int getItemCount() {
        return listPesan.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvName;
        TextView tvDetail;

        ListViewHolder(View itemview) {
            super(itemview);
            imgFoto = itemview.findViewById(R.id.img_item_pesan);
            tvName = itemview.findViewById(R.id.tv_item_name);
            tvDetail = itemview.findViewById(R.id.tv_detail);
        }
    }
}