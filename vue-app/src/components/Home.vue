<template>
  <div>
    <!-- <nav-menu></nav-menu> -->
    <router-view></router-view>
    <bot-tab></bot-tab>
  </div>
</template>

<script>
  import NavMenu from './navMenu.vue'
  import BotTab from './BottomTab.vue'
  export default {
    name: 'Home',
    components: {NavMenu,BotTab}
  }
</script>

<style>
</style>
