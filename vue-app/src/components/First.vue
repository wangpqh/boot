<template>
  <div>
    <p>{{msg}}</p>
    <span v-show="hide">{{msg2}}</span><br/>
    <slot name='show'>original slot</slot>
  </div>
</template>

<script>
  export default {
    name: 'first',
    data() { //指定页面默认值
      return {
        msg: 'this is default first vue slot',
        msg2: 'first msg2 default',
        hide: true
      }
    }
  }
</script>

<style>
</style>
