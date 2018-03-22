<template>
<div>
  <el-button type="text" @click="getData1()">fff1</el-button>
  <el-button type="text" @click="getData2()">fff2</el-button>
  <li v-for="post of posts" :key="post.title">
    <p><strong>{{post.title}}</strong></p>
    <p>{{post.body}}</p>
  </li>
  <ul v-if="errors && errors.length">
    <li v-for="error of errors" :key="error.title">
      {{error.message}}
    </li>
  </ul>
</div>

</template>

<script>
import axios from "axios"
import AxiosMockAdapter from 'axios-mock-adapter'
var axiosMock = new AxiosMockAdapter(axios, { delayResponse: 10 })


var mockData = [
  {
    id: 1,
    title: 'mock',
    body: '2body2221'
  },
  {
    id: 2,
    title: '2title2',
    body: '2body2222'
  },
  {
    id: 3,
    title: '2title3',
    body: '2body2223'
  },
  {
    id: 4,
    title: '2title4',
    body: '2body2224'
  },
  {
    id: 5,
    title: '2title5',
    body: '2body2225'
  },
  {
    id: 6,
    title: '2title6',
    body: '2body2226'
  }
]

// axiosMock.onGet('/').reply(200, mockData)
axiosMock.onGet('/article/t').reply(200, mockData)
axiosMock.onAny().passThrough()

export default {
  data() {
    return {
      posts: [
        {
          userId: 1,
          id: 1,
          title: "sunt aut facere repcati excepturi optio reprehenderit",
          body:
            "quia et suscipit\nsuscipit rum retem sunt rem eveniet architecto"
        },
        {
          userId: 1,
          id: 2,
          title: "qui est esse",
          body: "est rerum tempodebitis possimus qui neque nisi nulla"
        }
      ],
      errors: []
    };
  },

  methods: {
    getData1() {
      this.$axios.get(`/article/t`).then(res => {
        this.posts = res.data;
      });
    },
    getData2() {
      this.$axios.get(`/article/`).then(res => {
        this.posts = res.data;
      });
    }
  }
};
</script>

<style  scoped>

</style>
