<template>

  <div>
    <h2>请登录</h2>
    <el-form class="form">
      <el-form-item label="username: ">
        <el-input type="text" v-model="loginForm.username"></el-input>
      </el-form-item>
      <el-form-item label="password: ">
        <el-input type="password" v-model="loginForm.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button plain @click="login()">login</el-button>
      </el-form-item>
    </el-form>
    <!--    <div>
      username: <input type="text" v-model="loginForm.username" /><br />
      password: <input type="password" v-model="loginForm.password" /><br />
      <button v-on:click="login">log in</button>
    </div> -->
  </div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
        loginForm: {
          username: '',
          password: ''
        }
      }
    },
    methods: {
      login() {
        this.$axios.post(
          '/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          }
        ).then(successRsp => {
          if (successRsp.data.resultCode == "200") {
            this.$router.replace({
              path: '/hello'
            })
          }else{
            this.$message({
               showClose: true,
               message:'login failed',
               type:'error'
            });
          }
        }).catch(failRsp => {

        })
      }
    }
  }
</script>

<style>
  .form {
    border-radius: 30px;
    border: 1px solid #eaeaea;
    label-width: 400px;
    margin: 0px 40px;
    padding: 10px 50px;
  }
</style>
