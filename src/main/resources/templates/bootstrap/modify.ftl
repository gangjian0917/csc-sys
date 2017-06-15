<#include "./common/layout.ftl">
<@html page_title="修改密码" page_tab="modify">
<div class="row">
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading">
        <a href="/">主页</a> / 修改密码
      </div>
      <div class="panel-body">
        <#if errors??>
        <div class="alert alert-danger">${errors!}</div>
        </#if>
        <form role="form" action="/modify" method="post" id="form">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" disabled class="form-control" id="username" value="${user.username}"/>
          </div>
          <div class="form-group">
            <label for="password">原密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="原密码">
          </div>
          <div class="form-group">
            <label for="password">新密码</label>
            <input type="password" class="form-control" id="passwordnew" name="passwordnew" placeholder="新密码">
          </div>
          <div class="form-group">
            <label for="passwordcheck">再次输入新密码</label>
            <input type="password" class="form-control" id="passwordnewcheck" name="passwordnewcheck" placeholder="新密码">
          </div>
          <button type="submit" class="btn btn-default">修改</button>
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