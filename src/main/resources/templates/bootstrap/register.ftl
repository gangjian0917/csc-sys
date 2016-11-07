<#include "./common/layout.ftl">
<@html page_title="注册" page_tab="register">
<div class="row">
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading">
        <a href="/">主页</a> / 注册
      </div>
      <div class="panel-body">
        <#if errors??>
        <div class="alert alert-danger">${errors!}</div>
        </#if>
        <form role="form" action="/register" method="post" id="form">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
          </div>
          <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
          </div>
          <div class="form-group">
            <label for="passwordcheck">再次输入密码</label>
            <input type="password" class="form-control" id="passwordcheck" name="passwordcheck" placeholder="密码">
          </div>
          <div class="form-group">
          <label class="frm_checkbox_label selected" for="js_agree">
                        <i class="icon_checkbox"></i>
                        <span class="lbl_content">我同意并遵守
                            <a href="/protocol" target="_blank">《核心系统社区使用协议》</a>
                        </span>
                    </label>
          </div>
          <button type="submit" class="btn btn-default">立即注册</button>
        </form>
      </div>
    </div>
  </div>
</div>
<script>
  $(function () {
    $("#form").submit(function () {
      var username = $("#username").val();
      var password = $("#password").val();
      if(username.length == 0) {
        layui.msg("用户名不能为空", {icon: 2});
        return false;
      }
      if(password.length == 0) {
        layui.msg("密码不能为空", {icon: 2});
        return false;
      }
    })
  })
</script>
</@html>