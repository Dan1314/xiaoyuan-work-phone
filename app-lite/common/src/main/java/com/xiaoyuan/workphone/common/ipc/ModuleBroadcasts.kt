package com.xiaoyuan.workphone.common.ipc

/** 跨 App 广播 Action（精简约定）。正式环境应加签名级 permission。 */
object ModuleBroadcasts {
    const val ACTION_CALL_STATE = "com.xiaoyuan.workphone.action.CALL_STATE"
    const val ACTION_POLICY_PUSH = "com.xiaoyuan.workphone.action.POLICY_PUSH"
    const val ACTION_OTA_AVAILABLE = "com.xiaoyuan.workphone.action.OTA_AVAILABLE"
    const val EXTRA_PAYLOAD = "payload"
}
