<template>
  <div>
    <p>来自于父组件：{{propData}}</p>
    <input v-model="sonData" placeholder="propData"/>
       <button @click="raiseEvent">修改</button>
    <p>子组件：{{sonData}}</p>
  </div>
</template>

<script>
export default {
  props: {
    propData: String
  },
  data: function() {
    return {
      sonData: this.propData
    };
  },

  methods: {
    raiseEvent: function() {
      this.$emit("dataChange", this.sonData);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
