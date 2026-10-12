package com.xiaoyuan.workphone.dialer

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.xiaoyuan.workphone.common.net.ApiPaths
import com.xiaoyuan.workphone.common.net.HttpClient
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * 通话录音上传桩：仅演示「读本地占位路径 → HTTPS POST」流程。
 * 不会读取真实通话录音，也不会连接生产环境。
 */
class RecordingUploadService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            try {
                val client = HttpClient.create(BuildConfig.API_BASE_URL)
                val body = """{"callId":"demo-call","file":"placeholder.mp3"}"""
                    .toRequestBody("application/json".toMediaType())
                val req = Request.Builder()
                    .url(BuildConfig.API_BASE_URL + ApiPaths.CALL_RECORDING_UPLOAD)
                    .post(body)
                    .build()
                // 演示构架：不强制执行网络；失败仅打日志
                runCatching { client.newCall(req).execute().close() }
                    .onFailure { Log.w(TAG, "upload stub skipped: ${it.message}") }
            } finally {
                stopSelf(startId)
            }
        }.start()
        return START_NOT_STICKY
    }

    companion object { private const val TAG = "RecordingUpload" }
}
