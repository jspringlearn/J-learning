<template >
  <div>

    <el-container >
        <el-header
          style="height: 134px">
         <h1 style="color: antiquewhite" >欢迎来到物流仓储界面！</h1>
          <h2  style="color: #1f15c7">Welcome to the logistics storage interface!</h2>
        </el-header>

        <el-container
          style="line-height: 100%">
          <el-aside
            width="200px">
            <el-menu
              style="width: 100%"
              default-active="$route.path"
              router="true"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose"
              background-color="#FFFCC8"
              text-color="#2f882c"
              active-text-color="#ffd04b">
              <el-menu-item index="/components/table/site" >
                <i class="el-icon-place"></i>
                <span slot="title">地点信息</span>
              </el-menu-item>

              <el-menu-item index="/components/table/goods" >
                <i class="el-icon-s-grid"></i>
                <span slot="title">货物信息</span>
              </el-menu-item>

              <el-menu-item index="/components/table/order" >
                <i class="el-icon-document"></i>
                <span slot="title">订单信息</span>
              </el-menu-item>

              <el-menu-item index="/components/table/employee">
                <i class="el-icon-bicycle"></i>
                <span slot="title">员工信息</span>
              </el-menu-item>
              <el-menu-item index="5" >
                <i class="el-icon-truck"></i>
                <span slot="title">车辆信息</span>
              </el-menu-item>
              <el-menu-item index="/components/table/road" >
                <i class="el-icon-discover
                el"></i>
                <span slot="title">线路信息</span>
              </el-menu-item>
              <el-menu-item index="/components/table/feedback" >
                <i class="el-icon-service"></i>
                <span slot="title">反馈信息</span>
              </el-menu-item>
              <el-menu-item index="/components/table/management" >
                <i class="el-icon-user-solid"></i>
                <span slot="title">管理员信息</span>
              </el-menu-item>

            </el-menu>
          </el-aside>

        <el-main>
          <router-view></router-view>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>


<script>

</script>

<style>
  .el-header {
    background-color: #669161;
    color: #adadad;
    text-align: center;

    line-height: 200%;
  }

  .el-aside {
    background-color: #f5f2ff;
    color: #e5292e;
    text-align: center;
    line-height: 500px;
  }

  .el-main {
    background-color: #ffffff;
    color: #afafaf;
    text-align: center;
    line-height: 10px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
