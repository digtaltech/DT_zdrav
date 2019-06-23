package com.example.dtzdrav;

import android.app.Dialog;
import android.app.LauncherActivity;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListActivity extends Fragment {
    public static ListActivity newInstance() {
        ListActivity fragment = new ListActivity();
        return fragment;
    }

    public static Map<Integer, ArrayList<String>> map = MenuActivity.array.listMap;
    //public static ArrayList<String> mGroupsArray = MenuActivity.array;

    private String[] mWinterMonthsArray = new String[] { "Декабрь", "Январь", "Февраль" };
    private String[] mSpringMonthsArray = new String[] { "Март", "Апрель", "Май" };
    private String[] mSummerMonthsArray = new String[] { "Июнь", "Июль", "Август" };
    private String[] mAutumnMonthsArray = new String[] { "Сентябрь", "Октябрь", "Ноябрь" };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list, container, false);
        //FetchDataList fetchData = new FetchDataList();
        //fetchData.execute();
        /*try {
            for (int i = 0; i < fetchData.JA.length(); i++) {
                JSONObject JO = (JSONObject) fetchData.JA.get(i);
                mGroupsArray.add(JO.get("name").toString());
                //MapsActivity.mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(JO.get("v").toString()), Double.parseDouble(JO.get("v1").toString()))).title(JO.get("name").toString()));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }*/
        Map<String, String> map;
        Map<String, String> mmap;
        // коллекция для групп
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
        // заполняем коллекцию групп из массива с названиями групп
        ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();
        for (int group : this.map.keySet()) {
            // заполняем список атрибутов для каждой группы
            map = new HashMap<>();
            map.put("groupName", this.map.get(group).get(0)); // время года
            groupDataList.add(map);

            String str = groupDataList.get(group).get("groupName");
            mmap = new HashMap<>();
            mmap.put("monthName", this.map.get(group).get(1)); // название месяца
            сhildDataItemList.add(mmap);
            ArrayList<Map<String, String>> arr = new ArrayList<>();
            arr.add(mmap);
            сhildDataList.add(arr);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[] { "groupName" };
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[] { android.R.id.text1 };

        // создаем общую коллекцию для коллекций элементов
        //ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        // в итоге получится сhildDataList = ArrayList<сhildDataItemList>

        // создаем коллекцию элементов для первой группы
        //ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
        // заполняем список атрибутов для каждого элемента
        /*for (int i = 0; i < groupDataList.size(); i++){
            String str = groupDataList.get(i).get("groupName");
            map = new HashMap<>();
            map.put("monthName", this.map.get()); // название месяца
            //сhildDataItemList.add(map);
            ArrayList<Map<String, String>> arr = new ArrayList<>();
            arr.add(map);
            сhildDataList.add(arr);
        }*/
        // добавляем в коллекцию коллекций


        /*/ создаем коллекцию элементов для второй группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mSpringMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для третьей группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mSummerMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        /* создаем коллекцию элементов для четвертой группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mAutumnMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);*/

        // список атрибутов элементов для чтения
        String childFrom[] = new String[] { "monthName" };
        // список ID view-элементов, в которые будет помещены атрибуты
        // элементов
        int childTo[] = new int[] { android.R.id.text1 };

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                //this, R.layout.listlayout, R.id.listTextView, mGroupsArray

                view.getContext(), groupDataList,
                R.layout.listlayout, groupFrom,
                groupTo, сhildDataList, R.layout.listlayout2,
                childFrom, childTo);

        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);
        return view;
    }

    /*public void onClickList(View view){
        Dialog dialog;
        dialog = new Dialog(view.getContext());
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        // Передайте ссылку на разметку
        dialog.setContentView(R.layout.card);

        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }*/
}
