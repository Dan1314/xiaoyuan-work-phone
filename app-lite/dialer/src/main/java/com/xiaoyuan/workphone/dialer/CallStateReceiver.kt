package com.xiaoyuan.workphone.dialer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import com.xiaoyuan.workphone.common.ipc.ModuleBroadcasts

/**
 * 通话状态监听示例：响铃/接通/挂断时广播给工作中心与设备服务，
 * 挂断后拉起录音上传桩服务。
 */
class CallStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != TelephonyManager.ACTION_PHONE_STATE_CHANGED) return
        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE) ?: return
        Log.i(TAG, "call state=$state")
        context.sendBroadcast(
            Intent(ModuleBroadcasts.ACTION_CALL_STATE).putExtra(ModuleBroadcasts.EXTRA_PAYLOAD, state),
        )
        if (state == TelephonyManager.EXTRA_STATE_IDLE) {
            context.startService(Intent(context, RecordingUploadService::class.java))
        }
    }

    companion object { private const val TAG = "DialerCallState" }
}
