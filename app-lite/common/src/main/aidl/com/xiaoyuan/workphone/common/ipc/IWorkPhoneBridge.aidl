package com.xiaoyuan.workphone.common.ipc;

/**
 * 七端 App 之间的轻量 IPC 契约（精简示例）。
 * 正式产品可扩展更多方法；此处仅演示 keepalive / 策略推送回执。
 */
interface IWorkPhoneBridge {
    boolean ping();
    void onPolicyUpdated(String policyJson);
    String getModuleName();
}
