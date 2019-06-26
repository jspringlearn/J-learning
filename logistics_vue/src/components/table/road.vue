
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 120%">
    <el-table-column
      label="线路名"
      width="200">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.entityName}}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="运输距离"
      width="200">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.distance }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="时间" sortable
      width="200">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.elapTime }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="起始地点"
      width="200">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 20px">{{ scope.row.aSite }}</span>
      </template>
    </el-table-column>

      <el-table-column
        label="终止地点"
        width="200">
        <template slot-scope="scope">
          <!--<i class="el-icon-time"></i>-->
          <span style="margin-left: 10px">{{ scope.row.bSite }}</span>
        </template>
      </el-table-column>
    <el-table-column  label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        < <el-dialog title="添加线路" :visible.sync="dialogFormVisible">
            <el-form :model="from">
              <el-form-item label="线路名" :label-width="formLabelWidth">
                <el-input v-model="form.entityName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="距离" :label-width="formLabelWidth">
                <el-input v-model="form.distance" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="时长" :label-width="formLabelWidth">
                <el-input v-model="form.elapTime" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="起点" :label-width="formLabelWidth">
                <el-input v-model="form.aSite" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="终点" :label-width="formLabelWidth">
                <el-input v-model="form.bSite" autocomplete="off">
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

        <el-dialog title="修改线路" :visible.sync="dialogUpFrom" :close-on-click-modal="false">
        <el-form :model="upform"  label-width="80px"  ref="upfrom">
          <el-form-item label="线路名" prop="name" >
            <el-input v-model="upform.entityName" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="距离" >
            <el-input v-model="upform.distance" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="时长" >
            <el-input v-model="upform.elapTime" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="起点" >
            <el-input v-model="upform.aSite" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="终点" >
            <el-input v-model="upform.bSite" auto-complete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogUpFrom = false">取 消</el-button>
          <el-button type="primary" @click="updaFrom">确 定</el-button>
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
        dialogUpFrom: false,
        form: {
          entityName:'',
          distance: '',
          elapTime: '',
          aSite:'',
          bSite:'',
        },
        formLabelWidth: '120px',
        upform: {
          entityName:'',
          distance: '',
          elapTime: '',
          aSite:'',
          bSite:'',
        },
      }
    },
    methods: {
      update:function(index,row) {
        this.dialogUpFrom=true;
        this.upform=Object.assign({},row);
      },
      postForm() {
        const url = this.HOST + '/road/save';
        this.dialogFormVisible = false;
        var params = new URLSearchParams();
        params.append('entityName', this.form.entityName);
        params.append('distance', this.form.distance);
        params.append('elapTime', this.form.elapTime);
        params.append('aSite', this.form.aSite);
        params.append('bSite', this.form.bSite);
        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params
        })
          .catch(function (error) {
            console.log(error);

          });

        location. reload()
        this.$router.go(0)

      },
      updaFrom(){
        const url=this.HOST+ '/road/update';
        this.dialogUpFrom=false;
        var params =new URLSearchParams();
        params.set('id',this.upform.id);
        params.set('entityName', this.upform.entityName);
        params.set('distance', this.upform.distance);
        params.set('elapTime', this.upform.elapTime);
        params.set('aSite', this.upform.aSite);
        params.set('bSite', this.upform.bSite);
        this.$axios({
          method: 'post',
          url: url,
          data: params
        })
          .catch(function (error) {
            console.log(error);

          });
        clearTimeout(4000);
        location. reload()
        this.$router.go(0)
      },
      handleDelete(index, row) {
        console.log(index, row);
        var expenditureId = row.id;
        console.log(expenditureId);
        this.$axios
          .delete(this.HOST + '/road/delete/' + expenditureId)
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
      this.$axios.get(this.HOST+'/road/all')
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
