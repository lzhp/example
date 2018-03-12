import Vue from 'vue'
import Router from 'vue-router'

// import HelloWorld from '@/components/HelloWorld'
import Father1 from '@/views/comm/father.vue'
import Father2 from '@/views/comm2/father.vue'
import redCheck from '@/views/red/check.vue'
import redreCheck from '@/views/red/recheck.vue'
import example1 from '@/views/example/form1.vue'
import testRequest from '@/views/test-request.vue'
import mockNew from '@/views/testmock/test-mock.vue'
import testMock from '@/views/test-mock.vue'

const Home = { template: '<div>home</div>' }
const Foo = { template: '<div>foo</div>' }
const Bar = { template: '<div>bar</div>' }
const First = { template: '<div><h2>我是第 1 个子页面</h2></div>' }
const My404 = { template: '<div>404</div>' }

const routes = [
  { path: '/', component: Home },
  { path: '/first', component: First },
  { path: '/1', component: Father1 },
  { path: '/2', component: Father2 },
  { path: '/foo', component: Foo },
  { path: '/bar', component: Bar },
  { path: '/redCheck', component: redCheck },
  { path: '/redreCheck', component: redreCheck },
  { path: '/example1', component: example1 },
  { path: '/request', component: testRequest },
  { path: '/mock', component: testMock },
  { path: '/mocknew', component: mockNew },
  { path: '*', component: My404 }
]

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes
})
