package com.xiaoyuan.workphone.agent

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.xiaoyuan.workphone.common.ipc.IWorkPhoneBridge

/** 通过 AIDL 向其他模块暴露 ping / 策略回执接口。 */
class BridgeBinderService : Service() {
    private val binder = object : IWorkPhoneBridge.Stub() {
        override fun ping(): Boolean = true
        override fun onPolicyUpdated(policyJson: String?) {
            Log.i(TAG, "policy ack len=${policyJson?.length ?: 0}")
        }
        override fun getModuleName(): String = "agent"
    }

    override fun onBind(intent: Intent?): IBinder = binder

    companion object { private const val TAG = "AgentBridge" }
}
