package com.example.project_trpp.ui.adapter;//package com.example.netwoevents.ui.adapter;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.navigation.Navigation;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.netwoevents.R;
//import com.example.netwoevents.domain.models.Item;
//
//import java.util.List;
//
//public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter <MyCustomRecyclerViewAdapter.ViewHolder>{
//        private final LayoutInflater inflater;
//        private final List<Item> items;
//        public static Context context;
//
//
//        public MyCustomRecyclerViewAdapter(Context context, List<Item> items) {
//            this.items = items;
//            this.inflater = LayoutInflater.from(context);
//            this.context = context;
//        }
//        @Override
//        public MyCustomRecyclerViewAdapter.ViewHolder
//        onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = inflater.inflate(R.layout.list_view_layout, parent, false);
//            return new ViewHolder(view);
//        }
//        @Override
//        public void onBindViewHolder(MyCustomRecyclerViewAdapter.ViewHolder
//                                 holder, int position) {
//            Item item = items.get(position);
//            holder.textView.setText(item.getText());
//            holder.imageView.setImageResource(item.getImage());
//            holder.imageView.setTag(item.getImage());
//        }
//        @Override
//        public int getItemCount() {
//            return items.size();
//        }
//        public class ViewHolder extends
//                RecyclerView.ViewHolder {
//            final TextView textView;
//            final ImageView imageView;
//            ViewHolder(View view){
//                super(view);
//                textView = view.findViewById(R.id.item_text);
//                imageView = view.findViewById(R.id.item_image);
//
//
//                view.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View view) {
//
//
//                        Bundle bundle = new Bundle();
//                        bundle.putString("bundleText", (String) textView.getText());
//                        bundle.putInt("bundleImage", (int) imageView.getTag());
//                        Navigation.findNavController(view).navigate(R.id.action_eventRecyclerFragment_to_showItemEventFragment, bundle);
//
//                        String value = (String) textView.getText();
//                        Toast.makeText(context, value +"!",
//                                Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//            }
//        }
//
//
//}
//

