import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login'
import Home from '@/components/Home'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [{
      path: '/',
      name: 'Home',
      component: Home,
      redirect: '/hello',
      children: [
        {
        path: '/hello',
        name: 'HelloWorld',
        component: HelloWorld
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: login
    }
  ]
})
