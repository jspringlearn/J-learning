
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 120%;">
  <!--  <el-table-column
      label="ID"
      width="260">
      <template slot-scope="scope">
        &lt;!&ndash;<i class="el-icon-time"></i>&ndash;&gt;
        <span style="margin-left: 10px">{{ scope.row.staff_id }}</span>
      </template>
    </el-table-column>-->

<!--    <el-table-column-->
<!--      label="ID" sortable-->
<!--      width="200">-->
<!--      <template slot-scope="scope">-->
<!--        &lt;!&ndash;<i class="el-icon-time"></i>&ndash;&gt;-->
<!--        <span style="margin-left: 10px">{{ scope.row.staff_id}}</span>-->
<!--      </template>-->
<!--    </el-table-column>-->
    <el-table-column
      label="工号"
      width="200">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.staff_num }}</span>
      </template>
    </el-table-column>

      <el-table-column
        label="姓名"
        width="160">
        <template slot-scope="scope">
          <!--<i class="el-icon-time"></i>-->
          <span style="margin-left: 10px">{{ scope.row.staff_name }}</span>
        </template>
      </el-table-column>
    <el-table-column
      label="性别"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.staff_sex }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="年龄"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.staff_age }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="电话"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.staff_tel }}</span>
      </template>
    </el-table-column>
    <el-table-column  label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>


        <el-dialog title="新添员工信息" :visible.sync="dialogFormVisible">
          <el-form :model="from">
            <el-form-item label="工号" :label-width="formLabelWidth">
              <el-input v-model="form.staff_num" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="姓名" :label-width="formLabelWidth">
                 <el-input v-model="form.staff_name" autocomplete="off"></el-input>
                 </el-form-item>
            <el-form-item label="性别" :label-width="formLabelWidth">
                   <el-input v-model="form.staff_sex" autocomplete="off">
                   </el-input>
            </el-form-item>
            <el-form-item label="年龄" :label-width="formLabelWidth">
              <el-input v-model="form.staff_age" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="电话" :label-width="formLabelWidth">
              <el-input v-model="form.staff_tel" autocomplete="off">
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
          // staff_id: '',
          staff_num: '',
          staff_name:'',
          staff_sex:'',
          staff_age:'',
          staff_tel:'',
        },
        formLabelWidth: '120px',
      }
    },
    methods: {
      // update(index,row) {
      //
      // },
      postForm() {
        const url = this.HOST + '/employee/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        // params.append('staff_id', this.form.staff_id);
        params.append('staff_num', this.form.staff_num);
        params.append('staff_name', this.form.staff_name);
        params.append('staff_sex', this.form.staff_sex);
        params.append('staff_age', this.form.staff_age);
        params.append('staff_tel', this.form.staff_tel);

        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params
        })

          .then(function (response) {

            console.log(response);

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
        var staffId = row.id;
        console.log(staffId);
        this.$axios
          .delete(this.HOST + '/employee/delete/' + staffId)
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
      this.$axios.get(this.HOST+'/employee/all')
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
