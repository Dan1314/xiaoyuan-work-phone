package com.xiaoyuan.workphone.workbench.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiaoyuan.workphone.common.base.BaseActivity
import com.xiaoyuan.workphone.workbench.R
import com.xiaoyuan.workphone.workbench.data.MockRepository

class CallRecordActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = getString(R.string.tab_calls)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = SimpleTextAdapter(
            MockRepository.callRecords().map {
                val flag = if (it.recorded) "已录音" else "无录音"
                "${it.customer}  ${it.durationSec}s  · $flag"
            },
        )
    }
}
