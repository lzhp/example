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
import "./mock/index.js";

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
      this.$axios.get(`/article/t1`).then(res => {
        this.posts = res.data;
      });
    },
    getData2() {
      this.$axios.get(`/article/t2`).then(res => {
        this.posts = res.data;
      });
    }
  }
};
</script>

<style  scoped>

</style>
