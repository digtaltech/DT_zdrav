package com.example.dtzdrav;

import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class fetchData extends AsyncTask<Void,Void,Void> {
    //public String data ="";
    //public JSONArray JA;
    public Map<Integer, DataMarker> arrayListData = new HashMap<>();
    @Override
    protected Void doInBackground(Void... voids) {
       /* try {
            URL url = new URL("https://api.myjson.com/bins/z9bud");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data += line;
            }
            if (data.isEmpty()) setJA();
            else
            JA = new JSONArray(data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        //setJA();
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        setJA();
        /*try {
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                MapsActivity.mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(JO.get("v").toString()), Double.parseDouble(JO.get("v1").toString()))).title(JO.get("name").toString()));
                //ListActivity.mGroupsArray.add(JO.get("name").toString());
            }
        }catch (JSONException e){
            e.printStackTrace();
        }*/
    }

    private void setJA(){
        //try {
            /*URL url = new URL("https://api.myjson.com/bins/xpen3");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data += line;
            }
*/
            //JA = new JSONArray("[{\"id\":1,\"name\":\"Сломанный фонарь\",\"v\":43.585371,\"v1\":39.723416,\"usver\":\"digtech\",\"Text\":\"Сломанный фонарь из-за которого улица остается без света. Как жить то?\"},{\"id\":2,\"name\":\"ебаный кубань энерго\",\"v\":43.637554,\"v1\":39.688919,\"usver\":\"Vampire\",\"Text\":\"опять свет вырубили пидарасы, а не, дерево упало\"},{\"id\":3,\"name\":\"Ебана пробка\",\"v\":43.581487,\"v1\":39.722946,\"usver\":\"KirSid\",\"Text\":\"Ебалай таксист аварию устроил. Корку надо\"}]");

        /*} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        /} catch (JSONException e) {
            e.printStackTrace();
        }*/
        String str = "ID=1%CordX=43.438737%CordY=39.913822%MarkerName=Купить болеутоляющее%Creater=Самойленко Иван%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=Ул.Полякова 98%Phone=+79181351234%DrugList=Нурофен,Аспирин%CellAdress=Ул.Уральская 128%Coment=Изо дня в день чувстввую сильные боли в связи внутречерепного давления. Откликнитесь кто сможет, нужно съездить за препаратами;;ID=2%CordX=43.442031%CordY=39.910458%MarkerName=Забрать заказ из аптеки%Creater=Гриценко Никита%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=Ул.Черная 42%Phone=+79181351234%DrugList=набор бинтов, Гербион%CellAdress=Ул.Уральская 128%Coment=Купила препараты в аптеке, которая находится прямо под домом, но я не могу встать с кровати. Кто сможет выполнить мою просьбу?;;ID=3%CordX=43.422361%CordY=39.930789%MarkerName=Срочно нужны жгуты%Creater=Ермаков Игорь%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Вишнякова 12%Phone=+79184561313%DrugList=Жгуты,бинты,пластыри.%CellAdress=Ул.Уральская 128%Coment=Мой организм требует ежедневной инъекции, но дома закончились жгут;;ID=4%CordX=43.595831%CordY=39.728703%MarkerName=Сходить за инсулином%Creater=Дмитриев Павел%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Северная 17%Phone=+79189059055%DrugList=Инсулин%CellAdress=Ул.Уральская 128%Coment=Поднялся сахар в крови, чувствую себя очень плохо, прошу срочно отреагировать на мой заказ. Нужна помощь!!!;;ID=5%CordX=43.594874%CordY=39.724903%MarkerName=Забрать заказ из аптеки%Creater=Мусиенко Дмитрий%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Горная%Phone=+79189052120%DrugList=набор шин,костыли.%CellAdress=Ул.Уральская 128%Coment=Атека находится далеко, из за возраста не могу преодолевать такие большие расстояния;;ID=6%CordX=43.595186%CordY=39.718502%MarkerName=Доставить лекарства брату%Creater=Рогонян Александр%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Верхняя%Phone=+79184561313%DrugList=Инсулин%CellAdress=Ул.Уральская 128%Coment=Мой брат нахится при смерти, ему нужно облегчить боль, доставьте пожалуйста лекарства;;ID=7%CordX=43.596177%CordY=39.730851%MarkerName=Забрать заказ из аптеки%Creater=Авдеева Мария%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Ставрапольская 49%Phone=+79889544509%DrugList=Йод,Зеленка.%CellAdress=Ул.Уральская 128%Coment=Аптека не далеко от дома, так что заказ можно выполнить в кратчайшие сроки;;ID=8%CordX=43.598605%CordY=39.737147%MarkerName=Привезти пластырей%Creater=Адолина Дарья%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Старая 96%Phone=+79887777777%DrugList=Пластыри%CellAdress=Ул.Уральская 128%Coment=Пожилой человек, случайно порезался, сделал заказ в аптеке пожалуйста привезите медикаменты;;ID=9%CordX=43.614289%CordY=39.712834%MarkerName=Доставить кресло-каталку%Creater=Михеев Семен%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Гагарина%Phone=+79886077899%DrugList=Кресло-каталка%CellAdress=Ул.Уральская 128%Coment=Инвалид, не могу самостоятельно передвигаться, купил кресло-каталку, просьба доставить кому не сложно, буду очень признателен;;ID=10%CordX=43.59929%CordY=39.72267%MarkerName=Забрать заказ из аптеки%Creater=Орловский Всеволод%PharmacyAdress=ул. Ярославского, 62/1%CreaterAdress=ул.Климова 43%Phone=+79889215679%DrugList=Морфин%CellAdress=Ул.Уральская 128%Coment=Препараты уже в аптеке надо только забрать и привезти, буду очень благодарен";
        String[] strings = str.split(";;");
        //Map<Integer,ArrayList<String>> listMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            DataMarker dataMarker = new DataMarker(strings[i]);
            dataMarker.setNumArray(i);
            arrayListData.put(i,dataMarker);
            MapsActivity.mMap.addMarker(new MarkerOptions().position(dataMarker.getLatLng()).title(dataMarker.getMarkerName()));
        }
    }//MapsActivity.mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(JO.get("v").toString()), Double.parseDouble(JO.get("v1").toString()))).title(JO.get("name").toString()));
}
