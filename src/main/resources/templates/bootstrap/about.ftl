<#include "common/layout.ftl"/>
<@html page_tab="about" page_title="关于 - ${siteTitle!}">
<div class="row">
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading"><a href="/">主页</a> / 关于</div>
      <div class="panel-body topic-detail-content">
        <p>社区（论坛）系统.</p>
        <p>Thanks <a href="https://github.com/tomoya92/pybbs" target="_blank">pybbs</a>（朋也社区）</p>
        <p>layout reference:  
          <a href="https://cnodejs.org" target="_blank">cnodejs</a>,
          <a href="https://v2ex.com" target="_blank">v2ex</a>
        </p>
        <p>
          commit <a href="https://github.com/myjamesd/csportal/issues" target="_blank">issues</a>
        </p>
        <p>open source:
        <ul>
          <li>
            <a href="https://github.com/myjamesd/csportal"
                       target="_blank">https://github.com/myjamesd/csportal</a>
          </li>
        </ul>
        <p>technology:
        <ul>
          <li>java</li>
          <li>tomcat / jetty</li>
          <li>jfinal</li>
          <li>mysql(druid datasource)</li>
          <li>freemarker</li>
          <li>bootstrap</li>
          <li>redis</li>
          <li>solr</li>
        </ul>
      </div>
    </div>
  </div>
  <div class="col-md-3 hidden-sm hidden-xs"></div>
</div>
</@html>
