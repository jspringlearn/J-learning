import Vue from 'vue'
import Router from 'vue-router'

import management from '@/components/table/management'
import site from '@/components/table/site'
import goods from '@/components/table/goods'
import comment from '@/components/table/comment'
import employee from '@/components/table/employee'
import road from '@/components/table/road'
import order from '@/components/table/order'
import table7 from '@/components/table/table7'

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
      path:'/components/table/comment',
      name:'comment',
      component:comment
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
    {
      path:'/components/table/table7',
      name:'table7',
      component:table7
    },
  ]
})
