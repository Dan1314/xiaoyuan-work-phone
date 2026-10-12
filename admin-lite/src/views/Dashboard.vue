<script setup lang="ts">
import { stats } from '../mock/data';
</script>
<template>
  <a-row :gutter="16">
    <a-col v-for="s in stats" :key="s.title" :span="6">
      <a-card><a-statistic :title="s.title" :value="s.value" /></a-card>
    </a-col>
  </a-row>
</template>
