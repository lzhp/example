<template>
  <div>
    <p>我是子组件</p>
    <p>智力： {{ sonData.wisdom }}</p>
    <p>膜法： {{ sonData.magic }}</p>
    <p>攻击： {{ sonData.attack }}</p>
    <p>防御：<input v-model="sonData.defense" placeholder=""></input></p>
    <button @click="increment('wisdom')">增加智力</button>
    <button @click="increment('magic')">增加膜法</button>
    <button @click="increment('attack')">增加攻击</button>
    <button @click="increment('defense')">增加防御</button>
  </div>
</template>

<script>
export default {
  props: {
    analysisData: Object
  },
  data:function(){
    return{
      sonData: this.analysisData
    }
  },

  methods: {
    increment (dataName) {
      this.sonData[dataName] = parseInt(this.sonData[dataName]) + 1
      //this.$emit('update:analysisData', this.sonData)
      this.$emit('update-analysisData', this.sonData)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
   button { float: left }
</style>
