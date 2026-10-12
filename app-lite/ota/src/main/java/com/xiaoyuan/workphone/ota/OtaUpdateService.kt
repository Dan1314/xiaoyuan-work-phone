package com.xiaoyuan.workphone.ota

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.xiaoyuan.workphone.common.ipc.ModuleBroadcasts
import com.xiaoyuan.workphone.common.net.ApiPaths
import com.xiaoyuan.workphone.common.net.HttpClient
import okhttp3.Request
import org.json.JSONObject

/**
 * OTA 流程示例：检查 → 下载（桩）→ 安装意图（桩）。
 * 不包含真实签名校验与安装器调用。
 */
class OtaUpdateService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            try {
                val client = HttpClient.create(BuildConfig.API_BASE_URL)
                val req = Request.Builder()
                    .url(BuildConfig.API_BASE_URL + ApiPaths.OTA_CHECK + "?module=workbench&vc=1")
                    .get()
                    .build()
                runCatching {
                    client.newCall(req).execute().use { resp ->
                        val body = resp.body?.string().orEmpty()
                        val json = runCatching { JSONObject(body) }.getOrElse { JSONObject() }
                        val available = json.optBoolean("available", false)
                        Log.i(TAG, "ota check available=$available")
                        if (available) {
                            val url = json.optString("downloadUrl", "https://api.example.com/ota/demo.apk")
                            Log.i(TAG, "download stub url=$url")
                            // 此处仅演示；正式产品应校验证书指纹后再静默/提示安装
                            sendBroadcast(
                                Intent(ModuleBroadcasts.ACTION_OTA_AVAILABLE)
                                    .putExtra(ModuleBroadcasts.EXTRA_PAYLOAD, url),
                            )
                        }
                    }
                }.onFailure { Log.w(TAG, "ota stub: ${it.message}") }
            } finally {
                stopSelf(startId)
            }
        }.start()
        return START_NOT_STICKY
    }

    companion object { private const val TAG = "OtaUpdate" }
}
