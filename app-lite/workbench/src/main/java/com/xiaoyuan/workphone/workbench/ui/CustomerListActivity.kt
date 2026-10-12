package com.xiaoyuan.workphone.workbench.ui

import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiaoyuan.workphone.common.base.BaseActivity
import com.xiaoyuan.workphone.workbench.R
import com.xiaoyuan.workphone.workbench.data.MockRepository

class CustomerListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = getString(R.string.tab_customers)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = SimpleTextAdapter(
            MockRepository.customers().map { "${it.name}  ${it.mobileMasked}  · ${it.stage}" },
        )
    }
}

internal class SimpleTextAdapter(private val rows: List<String>) :
    RecyclerView.Adapter<SimpleTextAdapter.VH>() {
    class VH(val view: TextView) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): VH {
        val tv = TextView(parent.context).apply {
            setPadding(24, 32, 24, 32)
            textSize = 16f
        }
        return VH(tv)
    }
    override fun onBindViewHolder(holder: VH, position: Int) { holder.view.text = rows[position] }
    override fun getItemCount(): Int = rows.size
}
