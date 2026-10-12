package com.xiaoyuan.workphone.common.net

/** REST 路径常量，仅作结构示例；Base URL 见各模块 BuildConfig。 */
object ApiPaths {
    const val CUSTOMERS = "/api/v1/customers"
    const val CALL_RECORDS = "/api/v1/call-records"
    const val CALL_RECORDING_UPLOAD = "/api/v1/call-records/recording"
    const val WECHAT_ALERTS = "/api/v1/wechat/alerts"
    const val DEVICE_POLICY = "/api/v1/devices/policy"
    const val DEVICE_HEARTBEAT = "/api/v1/devices/heartbeat"
    const val OTA_CHECK = "/api/v1/ota/check"
    const val PUSH_ACK = "/api/v1/push/ack"
}
