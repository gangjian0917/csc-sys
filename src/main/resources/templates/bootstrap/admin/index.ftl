<#include "../common/layout.ftl">
<@html page_title="首页">
<div class="row">
  <div class="col-md-3 hidden-sm hidden-xs">
    <#include "../components/admin_left.ftl">
    <@admin_left page_tab="index"/>
  </div>
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading">仪表盘</div>
    </div>
    
	<section class="content">
    <div class="row">
        <div class="col-md-6">
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">今天吐槽</h3>
                        <small>共${suggestions.getContent()?size}条</small>
                    </div>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                                <#list suggestions.getContent() as suggestion>
                                <tr>
                                    <td><a href="${baseUrl!}/suggestion/${suggestion.id!}"
                                           >${suggestion.title!}</a></td>
                                    <td width="145px">${suggestion.inTime}</td>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
               </div>
        	
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">今天回复</h3>
                        <small>共${replies.getContent()?size}条</small>
                    </div>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                                <#list replies.getContent() as reply>
                                <tr>
                                    <td>
                                        <a href="javascript:;" data-toggle="modal"
                                           data-target="#reply_${reply.id!}">${reply.topic.title!}</a>
                                        <div class="modal fade" id="reply_${reply.id!}" tabindex="-1" role="dialog"
                                             aria-labelledby="myModalLabel">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close"><span
                                                                aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title" id="myModalLabel">${reply.topic.title!}</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        ${reply.content!}
                                                    </div>
                                                    <div class="modal-footer">
                                                        <a href="${baseUrl!}/topic/${reply.topic.id!}#${reply.id!}"
                                                           target="_blank" class="btn btn-raised btn-default">查看</a>
                                                        <button type="button" class="btn btn-raised btn-default"
                                                                data-dismiss="modal">关闭
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td width="145px">${reply.inTime}</td>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
                
        </div>
        
        <div class="col-md-6">
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">今天话题</h3>
                        <small>共${topics.getContent()?size}条</small>
                    </div>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                                <#list topics.getContent() as topic>
                                <tr>
                                    <td><a href="${baseUrl!}/topic/${topic.id!}"
                                           target="_blank">${topic.title!}</a></td>
                                    <td width="145px">${topic.inTime}</td>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
                
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">今天用户</h3>
                        <small>共${users.getContent()?size}条</small>
                    </div>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>邮箱</th>
                                <th>昵称</th>
                                <th>时间</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list users.getContent() as user>
                                <tr>
                                    <td>${user.id!}</td>
                                    <td><a href="mailto:${user.email!}">${user.email!}</a></td>
                                    <td>${user.username!}</td>
                                    <td width="145px">${user.inTime}</td>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
              </div>
        </div>
        
        
    </div>
    
    
    
</section>
	
	
</div>
</div>
</@html>