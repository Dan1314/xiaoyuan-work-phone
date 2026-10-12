<script setup lang="ts">
import { customers } from '../mock/data';
const columns = [
  { title: '姓名', dataIndex: 'name' },
  { title: '手机号', dataIndex: 'mobile' },
  { title: '沟通进度', dataIndex: 'stage' },
  { title: '跟进人', dataIndex: 'owner' },
];
</script>
<template><a-card title="客户列表"><a-table row-key="id" :columns="columns" :data-source="customers" /></a-card></template>
