package com.xiaoyuan.workphone.workbench.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.xiaoyuan.workphone.common.base.BaseActivity
import com.xiaoyuan.workphone.workbench.R
import com.xiaoyuan.workphone.workbench.net.ApiConfig

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvBaseUrl).text = "API Base（占位）：${ApiConfig.baseUrl}"
        findViewById<Button>(R.id.btnCustomers).setOnClickListener {
            startActivity(Intent(this, CustomerListActivity::class.java))
        }
        findViewById<Button>(R.id.btnCalls).setOnClickListener {
            startActivity(Intent(this, CallRecordActivity::class.java))
        }
    }
}
