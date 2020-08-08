package com.example.danhba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ContacViewHolder> {
    Context mContext;
    List<Contact> contactList;

    public AdapterContact(Context mContext, int item_contact, List<Contact> contactList) {
        this.mContext = mContext;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        return new ContacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContacViewHolder holder, int position) {
        Contact contact=contactList.get(position);
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
        if (contact.getImg() !=null)
        {
            Picasso.get().load(contact.getImg()).into(holder.img);
        }else
        {
            holder.img.setImageResource(R.mipmap.ic_launcher_round);
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContacViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone;
        CircleImageView img;

        public ContacViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.ten);
            phone=itemView.findViewById(R.id.dienthoai);
            img=itemView.findViewById(R.id.image1);
        }
    }
}
