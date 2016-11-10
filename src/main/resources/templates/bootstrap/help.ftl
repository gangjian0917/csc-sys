<#include "common/layout.ftl"/>
<@html page_tab="help" page_title="关于 - ${siteTitle!}">
<div class="row">
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading"><a href="/">主页</a> / 帮助</div>
      <div class="panel-body topic-detail-content">
      	<p><b>用户账户</b></p>
      	<p>1.账号由用户自由设定，不强制要求实名，方便用户自由发布话题</p>
      	<p>2.暂无找回密码功能，请用户谨记密码。密码丢失，只能重新注册^_^</p>
      
        <p><b>发布话题</b></p>
        	话题可发布到不同板块，方便分类管理，目前提供以下板块：
        <#list sections as section>
            <div >-- ${section}</div>
        </#list>
		<br>
		其中，'管理通告-非公开回复'，是指：<br>
		1.用户不能互看回复内容<br>
		2.用户只能查看楼主的回复 和 用户自己发出的回复<br>
		3.如果楼主的回复中有@用户，则只有楼主 和 被@的用户才能看到这条回复<br>
		<p>
        <p><b>匿名吐槽</b></p>
        <p>
        1.发出的内容完全匿名，只有管理员才能看到<br>
        2.后台没有记录用户信息，用户自己也无法查看。如果期待管理员的回复，请在内容中留下你的联系方式（如邮箱）<br>
   3.可以是建议、吐槽、赞美、表扬，或者表达爱慕之情，工作或生活上的想法、困扰，或者内心的快乐需要分享...<br>
   4.希望大家能够文明用语，展现自己的素养，提出的建议，最好是有建设性的，自己思考过的<br>
        </p>
        
        <p><b>客户端</b></p>
        <p>在开发中...</p>
      </div>
    </div>
  </div>
  <div class="col-md-3 hidden-sm hidden-xs"></div>
</div>
</@html>
