<template>
  <div>
    <el-menu :default-active="activeFlag" class="el-menu-demo" router="" mode="horizontal">
      <el-menu-item index="/">首页</el-menu-item>
      <el-submenu index="2">
        <template slot="title">请假</template>
        <el-menu-item v-for="(item,i) in arr" :key="i" :index="item.id">{{item.option}}</el-menu-item>
      </el-submenu>
      <el-menu-item index="3" id="center">管理中心</el-menu-item>
      <!--     <el-submenu index="2-4">
        <template slot="title">选项4</template>
        <el-menu-item index="2-4-1">选项1</el-menu-item>
        <el-menu-item index="2-4-2">选项2</el-menu-item>
        <el-menu-item index="2-4-3">选项3</el-menu-item>
      </el-submenu> -->

      <el-menu-item>
        <el-input type='text'></el-input>
      </el-menu-item>
      <el-menu-item style="float: right;">
        <span>姓名</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: 'NavMenu',
    data() {
      return {
        activeFlag: '1',
        arr: [{
          id: 1,
          option: '迟到'
        }, {
          id: 2,
          option: '事假'
        }, {
          id: 3,
          option: '调休'
        }, ]
      }
    },
    methods: {
      show() {

      }
    }
  }
</script>

<style>
  #center {
    margin: 0 20% 0 30%;
    text-align: center;
    font-size: 20px;
  }
</style>
