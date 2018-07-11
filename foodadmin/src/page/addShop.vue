<template>
  <div>
    <!--<head-top></head-top>-->
    <el-row style="margin-top: 20px;">
      <el-col :span="12" :offset="4">
        <el-form :label-position="formpositon" :model="formData" :rules="rules" ref="formData" label-width="110px"
                 class="demo-formData">
          <el-form-item label="航空公司" prop="companyName">
            <el-input v-model="formData.companyName"></el-input>
          </el-form-item>
          <el-form-item label="出发地" prop="leaveCity">
            <el-autocomplete
              v-model="formData.leaveCity"
              placeholder="请输入地址"
              style="width: 100%;">
              <!--@select="addressSelect"-->
            </el-autocomplete>
            <!--<span>当前城市：{{city.name}}</span>-->
          </el-form-item>
          <el-form-item label="目的地" prop="arriveCity">
            <el-autocomplete
              v-model="formData.arriveCity"
              placeholder="请输入地址"
              style="width: 100%;">
            </el-autocomplete>
            <!--<span>当前城市：{{city.name}}</span>-->
          </el-form-item>
          <el-form-item label="出发机场" prop="leaveAirport">
            <el-input v-model="formData.leaveAirport" maxLength="11"></el-input>
          </el-form-item>
          <el-form-item label="目的机场" prop="arriveAirport">
            <el-input v-model="formData.arriveAirport"></el-input>
          </el-form-item>
          <el-form-item label="始末时间" style="white-space: nowrap;">
            <el-date-picker
              placeholder="出发时间"
              v-model="formData.leaveTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss">
            </el-date-picker>
            <el-date-picker
              placeholder="到达时间"
              v-model="formData.arriveTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="总机票数" prop="capacity">
            <el-input-number
              v-model="formData.capacity"
              :min="0">
            </el-input-number>
          </el-form-item>
          <el-form-item label="价格" prop="price">
            <el-input-number v-model="formData.price" :min="0" :precision="2" :step="0.1"></el-input-number>
          </el-form-item>
          <el-form-item class="button_submit">
            <el-button type="primary" @click="submitForm('formData')">立即创建</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import axios from 'axios';
  import Qs from 'qs';

  export default {
    name: "addTicket",
    data() {
      return {
        city: {},
        formpositon: 'right',
        formData: {
          companyName: '', //航空公司名称
          leaveCity: '',
          arriveCity: '',
          leaveAirport: '',
          arriveAirport: '',
          leaveTime: '',
          arriveTime: '',
          capacity: '',
          price: '',
          bookSum: 0
        },
        rules: {
          name: [
            {required: true, message: '请输入店铺名称', trigger: 'blur'},
          ],
          address: [
            {required: true, message: '请输入详细地址', trigger: 'blur'}
          ],
          phone: [
            {required: true, message: '请输入联系电话'},
            {type: 'number', message: '电话号码必须是数字'}
          ],
        },
        options: [{
          value: '满减优惠',
          label: '满减优惠'
        }, {
          value: '优惠大酬宾',
          label: '优惠大酬宾'
        }, {
          value: '新用户立减',
          label: '新用户立减'
        }, {
          value: '进店领券',
          label: '进店领券'
        }],
        activityValue: '满减优惠',
        activities: [{
          icon_name: '减',
          name: '满减优惠',
          description: '满30减5，满60减8',
        }],
        categoryOptions: [],
        selectedCategory: ['快餐便当', '简餐']
      }
    },
    methods: {
      submitForm(formName) {
        let formdate = Qs.stringify(this[formName])

        let tempUrl = 'http://localhost:8001'
        axios.post(tempUrl + '/ticket/addticket/', formdate).then((response) => {

        }).catch((error) => {
          console.log(error)
        })
      }
    },
    components: {
      // headTop,
    },
    mounted() {
      // this.initData();
    }

  }
</script>

<style scoped>

</style>
