package com.xiaoyuan.workphone.system

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri

/**
 * 系统服务配置 ContentProvider 示例：其他模块可查询当前端点占位信息。
 * 仅返回示例行，不含真实域名。
 */
class DemoConfigProvider : ContentProvider() {
    override fun onCreate(): Boolean = true

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?,
    ): Cursor {
        return MatrixCursor(arrayOf("key", "value")).apply {
            addRow(arrayOf("apiBaseUrl", "https://api.example.com"))
            addRow(arrayOf("module", "system"))
        }
    }

    override fun getType(uri: Uri): String = "vnd.android.cursor.dir/demo-config"
    override fun insert(uri: Uri, values: ContentValues?): Uri? = null
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int = 0
}
