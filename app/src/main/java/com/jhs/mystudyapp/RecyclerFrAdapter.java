package com.jhs.mystudyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFrAdapter extends RecyclerView.Adapter<RecyclerFrAdapter.ViewHolder>{
    private ArrayList<RecyclerFrItemData> localDataSet;

    //===== 뷰홀더 클래스 =====================================================
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
        public TextView getTextView() {
            return textView;
        }
    }
    //=======================================================================
    //----- 생성자 --------------------------------------
    // 생성자를 통해서 데이터를 전달받도록 함
    public RecyclerFrAdapter(ArrayList<RecyclerFrItemData> dataSet) {
        localDataSet = dataSet;
    }
    //--------------------------------------------------

    public interface MyRecyclerViewClickListener{
        void onItemClicked(int position);
        void onTitleClicked(int position);
        void onContentClicked(int position);
        void onItemLongClicked(int position);
        void onImageViewClicked(int position);
    }

    private MyRecyclerViewClickListener mListener;

    public void setOnClickListener(MyRecyclerViewClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override   // ViewHolder 객체를 생성하여 리턴한다.
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recycler_fr_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override   // ViewHolder안의 내용을 position에 해당되는 데이터로 교체한다.
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerFrItemData text = localDataSet.get(position);
        holder.textView.setText(text.getName());
        holder.textView.setText(text.getAge());
        holder.textView.setText(text.getSex());

    }

    @Override   // 전체 데이터의 갯수를 리턴한다.
    public int getItemCount() {
        return localDataSet.size();
    }
}
