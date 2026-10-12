<script setup lang="ts">
import { computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { menuRoutes } from '../router';

const route = useRoute();
const router = useRouter();
const selected = computed(() => [route.path]);
function onMenu(info: { key: string | number }) {
  router.push(String(info.key));
}
const items = menuRoutes.map((r) => ({ key: `/${r.path}`, label: String(r.meta?.title ?? r.path) }));
</script>

<template>
  <a-layout style="min-height: 100vh">
    <a-layout-sider theme="light" width="208">
      <div style="padding: 16px; font-weight: 600; font-size: 16px">小元工作手机</div>
      <a-menu :selected-keys="selected" :items="items" @click="onMenu" />
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0 24px">{{ route.meta.title }}</a-layout-header>
      <a-layout-content style="margin: 16px"><router-view /></a-layout-content>
    </a-layout>
  </a-layout>
</template>
