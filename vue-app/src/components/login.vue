<template>
  <div>
    <mt-header fixed title="">
      <router-link to="/" slot="left">
        <mt-button icon="back"></mt-button>
      </router-link>
      <mt-button slot="right" icon="more"></mt-button>
    </mt-header>
    <h2>请登录</h2>

    username: <input type="text" v-model="loginForm.username" /><br />
    password: <input type="password" v-model="loginForm.password" /><br />
    <button v-on:click="login">log in</button>
    <hr>

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
    <hr>

    <el-form class="form1">
      <el-form-item>
        <el-input type="text" placeholder="用户名/邮箱/手机号码" v-model="loginForm.username">
          <template slot="prepend">用户</template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="text" placeholder="登录密码" v-model="loginForm.password">
          <template slot="prepend">密码</template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <mt-button size="large" type="primary" @click="login()">登录</mt-button>
      </el-form-item>
      <el-form-item>
        <mt-button size="large" plain @click="register()">注册</mt-button>
      </el-form-item>
    </el-form>

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
          } else {
            this.$message({ // element提示框
              showClose: true,
              message: 'login failed',
              type: 'error'
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

  .form1 {
    margin: 0px 10px;
    padding: 10px 35px;
  }
</style>
