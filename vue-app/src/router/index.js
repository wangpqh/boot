import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Home from '@/components/Home'
import index from '@/components/index'
import Order from '@/components/Order'
import First from '@/components/First'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/hello',
          name: 'HelloWorld',
          component: HelloWorld
        },
        {
          path: '/index',
          name: 'index',
          component: index
        },
        {
          path: '/order',
          name: 'Order',
          component: Order
        },
        {
          path: '/first',
          name: 'first',
          component: First
        }]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
