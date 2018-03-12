<template src="./form1.html">
</template>
<script>
  export default {
    name:'step1',
    // 组件
    components: {
    },
    data: function () {
      return {
        tagsValid:false,                // 活动标签是否合法
        tagsError:'请设置标签',         // 活动标签不合法的提示信息
        isAddressTrue:false,            // 地址是否正确
        dialogFormVisible: false,       // 添加活动标签的对话框可见？
        dialogFormFenLeiVisible:false,  // 分类对话框可见？
        dialogForm:{name:''},           // 活动标签对话框表单
        dialogFormFenLei:{name:''},     // 活动分类对话框表单
        ruleFormChange:false,           //  ruleForm表单是否改变？
        ruleFormValid:false,            //  ruleForm是否合法？
        rules: {                        // 表单验证规则
          name:[
            {required:true,message:'请输入活动名称',trigger:'change'}
          ],
          fenLei:[
            {required:true,message:'请选择活动分类',trigger:'change'}
          ],
          activeStartTimeDate: [{required:true,message:'请选择活动开始日期',trigger:'change'}],
          activeStartTimeTime: [{required:true,message:'请选择活动开始时间',trigger:'change'}],
          activeEndTimeDate:   [{required:true,message:'请选择活动结束日期',trigger:'change'}],
          activeEndTimeTime:   [{required:true,message:'请选择活动结束时间',trigger:'change'}],
          signStartTimeDate:   [{required:true,message:'请选择报名开始日期',trigger:'change'}],
          signStartTimeTime:   [{required:true,message:'请选择报名开始时间',trigger:'change'}],
          signEndTimeDate:     [{required:true,message:'请选择报名截止日期',trigger:'change'}],
          signEndTimeTime:     [{required:true,message:'请选择报名截止时间',trigger:'change'}],
        },
        ruleForm: {         // step1页面的表单，记录页面所有表单信息
          name: '',         // 活动名称
          fenLeis:[         // 活动分类选项
            {name: '未发布'},
            {name: '测试活动'},
            {name: '精彩活动'}
          ],
          fenLei: '',       // 当前选中的活动分类
          tags: [],         // 活动标签
          activeStartTimeDate: '',  // 活动开始时间
          activeStartTimeTime: '',  // 活动结束时间
          activeEndTimeDate: '',
          activeEndTimeTime: '',
          signStartTimeDate: '',
          signStartTimeTime: '',
          signEndTimeDate: '',
          signEndTimeTime: '',
          activePerson:'',             // 是否限制活动人数?
          activePersonNum:'',          // 限制多少人?
          activeDescribe:'',           // 活动简介
          UseMsgShow:'',               // 报名活动信息展示
          evaluate:'',                 // 评价功能
          adTitle:'',                  // 广告标题
          adContent:'',                // 广告内容
          adLink:'',                   // 赞助链接
        }
      };
    },
    watch: {    // 监控
      ruleForm: {
        handler: function (val,oldVal) {
          store.commit('setRuleForm',this.ruleForm);
          this.tagsValid = !this.ruleForm.tags.length ? '' :false ;
          this.ruleFormChange = true ;
        },
        deep: true // 深度监控，可以观察到ruleForm内任意属性的变化
      }
    },
    methods: {

      handleRemove: function (file, fileList) {
        console.log(file, fileList);
      },
      handlePreview: function (file) {
        console.log(file);
      },
      handleSuccess: function () {
      },
      handleError: function () {
      },
      // 显示添加活动标签对话框
      showDialog: function () {
        if(this.ruleForm.tags.length >=5 ){
          this.$message({
            message: '最多设置5个标签',
            type: 'warning'
          });
        }else{
          this.dialogFormVisible = true;
          this.dialogForm = {};
        }
      },
      // 删除活动标签
      handleClose: function (tag) {
        var index = this.ruleForm.tags.indexOf(tag);
        this.ruleForm.tags.splice(index,1);
      },
      // 删除活动分类的某一项
      handleCloseFenLei: function (fenLei){
        var index = this.ruleForm.fenLeis.indexOf(fenLei);
        this.ruleForm.fenLeis.splice(index,1);
      },
      // 添加标签
      handleAdd: function (tag,form,tags) {
        if(tag && tag.trim().length !== 0){
          var isExist = false ;
          tag = tag.trim();
          for(var i=0;i<tags.length; i++){
            if(tags[i].name == tag ){
              isExist = true;
              break
            }
          }
          if(isExist){
            this.$message({
              message: '该标签已存在',
              type: 'warning'
            });
          }else{
            this.dialogFormVisible = false;
            this.dialogFormFenLeiVisible = false;
            tags.push({
              name: tag
            });
          }
        }else{
          this.$message({
            message: '标签不能为空',
            type: 'warning'
          });
        }
      },
      openAd: function (){
        this.$message('该功能正在完善');
      },

    },
    // 页面初始化
    created: function(){

    }
  }
</script>
<style>
    .step{margin-bottom: 30px;}
    .step1 .demo-ruleForm .el-form-item{margin-bottom: 25px;margin-right: 50px;}

    .step1 .el-form-item.is-required .el-form-item__label:after {
      content: '*';
      color: #ff4949;
      margin-right: 4px;
    }
    .step1 .el-form-item.is-required .el-form-item__label:before { display: none; }
    /* 标签 */
    .step1   .el-tag{padding: 10px 15px;margin:10px;vertical-align: middle;}
    .step1   .el-tag:first-child{margin-left: 0;}

    /* 对话框 */
    .step1 .el-dialog--small{width: 564px;}
    .step1 .el-dialog__body{padding-bottom: 0;}
    .step1 .el-dialog__body .el-form-item{margin-bottom: 10px;}
    .step1 .el-dialog__wrapper  .el-button{margin-left: 15px;}


   /* 时间选择器 */
    .step1 .el-date-editor{width:150px;}

    .step1 .el-form-item .router-link{color:#fff;}
    .el-form-item__error{white-space: nowrap;}
</style>
