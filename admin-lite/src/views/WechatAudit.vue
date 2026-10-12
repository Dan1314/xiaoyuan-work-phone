<script setup lang="ts">
import { wechatAlerts } from '../mock/data';
const columns = [
  { title: '员工', dataIndex: 'staff' },
  { title: '敏感操作', dataIndex: 'action' },
  { title: '对象', dataIndex: 'target' },
  { title: '风险等级', dataIndex: 'level' },
];
</script>
<template><a-card title="微信敏感操作预警（防飞单 / 防删除）"><a-table row-key="id" :columns="columns" :data-source="wechatAlerts" /></a-card></template>
