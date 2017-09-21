package com.example.lixin.yuekaotest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lixin.yuekaotest.R;
import com.example.lixin.yuekaotest.bean.DataBean;
import com.example.lixin.yuekaotest.utils.OkhttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by hua on 2017/9/21.
 */

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        OkhttpUtils.sendOkHttpRequest("http://139.196.140.118:8080/get/%7B%22%5B%5D%22:%7B%22page%22:0,%22count%22:10,%22Moment%22:%7B%22content$%22:%22%2525a%2525%22%7D,%22User%22:%7B%22id@%22:%22%252FMoment%252FuserId%22,%22@column%22:%22id,name,head%22%7D,%22Comment%5B%5D%22:%7B%22count%22:2,%22Comment%22:%7B%22momentId@%22:%22%5B%5D%252FMoment%252Fid%22%7D%7D%7D%7D", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);
//                final List<DataBean.DatasBean.CommentBean> list = dataBean.getDatas();
                final List<DataBean.DatasBean> datas = dataBean.getDatas();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "数据"+datas, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}
