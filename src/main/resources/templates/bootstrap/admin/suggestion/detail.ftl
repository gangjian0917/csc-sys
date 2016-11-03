<#include "../../common/layout.ftl"/>
<@html page_title="配置角色">
<div class="row">
  <div class="col-md-3 hidden-sm hidden-xs">
    <#include "../../components/admin_left.ftl">
    <@admin_left page_tab="suggestion"/>
  </div>
  
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-body suggestion-detail-header">
        <div class="media">
          <div class="media-body">
            <h2 class="suggestion-detail-title">${suggestion.title!}</h2>
            <p class="gray">
              <span>${suggestion.formatDate(suggestion.inTime)}</span>
              <span>•</span>
            </p>
          </div>
        </div>
      </div>
      <#if suggestion.content?? && suggestion.content != "">
        <div class="divide"></div>
        <div class="panel-body suggestion-detail-content">
        ${suggestion.markedNotAt(suggestion.content)}
        </div>
      </#if>
    </div>
    <#if suggestion.replyCount == 0>
      <div class="panel panel-default">
        <div class="panel-body text-right">未读     <a href="/admin/suggestion/list">返回</a></div>
      </div>
    <#else>
        <div class="panel-body text-right">已阅读 ${suggestion.replyCount!0} 次     <a href="/admin/suggestion/list">返回</a></div>
      </div>
    </#if>
  </div>
</div>
<link rel="stylesheet" href="/static/bootstrap/css/jquery.atwho.min.css"/>
<script type="text/javascript" src="/static/bootstrap/js/jquery.atwho.min.js"></script>
<script type="text/javascript" src="/static/bootstrap/js/lodash.min.js"></script>
<link rel="stylesheet" href="/static/bootstrap/libs/editor/editor.css"/>
<style>
  .CodeMirror {
    height: 150px;
  }
</style>
<script type="text/javascript" src="/static/bootstrap/js/highlight.min.js"></script>
<script type="text/javascript" src="/static/bootstrap/libs/webuploader/webuploader.withoutimage.js"></script>
<script type="text/javascript" src="/static/bootstrap/libs/markdownit.js"></script>
<script type="text/javascript" src="/static/bootstrap/libs/editor/editor.js"></script>
<script type="text/javascript" src="/static/bootstrap/libs/editor/ext.js"></script>
</@html>