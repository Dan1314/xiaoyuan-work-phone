package com.xiaoyuan.workphone.system

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.xiaoyuan.workphone.common.ipc.ModuleBroadcasts

/** 系统服务侧：监听电话模块广播，演示通话记录入库钩子（桩）。 */
class CallLogObserverStub : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != ModuleBroadcasts.ACTION_CALL_STATE) return
        val state = intent.getStringExtra(ModuleBroadcasts.EXTRA_PAYLOAD)
        Log.i("SystemCallLog", "observe call state=$state → enqueue local DB stub")
    }
}
