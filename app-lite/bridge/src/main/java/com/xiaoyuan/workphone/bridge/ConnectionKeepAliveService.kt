package com.xiaoyuan.workphone.bridge

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import com.xiaoyuan.workphone.common.ipc.ModuleBroadcasts
import com.xiaoyuan.workphone.common.net.ApiPaths
import com.xiaoyuan.workphone.common.net.HttpClient
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * 连接保活 + 下行推送分发示例：定时心跳，收到策略时广播给管控助手。
 */
class ConnectionKeepAliveService : Service() {
    private val handler = Handler(Looper.getMainLooper())
    private val tick = object : Runnable {
        override fun run() {
            heartbeatOnce()
            handler.postDelayed(this, 30_000L)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler.removeCallbacks(tick)
        handler.post(tick)
        return START_STICKY
    }

    override fun onDestroy() {
        handler.removeCallbacks(tick)
        super.onDestroy()
    }

    private fun heartbeatOnce() {
        Thread {
            val client = HttpClient.create(BuildConfig.API_BASE_URL)
            val body = """{"module":"bridge"}""".toRequestBody("application/json".toMediaType())
            val req = Request.Builder()
                .url(BuildConfig.API_BASE_URL + ApiPaths.DEVICE_HEARTBEAT)
                .post(body)
                .build()
            runCatching {
                client.newCall(req).execute().use { resp ->
                    Log.i(TAG, "heartbeat code=${resp.code}")
                    // 演示：若服务端下发策略，则广播
                    if (resp.header("X-Demo-Policy") != null) {
                        sendBroadcast(
                            Intent(ModuleBroadcasts.ACTION_POLICY_PUSH)
                                .putExtra(ModuleBroadcasts.EXTRA_PAYLOAD, """{"cameraBlocked":true}"""),
                        )
                    }
                }
            }.onFailure { Log.w(TAG, "heartbeat stub: ${it.message}") }
        }.start()
    }

    companion object { private const val TAG = "BridgeKeepAlive" }
}
