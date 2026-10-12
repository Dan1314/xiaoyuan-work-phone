# 工作手机 APP · 七端精简架构（`app-lite`）

对应正式产品七个 Android 应用进程的分层骨架，演示核心机制与 IPC，**不含**真实业务、签名证书或内部域名。

## 七端模块

| Gradle 模块 | 包名 | 产品名 | 示例机制 |
|-------------|------|--------|----------|
| `:workbench` | `com.xiaoyuan.workphone.workbench` | 工作中心 | CRM UI（Mock）、绑定 Agent AIDL |
| `:agent` | `com.xiaoyuan.workphone.agent` | 设备服务 | 上报队列桩、AIDL `IWorkPhoneBridge` |
| `:system` | `com.xiaoyuan.workphone.system` | 系统服务 | Config ContentProvider、通话状态观察 |
| `:bridge` | `com.xiaoyuan.workphone.bridge` | 连接服务 | 心跳保活、策略下行广播 |
| `:dialer` | `com.xiaoyuan.workphone.dialer` | 电话 | 通话状态监听、录音上传桩 |
| `:control` | `com.xiaoyuan.workphone.control` | 微信管控助手 | 策略接收与应用（日志桩） |
| `:ota` | `com.xiaoyuan.workphone.ota` | 应用更新 | 检查 / 下载 / 安装意图流程桩 |
| `:common` | library | 公共库 | `HttpClient`、`ApiPaths`、广播常量、AIDL |

## 构建

```bash
# 需要 Android SDK / JDK 17
./gradlew assembleDebug
# 或单模块
./gradlew :dialer:assembleDebug :control:assembleDebug :bridge:assembleDebug
```

`API_BASE_URL` 统一为 `https://api.example.com` 占位。

## 明确不包含

- keystore / 签名配置
- 内部 IP、正式域名、租户与客户数据
- 微信协议实现、Hook、真实静默安装
