<template>
  <div>
    <el-card>
      <div class="city">
        <span v-model="tiket.startCity" style="float: left;">南京</span>
        <img src="../assets/change.png" width="20" height="20" />
        <span v-model="tiket.endCity" style="float: right;">南通</span>
      </div><br>
      <div class="date">11月27日 周六</div><br>
      <div class="other">
        <span>只看高铁/动车</span>
        <el-checkbox v-model="tiket.highway"></el-checkbox>
        <span>学生票</span>
        <el-checkbox v-model="tiket.student"></el-checkbox>

      </div><br>
      <div class="but">
        <mt-button size="large" type="primary">查询车票</mt-button>
      </div>

    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'index',
    data() {
      return {
        tiket: {
          startCity: '',
          endCity: '',
          highway: '',
          student: ''
        }
      }
    }
  }
</script>

<style>
  .city {
    font-size: 25px;
    margin: 10px 10px;
  }

  .date {
    font-size: 18px;
    float: left;
    margin: 10px 10px;
  }

  .other {
    font-size: 10px;
    float: left;
    margin: 25px 10px;
    position: fixed;
  }

  .but {
    margin: 30px 10px 0 10px;
  }
</style>
