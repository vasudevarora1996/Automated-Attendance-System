package com.example.vasudev.attendancesystem;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {


    private Context mCtx;
    public String name;
    private List<Product> productList;

    public ProductsAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.textViewName.setText(String.valueOf(product.getName()));
        name=product.getName().toString();
        holder.textViewDate.setText(product.getDate());
        holder.textViewTime.setText(product.getTime());
        holder.textViewCard_Id.setText(String.valueOf(product.getCard_id()));

        if (name.equalsIgnoreCase("Vasu")) holder.imageView.setImageResource(R.drawable.vasudev1234);
        else if (name.equalsIgnoreCase("Simran")) holder.imageView.setImageResource(R.drawable.simran);
        else if (name.equalsIgnoreCase("Bittu")) holder.imageView.setImageResource(R.drawable.bittu);
        else holder.imageView.setImageResource(R.drawable.lpu);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDate, textViewTime, textViewCard_Id, textViewName;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewDate = itemView.findViewById(R.id.textViewTitle);
            textViewTime = itemView.findViewById(R.id.textViewShortDesc);
            textViewCard_Id = itemView.findViewById(R.id.textViewRating);
            textViewName = itemView.findViewById(R.id.textViewPrice);
            imageView=itemView.findViewById(R.id.imageView123);


        }
    }
}
