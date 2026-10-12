package com.xiaoyuan.workphone.control

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.xiaoyuan.workphone.common.ipc.ModuleBroadcasts
import org.json.JSONObject

/**
 * 策略应用示例：解析 JSON，演示「禁止相机 / 应用黑名单」等开关落盘意图。
 * 精简版只写日志，不改系统设置。
 */
class PolicyApplyService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val raw = intent?.getStringExtra(ModuleBroadcasts.EXTRA_PAYLOAD).orEmpty()
        runCatching {
            val json = JSONObject(raw.ifBlank { """{"cameraBlocked":false,"blockedPackages":[]}""" })
            val cameraBlocked = json.optBoolean("cameraBlocked", false)
            val blocked = json.optJSONArray("blockedPackages")
            Log.i(TAG, "apply policy cameraBlocked=$cameraBlocked blockedCount=${blocked?.length() ?: 0}")
        }.onFailure { Log.w(TAG, "bad policy json: ${it.message}") }
        stopSelf(startId)
        return START_NOT_STICKY
    }

    companion object { private const val TAG = "PolicyApply" }
}
