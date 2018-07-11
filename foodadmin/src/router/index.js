import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import manage from '@/components/manage'
import userList from '@/page/userList'
import shopList from '@/page/shopList'
import foodList from '@/page/foodList'
import orderList from '@/page/orderList'
import addShop from '@/page/addShop'
import addGoods from '@/page/addGoods'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'manage',
      component: manage,
      children: [{
        path: '/userList',
        name: 'userList',
        component: userList,
        meta: ['用户列表']
      }, {
        path: '/shopList',
        name: 'shopList',
        component: shopList,
        meta: ['商家列表']
      }, {
        path: '/foodList',
        name: 'foodList',
        component: foodList,
        meta: ['食品列表']
      }, {
        path: '/orderList',
        name: 'orderList',
        component: orderList,
        meta: ['订单列表']
      }, {
        path: '/addShop',
        name: 'addShop',
        component: addShop,
        meta: ['添加商家']
      }, {
        path: '/addGoods',
        name: 'addGoods',
        component: addGoods,
        meta: ['添加食品']
      }]
    }
  ]
})
