package com.xiaoyuan.workphone.workbench.net

import com.xiaoyuan.workphone.workbench.BuildConfig

/** 读取 BuildConfig 中的占位 Base URL，切勿在源码中硬编码真实环境。 */
object ApiConfig {
    val baseUrl: String = BuildConfig.API_BASE_URL
}
