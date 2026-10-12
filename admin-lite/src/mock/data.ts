// 全部为演示用假数据，不连接任何真实服务。
export const stats = [
  { title: '新增客户', value: 128 },
  { title: '电话接通量', value: 342 },
  { title: '通话时长(分钟)', value: 1260 },
  { title: '微信消息量', value: 2875 },
];

export const customers = Array.from({ length: 12 }, (_, i) => ({
  id: i + 1,
  name: `示例客户${i + 1}`,
  mobile: `138****${String(1000 + i)}`,
  stage: ['初步沟通', '确认需求', '报价', '成单'][i % 4],
  owner: `销售${(i % 3) + 1}`,
}));

export const callRecords = Array.from({ length: 10 }, (_, i) => ({
  id: i + 1,
  customer: `示例客户${i + 1}`,
  direction: i % 2 ? '呼入' : '呼出',
  duration: 30 + i * 17,
  recorded: true,
  time: `2026-01-0${(i % 9) + 1} 10:${String(i * 5).padStart(2, '0')}`,
}));

export const wechatAlerts = [
  { id: 1, staff: '销售1', action: '删除好友', target: '示例客户3', level: '高' },
  { id: 2, staff: '销售2', action: '敏感词：私下转账', target: '示例客户5', level: '高' },
  { id: 3, staff: '销售3', action: '发送手机号', target: '示例客户8', level: '中' },
];

export const devices = Array.from({ length: 6 }, (_, i) => ({
  id: i + 1,
  user: `销售${i + 1}`,
  model: i % 2 ? 'vivo 示例机型' : 'OPPO 示例机型',
  online: i % 3 !== 0,
  policy: '标准销售管控策略',
}));
