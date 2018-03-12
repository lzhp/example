<template>
  <div class="rating">
    <ul class="list">
      <li @click="rate(star)" v-for="star in maxStars" v-bind:class="{'active':star<=stars }" class="star" v-bind:key="star">
        <icon :name = "star<=stars? 'star':'star-o'" />
      </li>
    </ul>
    <span>{{stars}} of {{maxStars}}</span>
  </div>

</template>




<script>
import "vue-awesome/icons/star";
import "vue-awesome/icons/star-o";

import Icon from "vue-awesome/components/Icon";

export default {
  props: ["grade", "maxStars", "hasCounter"],
  components: { Icon },
  data() {
    return {
      stars: this.grade,
      maxStars: this.maxStars
    };
  },
  methods: {
    rate(star) {
      if (typeof star === "number" && star <= this.maxStars && star >= 0) {
        this.stars = this.stars === star ? star - 1 : star;
      }
    }
  }
};
</script>




<style scoped>
.rating {
  font-family: "avenir", Arial, Helvetica, sans-serif;
  font-size: 14px;
  color: #a7a8a8;
}

.list {
  margin: 0 0 5px 0;
  padding: 0;
  list-style-type: none;
}

.list:hover .star {
  color: #f3d23e;
}

.star {
  display: inline-block;
  cursor: pointer;
}

.active {
  color: #f3d23e;
}
</style>


