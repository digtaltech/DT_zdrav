package com.example.dtzdrav

import android.app.Dialog
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.navigation.Model
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.card.*
import java.util.*
import android.widget.TextView



class MenuActivity : AppCompatActivity() {
    companion object {
        lateinit var array: FetchDataList
        private const val ID_HOME = 1
        private const val ID_EXPLORE = 2
        //private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 3
        private const val ID_ACCOUNT = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //tv_selected.setTypeface(Typeface.createFromAsset(assets, "fonts/SourceSansPro-Regular.ttf"));

        bottomNavigation.add(Model(ID_HOME, R.drawable.ic_home))
        bottomNavigation.add(Model(ID_EXPLORE, R.drawable.ic_explore))
        //bottomNavigation.add(Model(ID_MESSAGE, R.drawable.ic_message))
        bottomNavigation.add(Model(ID_NOTIFICATION, R.drawable.ic_dehaze_black_24dp))
        bottomNavigation.add(Model(ID_ACCOUNT, R.drawable.ic_account))

        /*设置下角标*/
        bottomNavigation.setCount(ID_HOME, "1")
        bottomNavigation.show(1,true)

        bottomNavigation.setOnShowListener {
            val name = when (it.id) {
                ID_HOME -> setFragment(HomeActivity.newInstance())
                ID_EXPLORE -> setFragment(MapsActivity.newInstance())
                //ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> setFragment(ListActivity.newInstance())
                ID_ACCOUNT -> setFragment(ProfileActivity.newInstance())
                else -> null
            }
            //tv_selected.text = "$name page is selected"
        }

        bottomNavigation.setOnClickMenuListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_EXPLORE -> "EXPLORE"
                //ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> "NOTIFICATION"
                ID_ACCOUNT -> "ACCOUNT"
                else -> ""
            }
            //Toast.makeText(this, "$name is clicked", Toast.LENGTH_SHORT).show()
        }
        array = FetchDataList()
        array.execute()

    }

    fun setFragment(selectedFragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, selectedFragment)
        transaction.commit()
    }

    fun onClickList(view: View){
        val d = Dialog(this)
        d.window!!.setBackgroundDrawableResource(R.color.mtrl_btn_transparent_bg_color)
        // Передайте ссылку на разметку
        d.setContentView(R.layout.card)
        val rand = Random()
        val textName = d.findViewById(R.id.textView2) as TextView
        val textText = d.findViewById(R.id.textView3) as TextView
        val textUsver = d.findViewById(R.id.textView5) as TextView
        val textPhone = d.findViewById(R.id.textView6) as TextView
        val i = rand.nextInt(array.arrayListData.size)
        textName.setText(array.arrayListData.get(i)!!.getMarkerName())
        textText.setText(array.arrayListData.get(i)!!.getComent())
        textUsver.setText(array.arrayListData.get(i)!!.getCreater())
        textPhone.setText(array.arrayListData.get(i)!!.getPhone())

        d.setCanceledOnTouchOutside(true)
        d.show()
    }
}
