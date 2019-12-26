--请求头
local args = ngx.req.get_uri_args()
-- 此处userid 应该要放在header里，而且需要进行hash，而不是直接使用，此处仅仅因为方便测试所以简写了逻辑。
local index = args.userid % 3
ngx.log(ngx.NOTICE, "设置参数变量")
-- 设置缓存
ngx.shared._cache:set("111","222")
-- 获取缓存
ngx.shared._cache:get("111")
--- 设置过期时间
ngx.shared._cache:expire("111",0.5)
--- 设置键值对时，直接设置过期时间
ngx.shared._cache:set("333","333",0.5)

if index == 0 then
  -- 定位到后端某个服务statful-index 这里用百度模拟
  -- pod-index.headless_service_name.name_space.svc.cluster.local
  -- 设置lua.conf 中定义的变量
  ngx.var.backend_host = "www.baidu.com"
elseif index == 1 then
  ngx.var.backend_host = "www.163.com"
elseif index ==2 then
  ngx.var.backend_host = "127.0.0.1"
end
