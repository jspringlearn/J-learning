
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 120%">

    <el-table-column
      label="评论时间" sortable
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.commentTime }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="评论内容"
      width="260">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 20px">{{ scope.row.commentContent }}</span>
      </template>
    </el-table-column>


    <el-table-column  label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="新增评论信息" :visible.sync="dialogFormVisible">
            <el-form :model="from">
              <el-form-item label="评论内容" :label-width="formLabelWidth">
                <el-input v-model="form.commentContent" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="发布时间" :label-width="formLabelWidth">
                <el-input v-model="form.commentTime" autocomplete="off">
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
          commentContent:'',
          commentTime: '',

        },
        formLabelWidth: '120px',
      }
    },
    methods: {
      update(index,row) {

      },
      postForm() {
        const url = this.HOST + '/comment/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('commentContent', this.form.commentContent);
        params.append('commentTime', this.form.commentTime);

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
        var commentid = row.id;
        console.log(commentid);
        this.$axios
          .delete(this.HOST + '/comment/delete/' + commentid)
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
      this.$axios.get(this.HOST+'/comment/all')
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
