<template>
  <div id="father">
    <div>
       <p>我是父组件</p>
      <p>智力： {{ analysisData.wisdom }}</p>
      <p>膜法： {{ analysisData.magic }}</p>
      <p>攻击： {{ analysisData.attack }}</p>
      <p>防御： {{ analysisData.defense }}</p>
            <son :analysisData="analysisData" />
    </div>
  </div>
</template>

<script>
import son from './son.vue';
export default {
  data: function() {
    return {
      analysisData: {
        wisdom: 90,
        magic: 160,
        attack: 100,
        defense: 80,
      },
    };
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
  overflow: hidden;
}
</style>
