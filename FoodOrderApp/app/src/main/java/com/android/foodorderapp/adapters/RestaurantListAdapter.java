package com.android.foodorderapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.R;
import com.android.foodorderapp.model.RestaurantModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.MyViewHolder>  implements Filterable {

    // Khai báo một cái mảng data restaurantModel
    private List<RestaurantModel> restaurantModelList;
    public List<RestaurantModel> restaurantModelListOld;
    // Khai báo sự kiện  click vào nhà hàng hiển thị menu
    private RestaurantListClickListener clickListener;

    // Khai báo phương thức của class RestaurantListAdapter
    public RestaurantListAdapter(List<RestaurantModel> restaurantModelList, RestaurantListClickListener clickListener) {
        this.restaurantModelList = restaurantModelList;
        this.restaurantModelListOld = restaurantModelList;
        this.clickListener = clickListener;
    }

    // khai báo phương thức update Data
    public void updateData(List<RestaurantModel> restaurantModelList) {
        this.restaurantModelList = restaurantModelList;
        //Chẳng hạn, đối với ArrayAdapter, có phương thức notifyDataSetChanged() nên được gọi sau khi bạn đã cập
        // nhật danh sách mảng chứa tất cả dữ liệu của bạn, để làm mới ListView
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    // onCreateViewHolder : phương thức dùng để tạo view mới
    // cho recyclerview onBindViewHolder : dùng để gắn data vào view
    public RestaurantListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // khai báo tạo ra view
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,
                parent, false);
        // trả lại kết quả
        return  new MyViewHolder(view);
    }

    //onBindViewHolder - Thiết lập các thuộc tính của View và dữ liệu.
    //tham số position này để liên kết dữ liệu với view, việc này hoàn toàn ổn.
    @Override
    public void onBindViewHolder(@NonNull RestaurantListAdapter.MyViewHolder holder, int position) {
        RestaurantModel  restaurantModel = restaurantModelList.get(position);
        if(restaurantModel ==null)
        {
            return;
        }

        // triển khai bộ danh sách nah2 hàng
        holder.restaurantName.setText(restaurantModelList.get(position).getName());
        holder.restaurantAddress.setText("Địa chỉ : "+restaurantModelList.get(position).getAddress());
        holder.restaurantHours.setText("Hoạt động trong ngày : " + restaurantModelList.get(position).getHours().getTodaysHours());
        // bắt sự kiện click vào nhà hàng
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(restaurantModelList.get(position));
            }
        });
        // lấy hình từ đường dẫn url
        Glide.with(holder.thumbImage)
                // đồng thời đặt nó trên chế độ xem hình ảnh
                .load(restaurantModelList.get(position).getImage())
                .into(holder.thumbImage);

    }

    @Override
    //getItemCount - Đếm số Item trong List Data.
    public int getItemCount() {
        // lấy số kịch cỡ của list
        return restaurantModelList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        // khai báo biến để lấy id từ layout : recyler_row
        TextView  restaurantName;
        TextView  restaurantAddress;
        TextView  restaurantHours;
        ImageView thumbImage;

        // tạo ra phương thức MyViewHolder
        public MyViewHolder(View view) {
            super(view);
            restaurantName = view.findViewById(R.id.restaurantName);
            restaurantAddress = view.findViewById(R.id.restaurantAddress);
            restaurantHours = view.findViewById(R.id.restaurantHours);
            thumbImage = view.findViewById(R.id.thumbImage);

        }
    }

    // khi click vào nhà hàng giao diện xác định
    // khi click bất kì vị trí nào trong nhà hàng người dùng cũng có thể xem được menu nhà hàng
    public interface RestaurantListClickListener {
        // thêm mặt hàng vào trong menus
        // xử lý việc nhập chuột vào thêm tham số vào adapterRestaurant
        public void onItemClick(RestaurantModel restaurantModel);
    }


    // tìm kiếm
    @Override
    public Filter getFilter() {
        return new RestaurantFilter();
    }

    class  RestaurantFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charString = constraint.toString();
            if (charString.isEmpty()){
                // nếu rỗng list ban đầu bằng list  mới
                restaurantModelList = restaurantModelListOld;
            }
            else {
                List<RestaurantModel>   list = new ArrayList<>();
                for (RestaurantModel  row : restaurantModelListOld){
                    // check xem thằng nhà hàng nếu chưa ký tự mà chúng ta search
                    if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getAddress().contains(charString)){
                        list.add(row);
                    }
                }
                restaurantModelList = list ;
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = restaurantModelList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            restaurantModelList = (List <RestaurantModel>) results.values;
            notifyDataSetChanged();
        }
    }
}
