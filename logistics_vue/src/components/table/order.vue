
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 120%">
    <el-table-column
      label="ID"sortable
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.orderId }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="姓名"
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.orderName }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="电话"
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 20px">{{ scope.row.orderTime }}</span>
      </template>
    </el-table-column>

    <el-table-column  label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="新添管理员" :visible.sync="dialogFormVisible">
          <el-form :model="from">
            <el-form-item label="ID" :label-width="formLabelWidth">
              <el-input v-model="form.managementID" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="姓名" :label-width="formLabelWidth">
              <el-input v-model="form.mname" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="电话" :label-width="formLabelWidth">
              <el-input v-model="form.mphone" autocomplete="off">
              </el-input>
            </el-form-item>

          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="postForm">确 定</el-button>
          </div>
        </el-dialog>

        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>


        <el-button
          type="success"
          size="mini"
          @click="handleEdit(scope.$index, scope.row )  ">编辑</el-button>
        <el-dialog title="编辑" :visible.sync="editFormVisible" :close-on-click-modal="false">
          <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
            <el-form-item label="管理员姓名" prop="name">
              <el-input v-model="editForm.mname" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="管理员电话">
              <el-input  v-model="editForm.mphone"  auto-complete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click.native="editFormVisible = false">取消</el-button>
            <el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>
          </div>
        </el-dialog>
      </template>
    </el-table-column>

  </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        dialogTableVisible: false,
        dialogFormVisible: false,
        editFormVisible:false,
        form: {
          orderId:'',
          orderName: '',
          orderTime: '',
          /*  managementUserGroup:'',*/
        },
        formLabelWidth: '100px',
        editForm: {
          name: '',
          mphone:''
        },
      }
    },
    methods: {
      update(index,row) {
      },

      postForm() {
        const url = this.HOST + '/managementUser/save';
        this.dialogFormVisible = false;

        /*alert(this.form.mname);*/
        var params = new URLSearchParams();
        params.append('managementID', this.form.managementID);
        params.append('mname', this.form.mname);
        params.append('mphone', this.form.mphone);
        /* params.append('managementUserGroup', this.form.managementUserGroup);*/
        /* alert(this.params.mname);*/
        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params,
        })
          .then(function (response) {
            console.log(response);
            /* alert(params.mname);*/
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      editSubmit(){
        const url = this.HOST + '/managementUser/save';
        this.dialogFormVisible = false;

        /*alert(this.form.mname);*/
        var params = new URLSearchParams();
        params.set('mname', this.editForm.mname);
        params.set('mphone', this.editForm.mphone);
        /* params.append('managementUserGroup', this.form.managementUserGroup);*/
        /* alert(this.params.mname);*/
        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params,
        })
          .then(function (response) {
            console.log(response);
            /* alert(params.mname);*/
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      handleEdit: function (index, row) {
        this.editFormVisible = true;
        this.editForm = Object.assign({}, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
        var expenditureId = row.id;
        console.log(expenditureId);
        this.$axios
          .delete(this.HOST + '/managementUser/deleteById/' +expenditureId)
          .then(res => {
            console.log(res);
            this.tableData.splice(index, 1)
          })
          .catch(err => {
            console.log(err);
          });
      },

      //时间戳转化
      getLocalTime(nS) {
        return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/, ' ');
      }
    },
    created() {
      this.$axios.get(this.HOST+'/order/all')
        .then(response=>{

          console.log(response);

          this.tableData=response.data;

        })
        .catch(error=>{

          console.log(error);

          alert('网络错误，不能访问');

        })

    }
  }
</script>
