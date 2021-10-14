import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/pages/Index'
import home from '@/components/pages/home'
import account from '@/components/pages/account'
import parts from '@/components/pages/parts'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/account',
      name: 'account',
      component: account
    },
    {
      path: '/catalog/:reference',
      name: 'catalog',
      component: parts,
      props: true
    }
  ]
})
