<#include "../../common/layout.ftl"/>
<@html page_title="匿名吐槽" page_tab="suggestion">
<div class="row">
  <div class="col-md-3 hidden-sm hidden-xs">
    <#include "../../components/admin_left.ftl">
    <@admin_left page_tab="suggestion"/>
  </div>
  <div class="col-md-9">
    <div class="row">
      <div class="col-md-10">
        <div class="panel panel-default">
          <div class="panel-heading">
            吐槽管理
            <!--
            <#if _roles?seq_contains("suggestion:add")>
              <a class="pull-right" href="/admin/suggestion/add?pid=${pid!}">添加权限</a>
            </#if>
			-->
          </div>
          <div class="table-responsive">
            <table class="table table-striped table-responsive">
              <tbody>
                <#list page.getContent() as suggestion>
                <tr>
                  <td>${suggestion.id!}</td>
                  <td>
                  <#if _roles?seq_contains("suggestion:edit")>
                  <a href="/admin/suggestion/${suggestion.id}/detail">
			      </#if>
					${suggestion.title!}
					<#if _roles?seq_contains("suggestion:edit")>
					</a>
					</#if>
					</td>
                  <td>${suggestion.inTime!}</td>
                  <td>
                    <#if _roles?seq_contains("suggestion:edit")>
                      <a href="/admin/suggestion/${suggestion.id}/detail" class="btn btn-xs btn-warning">查看</a>
                    </#if>
                    <#if _roles?seq_contains("suggestion:delete")>
                      <a href="javascript:if(confirm('确认删除吗?')) location.href='/admin/suggestion/${suggestion.id!}/delete'"
                        class="btn btn-xs btn-danger">删除</a>
                    </#if>
                  </td>
                </tr>
                </#list>
              </tbody>
            </table>
          </div>
        </div>
      </div>
  </div>
</div>
</@html>