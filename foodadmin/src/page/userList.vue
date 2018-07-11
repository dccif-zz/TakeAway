<template>
  <div class="fillcontain">
    <template>
      <el-button type="primary"
                 @click="handleEdit({type:'addUser'})" style="margin: 10px">添加用户
      </el-button>
    </template>
    <div class="table_container">
      <el-table
        :data="userData"
        highlight-current-row
        style="width: 100%">
        <el-table-column
          label="id"
          property="id">
        </el-table-column>
        <el-table-column
          property="username"
          label="用户名">
        </el-table-column>
        <el-table-column
          property="nickname"
          label="昵称">
        </el-table-column>
        <el-table-column
          property="gender"
          label="性别">
        </el-table-column>
        <el-table-column
          property="mobile"
          label="手机">
        </el-table-column>
        <el-table-column
          property="email"
          label="邮箱">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button v-if="editable" type="success"
                       @click="handleEdit(scope.$index,scope.row)" size="mini" icon="el-icon-edit"
                       circle></el-button>
            <el-button v-if="editable" type="danger"
                       @click="handleDelete(scope.$index,scope.row)" size="mini" icon="el-icon-delete"
                       circle></el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-dialog title="修改用户信息" :visible.sync="dialogFormVisible">
        <el-form :model="selectRow" ref="selectFrom">
          <el-form-item label="用户名" prop="username"
                        :rules="[{required:true}]">
            <el-input v-model="selectRow.username"></el-input>
          </el-form-item>
          <el-form-item label="昵称" prop="nickname"
                        :rules="[{required:true}]">
            <el-input v-model="selectRow.nickname"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="gender"
                        :rules="[{required:true}]">
            <el-radio-group v-model="selectRow.gender">
              <el-radio label="MALE">男</el-radio>
              <el-radio label="FEMALE">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="手机号" prop="mobile">
            <el-input v-model="selectRow.mobile" maxLength="16"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email"
                        :rules="[{required:true,message:'请输入邮箱',trigger:'blur'},
                        {type:'email',message:'请输入正确邮箱',trigger:['blur','change']}]">
            <el-input v-model="selectRow.email"></el-input>
          </el-form-item>
          <!--<el-form-item label="地址" prop="address">-->
          <!--<el-input v-model="selectRow.address"></el-input>-->
          <!--<el-button @click="addAddress">新增地址</el-button>-->
          <!--</el-form-item>-->
          <el-form-item
            v-for="(address,index) in selectRow.address "
            :label="'地址'+index"
            :key="address.key"
            :prop="'address['+index+'].detail'">
            <el-input v-model="address.detail"></el-input>
            <el-button @click.prevent="removeAddress(address)">删除</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updateTicket('selectRow')">提交</el-button>
            <el-button @click="dialogFormVisible = !dialogFormVisible">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import { getAllUser, deleteUserById, uploadUser } from '../tools/myUtil'

  export default {
    data () {
      return {
        userData: [],
        editable: true,
        dialogFormVisible: false,
        selectRow: {
          username: '',
          nickname: '',
          gender: '',
          mobile: '',
          address: [{
            detail: ''
          }]
        },
        currentRow: null,
        offset: 0,
        limit: 20,
        count: 0,
        currentPage: 1
      }
    },
    created () {
      this.initData()
    },
    methods: {
      async initData () {
        try {
          this.getUsers()
        } catch (err) {
          console.log('获取数据失败', err)
        }
      },
      // 修改 条件 二合一 方法
      handleEdit (index, row) {
        this.dialogFormVisible = !this.dialogFormVisible
        // 判断是否为添加用户
        if (index['type'] === 'addUser') {
          this.selectRow = {}
          this.$refs['selectFrom'].resetFields()
        }
        if (row !== undefined) {
          this.selectRow = row
        }
      },
      addAddress () {
        this.selectRow.address.push({
          detail: '',
        })
      },
      removeAddress () {

      },
      updateTicket (formData) {
        console.log('update data: ', this[formData])
        uploadUser(this[formData]).then(() => {
          this.$message({
            message: '提交成功',
            type: 'success'
          })
        }).catch((err) => {
          this.$message({
            message: '删除失败',
            type: 'error'
          })
          console.log(err)
        })
      },
      async handleDelete (index, row) {
        console.log('index,row: ', index, row)
        let respState = await
          deleteUserById(row['id'])
        if (respState) {
          this.userData.splice(index, 1)
          this.$message({
            message: '删除成功',
            type: 'success'
          })
        }
        else {
          this.$message({
            message: '删除失败',
            type: 'error'
          })
        }
      }
      ,
      async getUsers () {
        // const Users = await getUserList({offset: this.offset, limit: this.limit})
        let requesetData = await
          getAllUser('/findAllUser')
        this.userData = requesetData.pop()
      }
    }
  }
</script>

<style lang="less">
  @import '../style/mixin';

  .table_container {
    padding: 20px;
  }
</style>
