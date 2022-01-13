package com.android.foodorderapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.R;
import com.android.foodorderapp.model.Menu;
import com.android.foodorderapp.model.RestaurantModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MyViewHolder> {
    // Khai báo một cái mảng data restaurantModel
    private List<Menu> menuList;
    // Khai báo sự kiện  click vào nhà hàng hiển thị menu
    private MenuListClickListener clickListener;

    // Khai báo phương thức của class RestaurantListAdapter
    public MenuListAdapter(List<Menu> menuList, MenuListClickListener clickListener) {
        this.menuList = menuList;
        this.clickListener = clickListener;
    }

    // khai báo phương thức update Data
    public void updateData(List<Menu> menuList) {
        this.menuList = menuList;
        //Chẳng hạn, đối với ArrayAdapter, có phương thức notifyDataSetChanged() nên được gọi sau khi bạn đã cập
        // nhật danh sách mảng chứa tất cả dữ liệu của bạn, để làm mới ListView
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    // onCreateViewHolder : phương thức dùng để tạo view mới
    // cho recyclerview onBindViewHolder : dùng để gắn data vào view
    public MenuListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recycler_row
                , parent, false);
        // trả lại kết quả
        return  new MyViewHolder(view);
    }

    @Override
    //onBindViewHolder - Thiết lập các thuộc tính của View và dữ liệu.
    //tham số position này để liên kết dữ liệu với view, việc này hoàn toàn ổn.
    public void onBindViewHolder(@NonNull MenuListAdapter.MyViewHolder holder, int position) {
        // triển khai bộ danh sách nah2 hàng
        holder.menuName.setText(menuList.get(position).getName());
        holder.menuPrice.setText("Gía tiền:"+menuList.get(position).getPrice()+" VND");

        // button cần phải xử lý action cho nó
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            // khi mà user click thi nút button này nó sẽ gọi constructor onAddToCartClick
            // trong class MenuListClickListener
            @Override
            public void onClick(View v) {
                Menu menu  = menuList.get(position);
                menu.setTotalInCart(1);

                //                truyền tham số vào
                clickListener.onAddToCartClick(menu);
                holder.addMoreLayout.setVisibility(View.VISIBLE);
                holder.addToCartButton.setVisibility(View.GONE);
                holder.tvCount.setText(menu.getTotalInCart()+"");
            }
        });

        // bắt sự kiện click vào item
        holder.imageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu menu  = menuList.get(position);
                int total = menu.getTotalInCart();
                total--;
                if(total > 0 ) {
                    menu.setTotalInCart(total);
                    clickListener.onUpdateCartClick(menu);
                    holder.tvCount.setText(total +"");
                } else {
                    holder.addMoreLayout.setVisibility(View.GONE);
                    holder.addToCartButton.setVisibility(View.VISIBLE);
                    menu.setTotalInCart(total);
                    clickListener.onRemoveFromCartClick(menu);
                }
            }
        });

        holder.imageAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu menu  = menuList.get(position);
                int total = menu.getTotalInCart();
                total++;
                if(total <= 10 ) {
                    menu.setTotalInCart(total);
                    clickListener.onUpdateCartClick(menu);
                    holder.tvCount.setText(total +"");
                }
            }
        });

        // lấy hình từ đường dẫn url
        Glide.with(holder.thumbImage)
                // đồng thời đặt nó trên chế độ xem hình ản
                // lấy hình ảnh bằng đường dẫn url
                .load(menuList.get(position).getUrl())
                .into(holder.thumbImage);

    }

    //getItemCount - Đếm số Item trong List Data.
    @Override
    public int getItemCount() {
        return menuList.size();
    }

    // tạo ra  MyViewHolder giao diện
    static class MyViewHolder extends RecyclerView.ViewHolder {
        // khai báo biến để lấy id từ layout : recyler_row
        TextView  menuName;
        TextView  menuPrice;
        TextView  addToCartButton;
        ImageView thumbImage;
        ImageView imageMinus;
        ImageView imageAddOne;
        TextView  tvCount;
        LinearLayout addMoreLayout;

        // tạo ra phương thức MyViewHolder
        public MyViewHolder(View view) {
            super(view);
            menuName = view.findViewById(R.id.menuName);
            menuPrice = view.findViewById(R.id.menuPrice);
            addToCartButton = view.findViewById(R.id.addToCartButton);
            thumbImage = view.findViewById(R.id.thumbImage);
            imageMinus = view.findViewById(R.id.imageMinus);
            imageAddOne = view.findViewById(R.id.imageAddOne);
            tvCount = view.findViewById(R.id.tvCount);

            addMoreLayout  = view.findViewById(R.id.addMoreLayout);
        }
    }

    // khi click vào nhà hàng giao diện xác định
    // khi click bất kì vị trí nào trong nhà hàng người dùng cũng có thể xem được menu nhà hàng
    public interface MenuListClickListener {
        // thêm mặt hàng vào trong menus
        // xử lý việc nhập chuột vào thêm tham số vào adapterRestaurant
        public void onAddToCartClick(Menu menu);
        public void onUpdateCartClick(Menu menu);
        public void onRemoveFromCartClick(Menu menu);
    }
}
