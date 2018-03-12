<template>
  <div id="father">
    <div>
      <!-- <p>{{ '我是父组件:' + fatherText }}</p> -->
      <p>父组件：{{fatherText}}</p>
      <input v-model="fatherText" />
      <son :propData="fatherText" v-on:dataChange = "changeMe"></son>
    </div>
  </div>
</template>

<script>
import son from './son.vue';
export default {
  data: function() {
    return {
      fatherText: '组件通讯测试',
    };
  },

  methods: {
    changeMe: function(textData) {
      this.fatherText = textData;
    },
  },

  components: {
    son: son,
  },
};
</script>

<style scoped>
#father div {
  padding: 10px;
  margin: 10px;
  border: 1px solid grey;
}
</style>
