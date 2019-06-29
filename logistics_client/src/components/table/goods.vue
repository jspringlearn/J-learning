
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 120%">
    <el-table-column
      label="名字"
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.name }}</span>
      </template>
    </el-table-column>


    <el-table-column
      label="数量"
      width="260">
      <template slot-scope="scope">
        <span style="margin-left: 20px">{{ scope.row.number }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="重量"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.weight }}</span>
      </template>
    </el-table-column>


    <el-table-column
      label="仓库"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.store }}</span>
      </template>
    </el-table-column>
    <el-table-column  label="操作">
      <template slot-scope="scope">

        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="新添货物信息" :visible.sync="dialogFormVisible">
          <el-form :model="from">
            <el-form-item label="名字" :label-width="formLabelWidth">
              <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="数量" :label-width="formLabelWidth">
              <el-input v-model="form.number" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="重量" :label-width="formLabelWidth">
              <el-input v-model="form.weight" autocomplete="off">
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
        const url = this.HOST + '/goods/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('name', this.form.name);
        params.append('number', this.form.number);
        params.append('weight', this.form.weight);

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
        var goodsid = row.id;
        console.log(goodsid);
        this.$axios
          .delete(this.HOST + '/goods/delete/' + goodsid)
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
      this.$axios.get(this.HOST+'/goods/all')
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



