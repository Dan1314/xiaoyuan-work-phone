package com.xiaoyuan.workphone.workbench.ipc

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.xiaoyuan.workphone.common.ipc.IWorkPhoneBridge

/** 工作中心绑定设备服务 AIDL 的示例客户端。 */
class AgentBridgeClient(private val context: Context) {
    private var bridge: IWorkPhoneBridge? = null

    private val conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            bridge = IWorkPhoneBridge.Stub.asInterface(service)
            Log.i(TAG, "bound module=${bridge?.moduleName} ping=${bridge?.ping()}")
        }
        override fun onServiceDisconnected(name: ComponentName?) { bridge = null }
    }

    fun bind() {
        val intent = Intent("com.xiaoyuan.workphone.action.BIND_BRIDGE").setPackage("com.xiaoyuan.workphone.agent")
        context.bindService(intent, conn, Context.BIND_AUTO_CREATE)
    }

    fun unbind() {
        runCatching { context.unbindService(conn) }
        bridge = null
    }

    companion object { private const val TAG = "AgentBridgeClient" }
}
