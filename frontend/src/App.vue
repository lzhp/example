<template>
  <div id="app">
    <p>
      <router-link to="/">hello</router-link>
      <router-link to="/bar">Go to Bar</router-link>
      <router-link to="/first">first</router-link>
      <router-link to="/1">father1</router-link>
      <router-link to="/2">father2</router-link>
      <router-link to="/redCheck">redCheck</router-link>
      <router-link to="/redreCheck">redreCheck</router-link>
      <router-link to="/example1">example1</router-link>
      <router-link to="/request">request</router-link>
      <router-link to="/mock">mock</router-link>
      <router-link to="/mocknew">mocknew</router-link>
    </p>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
