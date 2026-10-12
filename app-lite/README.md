# 工作手机 APP · 精简架构（`app-lite`）

Android 多模块骨架，演示 **小元工作手机** 端侧分层，不包含真实业务、签名配置或内部域名。

## 模块

| 模块 | 说明 |
|------|------|
| `:common` | 基类 `BaseActivity`、网络层 `HttpClient` / `ApiPaths` |
| `:workbench` | 「工作中心」演示 App：首页、客户列表、通话录音（Mock） |

## 运行

```bash
# 需要本机已安装 Android SDK / JDK 17
./gradlew :workbench:assembleDebug   # 首次请自行 gradle wrapper
```

`API_BASE_URL` 默认 `https://api.example.com`，仅占位，不会请求真实环境。

## 明确不包含

- 任何 keystore / 签名配置
- 内部 IP、正式域名、租户名、客户数据
- 微信协议、Hook、管控策略实现
