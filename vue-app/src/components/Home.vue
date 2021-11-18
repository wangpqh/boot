<template>
  <div>
    <nav-menu></nav-menu>
    <router-view></router-view>
  </div>
</template>

<script>
  import NavMenu from './navMenu.vue'
  export default {
    name: 'Home',
    components: {NavMenu}
  }
</script>

<style>
</style>
