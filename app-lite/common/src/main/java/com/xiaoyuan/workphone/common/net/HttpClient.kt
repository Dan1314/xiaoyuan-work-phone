package com.xiaoyuan.workphone.common.net

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * 网络层骨架。正式环境请把 [baseUrl] 换成自有域名，并通过 HTTPS + 鉴权接入。
 * 本仓库默认使用占位域名，不会发起真实请求。
 */
object HttpClient {
    fun create(baseUrl: String): OkHttpClient {
        require(baseUrl.startsWith("https://")) { "API base URL must be HTTPS" }
        return OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }
}
