<script setup lang="ts">
import { devices } from '../mock/data';
const columns = [
  { title: '使用人', dataIndex: 'user' },
  { title: '机型', dataIndex: 'model' },
  { title: '在线', dataIndex: 'online', customRender: ({ text }: { text: boolean }) => (text ? '在线' : '离线') },
  { title: '管控策略', dataIndex: 'policy' },
];
</script>
<template><a-card title="手机管控"><a-table row-key="id" :columns="columns" :data-source="devices" /></a-card></template>
