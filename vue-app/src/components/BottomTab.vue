<template>
  <div>
    <mt-tabbar v-model="selected">
      <mt-tab-item v-for="(item,index) in tabArr" :key="index" :id="item.id">{{item.value}}</mt-tab-item>
    </mt-tabbar>
  </div>

</template>

<script>
  export default {
    name: 'BotTab',
    data() {
      return {
        selected: 'index',
        tabArr: [{
          id: "index",
          value: "首页"
        }, {
          id: "service",
          value: "服务"
        }, {
          id: "first",
          value: "第一"
        }, {
          id: "my",
          value: "我的"
        }]
      }
    },
    watch: {
      'selected': {
        handler() {
          switch (this.selected) {
            case 'index':
              this.$router.push('/index');
              break;
            case 'service':
              this.$router.push('/hello');
              break;
            case 'first':
              this.$router.push('/first');
              break;
            case 'my':
              this.$router.push('/login');
              break;
          }
        }
      }
    }
  }
</script>

<style>
</style>
