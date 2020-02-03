package jp.techacademy.madoka.iwasaki

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

// 追加
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.app.TimePickerDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // ボタンが押されたら、TimePickerDialogを表示
        showTimePickerDialog()
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                judgeAisatsu(hour, minute)
            },
            // 時間・分の初期値、true→24時間表記
            13, 0, true)
        timePickerDialog.show()

    }

    private fun judgeAisatsu(hour:Int, minute:Int){
        if((hour >= 2) && (hour <= 9)){ // 10時以降、17時代以内であれば
            textView.text = "おはよう"
        } else if((hour >= 10) && (hour <= 17)){ // 10時以降、17時代以内であれば
            textView.text = "こんにちは"
        } else {
            textView.text = "こんばんは"
        }
    }


}
