package com.example.android.loginretrofittest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {

    private Context mContext;

    //private List<OrdersItem> OrdersList;
    private List<Order> ordersList;
//    private List<Dish> dishesList;



    public OrdersAdapter(Context mContext, List<Order> mOrdersList) {
        this.mContext = mContext;
        this.ordersList = mOrdersList;
    }


//    public OrdersAdapter(Context mContext, List<Dish> mDishesList) {
//        this.mContext = mContext;
//        this.dishesList = mDishesList;
//    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.orders_item, parent, false);
        return new OrdersViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull OrdersViewHolder ordersViewHolder, final int position) {

        //TODO comment name and uncomment order
        final Order order = ordersList.get(position);
//        Dish dishes = dishesList.get(position);

//        User user = mOrdersList.get(position);
        int statusValue = order.getStatus();

        ordersViewHolder.textViewOrderId.setText(String.valueOf(order.getId()));
        ordersViewHolder.textViewOrderTime.setText(order.getOrderTime());
//        ordersViewHolder.textViewSubtotal.setText(String.valueOf(order.getSubtotal()));
//        ordersViewHolder.textViewStatus.setText(String.valueOf(order.getStatus()));
        switch (statusValue){
            case 0:
                ordersViewHolder.textViewStatus.setText("Waiting");
                ordersViewHolder.textViewStatus.setBackgroundResource(R.color.colorWaiting);
                break;
            case 1:
                ordersViewHolder.textViewStatus.setText("Cooking");
                ordersViewHolder.textViewStatus.setBackgroundResource(R.color.colorCooking);
                break;
            case 2:
                ordersViewHolder.textViewStatus.setText("Ready");
                ordersViewHolder.textViewStatus.setBackgroundResource(R.color.colorReady);
                break;
            case 3:
                ordersViewHolder.textViewStatus.setText("Delivered");
                ordersViewHolder.textViewStatus.setBackgroundResource(R.color.colorDelivered);
                break;
            case 4:
                ordersViewHolder.textViewStatus.setText("Canceled");
                ordersViewHolder.textViewStatus.setBackgroundResource(R.color.colorCanceled);
                break;
            default:
                ordersViewHolder.textViewStatus.setText("Waiting");
                ordersViewHolder.textViewStatus.setBackgroundResource(R.color.colorWaiting);
                break;
        }

        //TODO: the delivered status appears in current fragment
        //TODO: serialize all underscores like creation_time

//        ordersViewHolder.textViewDishType.setText(dishes.getType());
//        ordersViewHolder.textViewDishName.setText(dishes.getDishName());
//        ordersViewHolder.textViewDishLocation.setText(dishes.getLocation());

        ordersViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(mContext, OrderDetailsActivity.class);
                intent.putExtra("order", order);
//                Bundle bundle = new Bundle();
//                bundle.putInt("OrderId", ordersList.get(position).getOrderId());
                mContext.startActivity(intent);

//TODO: check activity flags
            }
        });

    }

    @Override
    public int getItemCount() {

        return ordersList.size();
//        return dishesList.size();
    }

    public class OrdersViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewOrderId;
        public TextView textViewOrderTime;
//        public TextView textViewSubtotal;
        public TextView textViewStatus;

//        public TextView textViewDishType;
//        public TextView textViewDishName;
//        public TextView textViewDishLocation;

        public CardView cardView;


        public OrdersViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewOrderId = itemView.findViewById(R.id.textViewOrderId);
            textViewOrderTime = itemView.findViewById(R.id.textViewOrderTime);
//            textViewSubtotal = itemView.findViewById(R.id.textViewSubtotal);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);


//            textViewDishType = itemView.findViewById(R.id.textViewDishType);
//            textViewDishName = itemView.findViewById(R.id.textViewDishName);
//            textViewDishLocation = itemView.findViewById(R.id.textViewDishLocation);
            cardView = itemView.findViewById(R.id.cardViewId);

        }
    }
}

//TODO XML differences
