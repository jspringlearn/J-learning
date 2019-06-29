
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 120%">
    <el-table-column
      label="车牌号码"
      width="150">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.car_number }}</span>
      </template>
    </el-table-column>


    <el-table-column
      label="载重量"
      width="260">
      <template slot-scope="scope">
        <span style="margin-left: 20px">{{ scope.row.car_volume }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="车主"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.car_owner }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="运输状态"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.car_status }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="车主电话"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.car_owner_tel }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="运输路线"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.car_road }}</span>
      </template>
    </el-table-column>
    <el-table-column  label="操作">
      <template slot-scope="scope">



        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>
        <el-dialog title="新添车辆信息" :visible.sync="dialogFormVisible">
          <el-form :model="form">
            <el-form-item label="车牌号" :label-width="formLabelWidth">
              <el-input v-model="form.car_number" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="载重量" :label-width="formLabelWidth">
              <el-input v-model="form.car_volume" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="车主" :label-width="formLabelWidth">
              <el-input v-model="form.car_owner" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="运输状态" :label-width="formLabelWidth">
              <el-input v-model="form.car_status" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="车主电话" :label-width="formLabelWidth">
              <el-input v-model="form.car_owner_tel" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="行驶路线" :label-width="formLabelWidth">
              <el-input v-model="form.car_road" autocomplete="off"></el-input>
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
          car_number: '',
          car_volume: '',
          car_owner:'',
          car_status: '',
          car_owner_tel: '',
          car_road: '',
          // store:'',
        },
        formLabelWidth: '120px',
      }
    },
    methods: {
      // update(index,row) {
      //   this.$prompt('更改后的重量', '修改', {
      //     confirmButtonText: '确定',
      //     cancelButtonText: '取消',
      //   }).then(({value}) => {
      //     this.$message({
      //       type: 'success',
      //       message: '已保存: '
      //     });
      //     console.log(row.id, value);
      //
      //
      //     this.$axios({
      //       method: "put",
      //       url: this.HOST + '/goods/update?id=' + row.id + "&number=" + value,     //这里的传参---mvc问题，待解决
      //       data:{
      //
      //       },
      //     })
      //       .then(function (response) {
      //
      //         console.log(response);
      //
      //       })
      //
      //       .catch(function (error) {
      //
      //         console.log(error);
      //
      //       });
      //
      //
      //   }).catch(() => {
      //     this.$message({
      //       type: 'info',
      //       message: '取消输入'
      //     });
      //   });
      // },
      postForm() {
        const url = this.HOST + '/car/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('car_number', this.form.car_number);
        params.append('car_volume', this.form.car_volume);
        params.append('car_owner', this.form.car_owner);
        params.append('car_status', this.form.car_status);
        params.append('car_owner_tel', this.form.car_owner_tel);
        params.append('car_road', this.form.car_road);

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
        var carNumber = row.id;
        console.log(carNumber);
        this.$axios
          .delete(this.HOST + '/car/delete/' + carNumber)
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
      this.$axios.get(this.HOST+'/car/all')
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



