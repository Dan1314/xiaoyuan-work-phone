package com.xiaoyuan.workphone.control

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.xiaoyuan.workphone.common.ipc.ModuleBroadcasts

/** 接收连接服务/设备服务下发的管控策略广播，转交应用服务。 */
class PolicyPushReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != ModuleBroadcasts.ACTION_POLICY_PUSH) return
        val payload = intent.getStringExtra(ModuleBroadcasts.EXTRA_PAYLOAD) ?: return
        context.startService(
            Intent(context, PolicyApplyService::class.java)
                .putExtra(ModuleBroadcasts.EXTRA_PAYLOAD, payload),
        )
    }
}
