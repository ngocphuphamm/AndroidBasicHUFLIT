package com.android.foodorderapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.R;
import com.android.foodorderapp.model.Menu;
import com.android.foodorderapp.model.RestaurantModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.Viewholider> {
    Context context;
    List<RestaurantModel> list;

    public HistoryAdapter(Context context, List<RestaurantModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholider onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentView = inflater.inflate(R.layout.item_history, parent, false);
        Viewholider viewHolder = new Viewholider(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholider holder, int position) {
        RestaurantModel restaurantModel = list.get(position);

        Glide.with(context)
                .load(restaurantModel.getImage())
                .error(R.mipmap.ic_launcher)
                .into(holder.imgHinh);

        holder.txtName.setText(restaurantModel.getName());
        holder.txtAddress.setText("Địa chỉ: " + restaurantModel.getAddress());
        holder.txtTongSL.setText("Tổng số lượng: " + restaurantModel.getDelivery_charge());

        for (Menu menu : restaurantModel.getMenus()) {
            holder.txtListItem.append("\n" + "Món: " + menu.getName()
                    + " --- " + "Số lượng: " + menu.getTotalInCart() + " --- " + "Thành tiền: " + menu.getPrice());
        }

        holder.txtTongPhi.setText("Phí ship: " + restaurantModel.getPhi());
        holder.txtTong.setText("Thành tiền: " + restaurantModel.getTong());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholider extends RecyclerView.ViewHolder {
        ImageView imgHinh;
        TextView txtName, txtAddress, txtTongSL, txtListItem, txtTongTienSp, txtTongPhi, txtTong;

        public Viewholider(@NonNull View itemView) {
            super(itemView);
            imgHinh = itemView.findViewById(R.id.imgUserComment);
            txtName = itemView.findViewById(R.id.txtNameItem);
            txtAddress = itemView.findViewById(R.id.txtAddressItem);
            txtListItem = itemView.findViewById(R.id.txtListItem);
            txtTongTienSp = itemView.findViewById(R.id.txtTongTienSPItem);
            txtTongPhi = itemView.findViewById(R.id.txtPhiItem);
            txtTong = itemView.findViewById(R.id.txtTongItem);
            txtTongSL = itemView.findViewById(R.id.txtTongSoLuongItem);
        }
    }
}
