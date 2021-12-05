<template>
  <div>
    <img src="../assets/logo.png">
    <span>{{ msg }}</span>
  </div>

</template>

<script>
  export default {
    name: 'Order',
    data() {
      return {
        msg: this.$router.params
      }
    }
  }
</script>

<style>
</style>
