package com.xiaoyuan.workphone.agent

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.xiaoyuan.workphone.common.net.ApiPaths
import com.xiaoyuan.workphone.common.net.HttpClient
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

/** 设备服务：汇总通话/微信等上报队列并 POST 到占位 API。 */
class DeviceReportService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            val payload = """{"queue":"demo","items":0}"""
            val client = HttpClient.create(BuildConfig.API_BASE_URL)
            val req = Request.Builder()
                .url(BuildConfig.API_BASE_URL + ApiPaths.DEVICE_HEARTBEAT)
                .post(payload.toRequestBody("application/json".toMediaType()))
                .build()
            runCatching { client.newCall(req).execute().close() }
                .onFailure { Log.w(TAG, "report stub: ${it.message}") }
            stopSelf(startId)
        }.start()
        return START_NOT_STICKY
    }

    companion object { private const val TAG = "DeviceReport" }
}
