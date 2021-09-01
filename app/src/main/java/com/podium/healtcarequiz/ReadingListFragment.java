package com.podium.healtcarequiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.podium.healtcarequiz.databinding.FragmentReadingListBinding;
import com.podium.healtcarequiz.databinding.SingleRowLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class ReadingListFragment extends Fragment {

    private com.podium.healtcarequiz.databinding.FragmentReadingListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentReadingListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public List<String> generateDummyData() {
        ArrayList<String> links = new ArrayList<>();
        links.add("https://www.who.org");
        links.add("https://www.who.org");
        links.add("https://www.who.org");
        links.add("https://www.wiki.org");
        links.add("https://www.wiki.org");
        links.add("https://www.wiki.org");
        links.add("https://www.who.org");
        links.add("https://www.who.org");
        links.add("https://www.who.org");
        links.add("https://www.who.org");
        links.add("https://www.wiki.org");
        links.add("https://www.wiki.org");
        links.add("https://www.wiki.org");
        links.add("https://www.wiki.org");
        return links;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinkAdapter adapter = new LinkAdapter(R.layout.single_row_layout, generateDummyData());
        LinearLayoutManager layoutMgr = new LinearLayoutManager(getActivity());
        binding.readingList.setLayoutManager(layoutMgr);
        binding.readingList.setAdapter(adapter);
    }

    //    Adapter
    //    ViewHolder
    class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.ViewHolder> {

        private final int layout;
        private final List<String> links;
        private final LayoutInflater inflater;

        public LinkAdapter(int layout, List<String> links){
            this.layout = layout;
            this.links = links;
            inflater = LayoutInflater.from(getActivity());
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = inflater.inflate(layout,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String data = links.get(position);
            holder.bind(data);
        }

        @Override
        public int getItemCount() {
            return links.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private final SingleRowLayoutBinding binder;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                binder = SingleRowLayoutBinding.bind(itemView);
            }
            public void bind(String data){
                binder.textLink.setText(data);
            }
        }
    }
}