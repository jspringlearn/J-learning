import Vue from 'vue'
import Router from 'vue-router'

import management from '@/components/table/management'
import site from '@/components/table/site'
import goods from '@/components/table/goods'
import feedback from '@/components/table/feedback'
import employee from '@/components/table/employee'
import road from '@/components/table/road'
import order from '@/components/table/order'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path:'/components/table/management',
      name:'management',
      component:management
    },
    {
      path:'/components/table/site',
      name:'site',
      component:site
    },
    {
      path:'/components/table/goods',
      name:'goods',
      component:goods
    },
    {
      path:'/components/table/feedback',
      name:'feedback',
      component:feedback
    },
    {
      path:'/components/table/employee',
      name:'employee',
      component:employee
    },
    {
      path:'/components/table/road',
      name:'road',
      component:road
    },
    {
      path:'/components/table/order',
      name:'order',
      component:order
    },
  ]
})
