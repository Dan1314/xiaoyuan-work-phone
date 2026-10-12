import { createRouter, createWebHashHistory, type RouteRecordRaw } from 'vue-router';
import BasicLayout from '../layouts/BasicLayout.vue';

export const menuRoutes: RouteRecordRaw[] = [
  { path: 'dashboard', component: () => import('../views/Dashboard.vue'), meta: { title: '工作概览' } },
  { path: 'customers', component: () => import('../views/Customers.vue'), meta: { title: '客户管理' } },
  { path: 'call-records', component: () => import('../views/CallRecords.vue'), meta: { title: '通话录音' } },
  { path: 'wechat', component: () => import('../views/WechatAudit.vue'), meta: { title: '微信管控' } },
  { path: 'devices', component: () => import('../views/Devices.vue'), meta: { title: '手机管控' } },
];

export const router = createRouter({
  history: createWebHashHistory(),
  routes: [{ path: '/', component: BasicLayout, redirect: '/dashboard', children: menuRoutes }],
});
