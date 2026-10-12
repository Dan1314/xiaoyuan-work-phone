<script setup lang="ts">
import { callRecords } from '../mock/data';
const columns = [
  { title: '客户', dataIndex: 'customer' },
  { title: '方向', dataIndex: 'direction' },
  { title: '时长(秒)', dataIndex: 'duration' },
  { title: '录音', dataIndex: 'recorded', customRender: ({ text }: { text: boolean }) => (text ? '已上传' : '无') },
  { title: '时间', dataIndex: 'time' },
];
</script>
<template><a-card title="通话录音"><a-table row-key="id" :columns="columns" :data-source="callRecords" /></a-card></template>
