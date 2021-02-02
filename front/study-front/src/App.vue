<template>
  <div id="app">
    <!--추가된 헤더 컴포넌트 사용!-->
    <Header />
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <!--추가된 풋터 컴포넌트 사용!-->
    <Footer />
  </div>
</template>

<script>
import Header from './components/common/Header'
import Footer from './components/common/Footer'
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    Header, //헤더 추가
    HelloWorld,
    Footer //풋터 추가
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
