
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 120%">
    <el-table-column
      label="订单号"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.orderID}}</span>
      </template>
    </el-table-column>


    <el-table-column
      label="订单名称"
      width="160">
      <template slot-scope="scope">
        <span style="margin-left: 20px">{{ scope.row.orderName }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="下单时间"
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.orderTime }}</span>
      </template>
    </el-table-column>


    <el-table-column
      label="订单价格"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.orderPrice }}</span>
      </template>
    </el-table-column>
    <el-table-column  label="操作">
      <template slot-scope="scope">

        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="新添订单信息" :visible.sync="dialogFormVisible">
          <el-form :model="from">
            <el-form-item label="订单号" :label-width="formLabelWidth">
              <el-input v-model="form.orderID" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="订单名称" :label-width="formLabelWidth">
              <el-input v-model="form.orderName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="下单时间" :label-width="formLabelWidth">
              <el-input v-model="form.orderTime" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="订单价格" :label-width="formLabelWidth">
              <el-input v-model="form.orderPrice" autocomplete="off">
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
          name: '',
          number: '',
          weight:'',
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
        const url = this.HOST + '/order/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('orderID', this.form.orderID);
        params.append('orderName', this.form.orderName);
        params.append('orderTime', this.form.orderTime);
        params.append('orderPrice', this.form.orderPrice);

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
        var orderid = row.id;
        console.log(orderid);
        this.$axios
          .delete(this.HOST + '/order/delete/' + orderid)
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



