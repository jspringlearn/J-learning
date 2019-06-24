
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
        <span style="margin-left: 10px">{{ scope.row.managementID }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="姓名"
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.mname }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="电话"
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 20px">{{ scope.row.mphone }}</span>
      </template>
    </el-table-column>

    <!--<el-table-column
      label="  "
      width="160">
      <template slot-scope="scope">
        &lt;!&ndash;<i class="el-icon-time"></i>&ndash;&gt;
        <span style="margin-left: 10px">{{ scope.row.managementUserGroup }}</span>
      </template>
    </el-table-column>-->
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
           <!-- <el-form-item label="家庭住址" :label-width="formLabelWidth">
              <el-input v-model="Form.managementUserGroup" autocomplete="off">
              </el-input>
            </el-form-item>-->
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
          @click="update(scope.$index, scope.row)">修改</el-button>


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
        form: {
          managementID:'',
          mname: '',
          mphone: '',
        /*  managementUserGroup:'',*/
        },
        formLabelWidth: '100px',
      }
    },
    methods: {
      update(index,row) {

      },
      postForm() {
        const url = this.HOST + '/managementUser/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('managementID', this.form.managementID);
        params.append('mname', this.form.mname);
        params.append('mphone', this.form.mphone);
       /* params.append('managementUserGroup', this.form.managementUserGroup);*/
        alert(params.managementID);
        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params
        })
          .then(function (response) {
            console.log(response);
            alert(params.mname);
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      handleEdit(index, row) {
        console.log(index, row);

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
      this.$axios.get(this.HOST+'/managementUser/all')
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
