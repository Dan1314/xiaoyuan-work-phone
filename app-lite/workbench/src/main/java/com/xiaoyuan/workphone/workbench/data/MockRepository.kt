package com.xiaoyuan.workphone.workbench.data

data class Customer(val name: String, val mobileMasked: String, val stage: String)
data class CallRecord(val customer: String, val durationSec: Int, val recorded: Boolean)

/** 本地演示数据，不访问网络。 */
object MockRepository {
    fun customers(): List<Customer> = listOf(
        Customer("示例客户甲", "138****1001", "初步沟通"),
        Customer("示例客户乙", "138****1002", "确认需求"),
        Customer("示例客户丙", "138****1003", "成单"),
    )

    fun callRecords(): List<CallRecord> = listOf(
        CallRecord("示例客户甲", 96, true),
        CallRecord("示例客户乙", 42, true),
        CallRecord("示例客户丙", 0, false),
    )
}
