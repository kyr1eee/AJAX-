# AJAX-CORS
前后端编写代码分析AJAX跨域问题.<br>
spring写后台接口, jasmine测试框架.<br>

ps: demo为后端代码, client为前端代码

## jsonp实现原理
1. 前端发送非xhr请求, 请求带有callback参数.若防止浏览器缓存,可添加带时间戳的参数,如jquery中的 _ <br>
2. 后端接收callback参数,返回拼接字符串,application/javascript即js代码,返回以callback参数值命名的函数,该函数传入的实参为请求数据.例:callback(json)<br>
3. 前端动态创建异步script标签,src指向请求地址,获取请求地址返回的js函数.例: 预先定义函数-> var callback = function(data) {//todo}, 动态创建script异步标签，src指向請求地址<br>
4. 此時自動调用该函数,获取实参中的数据,即callback(json)<br>
5. script的onload事件結束后,销毁script标签<br>


前端: 请求带有callback参数,如:http://localhost:8080/test/get1?callback=jQuery111306779623778597157_1552226056754&_=1552226056755,动态创建脚本接收数据.即<script async="" src="http://localhost:8080/test/get1?jsonpCallBack=jQuery111307822147261498273_1552228097560&amp;_=1552228097561"></script>
<br>
后端: spring的AbstractJsonpResponseBodyAdvice接收callback参数, callback为前后端约定的jsonp请求的参数,此时不返回JSON,返回JS代码,即callback参数的调用,jQuery111306779623778597157_1552226056754({"data":"get1 ok"});

