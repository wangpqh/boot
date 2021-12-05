<template>
  <div>
    <el-card>
      <div class="city">
        <input v-model="tiket.startCity" style="float: left;"></input>
        <img src="../assets/change.png" width="20" height="20" />
        <input v-model="tiket.endCity" style="float: right;"></input>
      </div><br>
      <div class="date"><input v-model="tiket.date"></input></div><br>
      <div class="other">
        <span>只看高铁/动车</span>
        <el-checkbox v-model="tiket.highway"></el-checkbox>
        <span>学生票</span>
        <el-checkbox v-model="tiket.student"></el-checkbox>
      </div><br>
      <div class="but">
        <mt-button size="large" type="primary" @click="query()">查询车票</mt-button>
      </div>
    </el-card>
    <first>
      <template v-slot:show>组件给插槽给first</template>
    </first>
  </div>
</template>

<script>
  import first from '@/components/first'
  export default {
    name: 'index',
    components: {
      first
    },
    data() {
      return {
        tiket: {
          startCity: '南京',
          endCity: '南通',
          date: '11月27日 周六',
          highway: false,
          student: false
        }
      }
    },
    methods: {
      query() {
        this.$axios.post(
          '/train/query', {
            start: this.tiket.startCity,
            end: this.tiket.endCity,
            date: this.tiket.date,
            highSpeed: this.tiket.highway,
            student: this.tiket.student
          }).then(successRsp => {
          if (successRsp.data.resultCode === '200') {
            this.$router.push({
              name: 'Order',
              params: successRsp.data
            })
          }
        })

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
